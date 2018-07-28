class RecipeModel {
  const RecipeModel(this.recipeId, this.recipeName, this.photoUrl,
      this.introduction, this.recommendFlg);

  final String recipeId;
  final String recipeName;
  final String photoUrl;
  final String introduction;
  final bool recommendFlg;

  factory RecipeModel.fromJson(json) {
    var recipeId = json["recipe_id"];
    var recipeName = json["recipe_name"];
    var photoUrl = json["main_gazo"];
    var introduction = json["introduction"];
    var recommendedFlg = int.parse(json["recommended_flg"]);

    return RecipeModel(recipeId, recipeName, photoUrl, introduction,
        recommendedFlg == 1 ? true : false);
  }
}
