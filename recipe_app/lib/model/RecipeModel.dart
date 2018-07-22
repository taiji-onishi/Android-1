class RecipeModel {
  const RecipeModel(this.recipeName, this.photoUrl,
      this.introduction, this.recommendFlg);

  final String recipeName;
  final String photoUrl;
  final String introduction;
  final int recommendFlg;

  factory RecipeModel.fromJson(json) {
    var recipeName = json["recipe_name"];
    var photoUrl = json["main_gazo"];
    var introduction = json["introduction"];
    var recommendedFlg = int.parse(json["recommended_flg"]);

    return RecipeModel(
         recipeName, photoUrl, introduction, recommendedFlg);
  }
}
