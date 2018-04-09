package kasinoPackage
import scala.collection.mutable.Buffer

class Board(var cards: Buffer[Card]) {
  override def toString = cards.mkString(", ")
}