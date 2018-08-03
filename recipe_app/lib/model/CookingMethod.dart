class CookingMethod {
  const CookingMethod(this.no, this.procedure);

  final String no;
  final String procedure;

  factory CookingMethod.fromJson(json) {
    var no = json["procedure_no"];
    var procedure = json["procedure"];

    return CookingMethod(no, procedure);
  }
}
