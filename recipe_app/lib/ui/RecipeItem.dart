import 'package:flutter/material.dart';
import 'package:recipe_app/model/RecipeModel.dart';
import 'package:recipe_app/ui/RecipeDetail.dart';

class RecipeItem extends StatefulWidget {
  const RecipeItem({Key key, @required this.recipe})
      : assert(recipe != null),
        super(key: key);

  final RecipeModel recipe;

  @override
  _RecipeItemState createState() => new _RecipeItemState();
}

class _RecipeItemState extends State<RecipeItem> {
  final String _recommendedLabel = "おすすめ";

  @override
  Widget build(BuildContext context) {
    final RecipeModel _recipe = widget.recipe;
    return GestureDetector(
      child: new Card(
        child: new InkWell(
          onTap: (){
            moveToDetail(_recipe);
          },
          child: new Padding(
            padding: const EdgeInsets.only(bottom: 12.0),
            child: new Stack(
              alignment: Alignment.center,
              children: [
                new Column(
                  crossAxisAlignment: CrossAxisAlignment.stretch,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    // Image
                    new Container(
                      child: new Image.network(_recipe.photoUrl),
                    ),
                    // recommendFlgで分岐
                    // T: おすすめのラベルを表示、F:表示しない
                    _recipe.recommendFlg
                        ? Center(
                            child: new Container(
                              color: Colors.amber,
                              margin: EdgeInsets.only(top: 8.0),
                              child: new Text(
                                _recommendedLabel,
                                style: TextStyle(
                                  color: Colors.white,
                                ),
                              ),
                            ),
                          )
                        : Center(),
                    // 料理名
                    new Center(
                      child: new Container(
                        padding: EdgeInsets.only(top: 8.0),
                        child: new Text(
                          _recipe.recipeName,
                          style: TextStyle(
                            fontWeight: FontWeight.bold,
                            fontSize: 16.0,
                            color: Colors.red,
                          ),
                        ),
                      ),
                    ),
                    // 説明文言
                    new Center(
                      child: new Container(
                        padding: EdgeInsets.only(top: 8.0),
                        child: new Text(_recipe.introduction),
                      ),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void moveToDetail(RecipeModel recipe) {
    Navigator.of(context).push(new MaterialPageRoute(builder: (context) {
      return new RecipeDetail(recipe: recipe);
    }));
  }
}
