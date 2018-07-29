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
      body: new Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: <Widget>[
          // Image
          new Container(
            child: new Image.network(_recipeModel.photoUrl),
          ),
          new Container(
            padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
            child: new Text(
              _recipeModel.introduction,
              style: TextStyle(fontSize: 20.0),
            ),
          ),
          new Container(
            padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
            child: new Text(
              "材料",
              style: TextStyle(fontSize: 20.0),
            ),
          ),
          new Expanded(
            child: new ListView.builder(
              primary: false,
              itemCount: _ingredient.length,
              itemBuilder: (context, index) {
                return new Container(
                  padding: EdgeInsets.symmetric(horizontal: 8.0),
                  child: new Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: <Widget>[
                      new Text(_ingredient[index].material),
                      new Text(_ingredient[index].quantity),
                    ],
                  ),
                );
              },
            ),
          ),
          
          new Container(
            padding: EdgeInsets.only(top: 8.0, left: 8.0, right: 8.0),
            child: new Text(
              "調理方法",
              style: TextStyle(fontSize: 20.0),
            ),
          ),
          new Expanded(
            child: new ListView.builder(
              primary: false,
              itemCount: _methods.length,
              itemBuilder: (context, index) {
                return new Container(
                  child: new Stack(
                    children: <Widget>[
                      new Row(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: <Widget>[
                          new Text(_methods[index].no + "."),
                          new Expanded(
                            child: Text(_methods[index].procedure),
                          ),
                        ],
                      ),
                      new Divider(
                        height: 2.0,
                      ),
                    ],
                  ),
                );
              },
            ),
          ),
        ],
      ),
    );
  }
}
