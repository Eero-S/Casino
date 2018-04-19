package kasinoPackage
import scala.collection.mutable.Buffer

class Board(var cards: Buffer[Card]) {
  override def toString = {
    if(cards.length == 0){
      "The board is empty"
    } else {
      cards.mkString(", ")
    }
  }

  def add(card: Card) = {
    cards += card
  }

  def take(c: Seq[Card]) = {
    cards --= c
  }
}