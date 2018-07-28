import 'package:flutter/material.dart';
import 'package:recipe_app/ui/RecipePage.dart';

void main() => runApp(new Main());

class Main extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => new MainState();

}

class MainState extends State<Main>{
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: DefaultTabController(
        length: 2,
        child: Scaffold(
          appBar: AppBar(
            backgroundColor: Colors.red,
            bottom: TabBar(
              indicatorColor: Colors.amber,
              indicatorWeight: 3.0,
              tabs: [
                Tab(text: "すべて",),
                Tab(text: "おすすめ",),
              ],
            ),
            title: Text('Recipe App'),
          ),
          body: TabBarView(
            children: [
              RecipePage(recommendedFlag: false,),
              RecipePage(recommendedFlag: true,),
            ],
          ),
        ),
      ),
    );
  }
}
