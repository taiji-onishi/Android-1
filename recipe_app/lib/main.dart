import 'package:flutter/material.dart';
import 'package:recipe_app/ui/TabPage.dart';

void main() => runApp(new Main());

class Main extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: TabPage(),
    );
  }
}
