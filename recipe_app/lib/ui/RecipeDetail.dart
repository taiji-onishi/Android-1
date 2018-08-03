import 'package:flutter/material.dart';
import 'package:recipe_app/model/CookingMethod.dart';
import 'package:recipe_app/model/Ingredients.dart';
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
    List<Ingredients> _ingredient = _recipeModel.ingredients.values.toList();
    List<CookingMethod> _methods = _recipeModel.cookingMethod.values.toList();
    return new Scaffold(
      appBar: new AppBar(
        backgroundColor: Colors.red,
        title: Text(_recipeModel.recipeName),
      ),
      body: new ListView.builder(
          itemCount: _ingredient.length + _methods.length + 2,
          itemBuilder: (context, index) {
            return _buildDetailItem(context, index);
          }),
    );
  }

  Widget _buildDetailItem(BuildContext context, int position) {
    RecipeModel _recipeModel = widget.recipe;
    List<Ingredients> _ingredient = _recipeModel.ingredients.values.toList();
    List<CookingMethod> _methods = _recipeModel.cookingMethod.values.toList();
    if (position == 0) {
      return new Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          new Container(
            child: new Image.network(_recipeModel.photoUrl),
          ),
          new Center(
            child: new Container(
              padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
              child: new Text(
                _recipeModel.introduction,
                style: TextStyle(fontSize: 16.0),
              ),
            ),
          ),
          new Container(
            padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
            child: new Text(
              "材料",
              style: TextStyle(
                fontSize: 16.0,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
        ],
      );
    } else if (position < _ingredient.length + 1) {
      return new Container(
        padding: EdgeInsets.symmetric(horizontal: 8.0),
        child: new Row(
          mainAxisAlignment: MainAxisAlignment.spaceBetween,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: <Widget>[
            new Text(_ingredient[position - 1].material),
            new Text(_ingredient[position - 1].quantity),
          ],
        ),
      );
    } else if (position < _ingredient.length + 2) {
      return new Container(
        padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
        child: new Text(
          "調理方法",
          style: TextStyle(
            fontSize: 16.0,
            fontWeight: FontWeight.bold,
          ),
        ),
      );
    } else if (position < _ingredient.length + _methods.length + 2) {
      return new Container(
        margin: EdgeInsets.only(bottom: 8.0, left: 8.0, right: 8.0),
        child: new Stack(
          children: <Widget>[
            new Row(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                new Text(
                    _methods[position - (_ingredient.length + 2)].no + "."),
                new Expanded(
                  child: Text(
                      _methods[position - (_ingredient.length + 2)].procedure),
                ),
              ],
            ),
          ],
        ),
      );
    }
    return Container();
  }
}
