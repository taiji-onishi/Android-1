import 'package:flutter/material.dart';
import 'package:recipe_app/model/RecipeModel.dart';

class RecipeDetail extends StatefulWidget {
  const RecipeDetail({Key key, @required this.recipe})
      : assert(recipe != null),
        super(key: key);

  final RecipeModel recipe;

  @override
  RecipeDetailState createState() => new RecipeDetailState();
}

class RecipeDetailState extends State<RecipeDetail> {
  @override
  Widget build(BuildContext context) {
    RecipeModel _recipeModel = widget.recipe;
    return MaterialApp(
      title: "Recipe App",
      home: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.red,
            title: Text("Recipe App"),
          ),
          body: new Center(
            child: new Image.network(_recipeModel.photoUrl),
          ),
      ),
    );
  }
}
