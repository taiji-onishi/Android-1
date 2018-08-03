import 'package:recipe_app/model/CookingMethod.dart';
import 'package:recipe_app/model/Ingredients.dart';

class RecipeModel {
  const RecipeModel(
      this.recipeId,
      this.recipeName,
      this.photoUrl,
      this.introduction,
      this.recommendFlg,
      this.ingredients,
      this.cookingMethod);

  final String recipeId;
  final String recipeName;
  final String photoUrl;
  final String introduction;
  final bool recommendFlg;
  final Map<String, Ingredients> ingredients;
  final Map<String, CookingMethod> cookingMethod;

  factory RecipeModel.fromJson(json) {
    var recipeId = json["recipe_id"];
    var recipeName = json["recipe_name"];
    var photoUrl = json["main_gazo"];
    var introduction = json["introduction"];
    var recommendedFlg = int.parse(json["recommended_flg"]);

    Map<String, Ingredients> ingredientMap = new Map<String, Ingredients>();
    var ingredientsData = json["cooking_ingredients"];
    for (var ingredient in ingredientsData) {
      ingredientMap[ingredient['material']] = Ingredients.fromJson(ingredient);
    }

    Map<String, CookingMethod> methodMap = new Map<String, CookingMethod>();
    var methods = json["cooking_method"];
    for (var method in methods) {
      methodMap[method['procedure_no']] = CookingMethod.fromJson(method);
    }

    return RecipeModel(recipeId, recipeName, photoUrl, introduction,
        recommendedFlg == 1 ? true : false, ingredientMap, methodMap);
  }
}
