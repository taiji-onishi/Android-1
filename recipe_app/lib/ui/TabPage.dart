import 'package:flutter/material.dart';
import 'package:recipe_app/ui/RecipePage.dart';

class TabPage extends StatefulWidget {
  const TabPage({Key key}) : super(key: key);

  @override
  _TabPageState createState() => new _TabPageState();
}

class _TabPageState extends State<TabPage> with TickerProviderStateMixin {
  TabController _controller;
  List<Tab> _tabs = <Tab>[
    new Tab(text: "すべて"),
    new Tab(text: "おすすめ"),
  ];

  @override
  void initState() {
    _controller = new TabController(length: _tabs.length, vsync: this);
    super.initState();
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: new AppBar(
        title: Text('Recipe App'),
        backgroundColor: Colors.red,
        bottom: new TabBar(
          controller: _controller,
          indicatorColor: Colors.amber,
          indicatorWeight: 3.0,
          tabs: _tabs,
        ),
      ),
      body: new TabBarView(
        controller: _controller,
        children: [
          new RecipePage(
            recommendedFlag: false,
          ),
          new RecipePage(
            recommendedFlag: true,
          ),
        ],
      ),
    );
  }
}
