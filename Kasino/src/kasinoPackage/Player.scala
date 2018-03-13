package kasinoPackage
import scala.collection.mutable.Buffer


class Player(val hand: Buffer[Card]) {
  require(hand.size <= 4 && hand.size >= 0)
  
  val collected: Buffer[Card] = Buffer()
  
  def points: Int = ???
}