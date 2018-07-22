import 'package:flutter/material.dart';
import 'package:recipe_app/model/RecipeModel.dart';

class RecipeItem extends StatefulWidget {
  const RecipeItem({Key key, @required this.recipe})
      : assert(recipe != null),
        super(key: key);

  final RecipeModel recipe;

  @override
  _RecipeItemState createState() => new _RecipeItemState();
}

class _RecipeItemState extends State<RecipeItem> {
  @override
  Widget build(BuildContext context) {
    final RecipeModel _recipe = widget.recipe;

    return Image.network(_recipe.photoUrl);
  }
}
//      child: new InkWell(
//        child: new Padding(
//          padding: const EdgeInsets.all(16.0),
//          child: new Stack(
//            children: [
//              new Column(
//                crossAxisAlignment: CrossAxisAlignment.stretch,
//                mainAxisAlignment: MainAxisAlignment.start,
//                children: <Widget>[
////                  new Image(
////                    decoration: new BoxDecoration(
////                      image: new DecorationImage(
////                        image: LevelImage.getAssetImage(_session.level),
////                        fit: BoxFit.cover,
////                      ),
////                    ),
////                  ),
////                  new Text(
////                    "${Strings.of(context).day(widget.session
////                        .getDay())}   $startAt - $endAt / ${_session.room
////                        .name}",
////                    style: timeStyle,
////                  ),
////                  new Container(
////                      padding: const EdgeInsets.only(top: 12.0),
////                      child: new Text(_session.title, style: titleStyle)),
//                  new DefaultTextStyle(
//                    style: TextStyle(color: Colors.black),
//                    softWrap: false,
//                    overflow: TextOverflow.ellipsis,
//                    maxLines: 3,
//                    child: new Padding(
//                      child: new Text(_recipe.introduction),
//                      padding: const EdgeInsets.only(top: 12.0, bottom: 8.0),
//                    ),
//                  ),
////                  new Row(
////                    children: [
////                      new Container(
////                        width: 24.0,
////                        height: 24.0,
////                        margin: const EdgeInsets.only(right: 8.0),
////                        decoration: new BoxDecoration(
////                          image: new DecorationImage(
////                            image: LevelImage.getAssetImage(_session.level),
////                            fit: BoxFit.cover,
////                          ),
////                        ),
////                      ),
////                      new Expanded(
////                        child: new Text(
////                          _session.topic.name,
////                          style: topicStyle,
////                        ),
////                      ),
////                    ],
////                  ),
////                  new Padding(
////                    child: new Column(
////                      children: _createSpeakerRows(
////                          _session.speakers, speakerNameStyle),
////                    ),
////                    padding: const EdgeInsets.only(top: 8.0),
////                  )
////                ],
////              ),
//
////              new Positioned(
////                bottom: -8.0,
////                right: -8.0,
////                child: new FavoriteButton(
////                  session: _session,
////                  googleSignIn: googleSignIn,
////                  favorite: _favorite,
////                  onChanged: (value) {
////                    setState(() => _favorite = value);
////                  },
////                ),
////              ),
////            ],
////          ),
////        ],
////    ),
////      ),
////      ),
////    );
////  }
////}
