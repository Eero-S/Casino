package kasinoPackage

// Represents the cards used in the game.
class Card(val valueHand: Int, val valueTable: Int, val suit: String, val name: String, val points: Int, val picIndex: Int) {
  
  override def toString = {
    if(valueTable >= 10){
    suit.head.toLower + valueTable.toString() + " " + picIndex
    } else {
      suit.head.toLower + 0.toString() + valueTable.toString() + " " + picIndex
    }
  }
}