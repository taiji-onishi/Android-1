class Ingredients {
  const Ingredients(this.material, this.quantity);

  final String material;
  final String quantity;

  factory Ingredients.fromJson(json) {
    var material = json["material"];
    var quantity = json["quantity"];

    return Ingredients(material, quantity);
  }
}
