import 'dart:async';
import 'package:recipe_app/model/RecipeModel.dart';

abstract class RecipeApi {
  Future<Map<String, RecipeModel>> getRecipe({bool refresh});
}