package kasinoPackage

class Card(val valueHand: Int, val valueTable: Int, val suit: String, val name: String) {
  override def toString = suit + "-" + name
}