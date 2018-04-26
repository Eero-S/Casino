package kasinoPackage
import scala.collection.mutable.Buffer

// Represents the neutral cards of the game. 
class Board(var cards: Buffer[Card]) {

  override def toString = if (cards.length == 0) "The board is empty" else cards.mkString(", ")

  // Adds card to board.
  def add(card: Card) = {
    cards += card
  }
  // Removes cards from board.
  def take(c: Seq[Card]) = {
    cards --= c
  }
}