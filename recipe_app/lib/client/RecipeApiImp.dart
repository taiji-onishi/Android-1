import 'dart:async';
import 'dart:convert';

import 'package:http/http.dart' as http;
import 'package:recipe_app/client/RecipeApi.dart';
import 'package:recipe_app/model/RecipeModel.dart';

class RecipeApiImp implements RecipeApi {
  static const String _api_path = "http://localhost:3000/recipe";

  var _recipeMap = new Map<String, RecipeModel>();

  @override
  Future<Map<String, RecipeModel>> getRecipe({bool refresh = false}) async {
    if (refresh || _recipeMap.isEmpty) {
      await _request();
    }
    return _recipeMap;
  }

  _request() async {
    var response = await http.read(_api_path + "?.json");
    var json = JSON.decode(response);
    Map itemMap = new Map<String, RecipeModel>();

    for (var item in json) {
      itemMap[item['recipe_id']] = RecipeModel.fromJson(item);
    }
    _recipeMap = itemMap;
  }
}
