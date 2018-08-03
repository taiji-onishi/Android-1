import 'dart:async';

import 'package:recipe_app/api/RecipeApi.dart';
import 'package:recipe_app/model/RecipeModel.dart';

class RecipeRepository {
  RecipeApi _recipeApi;

  RecipeRepository(this._recipeApi);

  Future<List<RecipeModel>> findAll() {
    return _recipeApi.getRecipe().then((recipe) {
      return recipe.values.toList();
    });
  }

  Future<RecipeModel> find(String id) {
    return _recipeApi.getRecipe().then((recipe) {
      return recipe[id];
    });
  }
}
