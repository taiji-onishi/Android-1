import 'package:flutter/material.dart';
import 'package:recipe_app/api/RecipeApi.dart';
import 'package:recipe_app/model/RecipeModel.dart';
import 'package:recipe_app/repository/RecipeRepository.dart';
import 'package:recipe_app/ui/RecipeItem.dart';

class RecipePage extends StatefulWidget {
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
        .then((recipe) => setRecipe(recipe));
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "Recipe App",
      home: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.red,
            title: Text("Recipe App"),
          ),
          body: _buildBody()),
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

  void setRecipe(List<RecipeModel> recipes) {
    setState(() {
      _items = recipes;
      _loadingInProgress = recipes.isEmpty;
    });
  }
}
