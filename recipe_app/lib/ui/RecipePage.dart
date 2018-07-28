import 'package:flutter/material.dart';
import 'package:recipe_app/api/RecipeApi.dart';
import 'package:recipe_app/model/RecipeModel.dart';
import 'package:recipe_app/repository/RecipeRepository.dart';
import 'package:recipe_app/ui/RecipeItem.dart';

class RecipePage extends StatefulWidget {
  final bool recommendedFlag;

  const RecipePage({Key key, this.recommendedFlag}) : super(key: key);

  @override
  AllRecipePageState createState() => new AllRecipePageState();
}

class AllRecipePageState extends State<RecipePage> {
  List<RecipeModel> _items = [];
  bool _loadingInProgress;

  @override
  void initState() {
    super.initState();
    _loadingInProgress = true;
    new RecipeRepository(new RecipeApi())
        .findAll()
        .then((recipe) => _setRecipe(recipe, widget.recommendedFlag));
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: _buildBody(),
      ),
    );
  }

  Widget _buildBody() {
    if (_loadingInProgress) {
      return new Center(
        child: new CircularProgressIndicator(),
      );
    } else {
      return new ListView.builder(
        itemCount: _items.length,
        itemBuilder: (context, index) {
          RecipeModel item = _items[index];
          return RecipeItem(recipe: item);
        },
      );
    }
  }

  void _setRecipe(List<RecipeModel> recipes, bool recommendedFlag) {
    setState(() {
      _items = recommendedFlag ? _createRecommendList(recipes) : recipes;
      _loadingInProgress = recipes.isEmpty;
    });
  }

  List<RecipeModel> _createRecommendList(List<RecipeModel> list) {
    List<RecipeModel> result = [];
    for (RecipeModel item in list) {
      if (item.recommendFlg) result.add(item);
    }
    return result;
  }
}
