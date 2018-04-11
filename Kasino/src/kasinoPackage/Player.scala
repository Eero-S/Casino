package kasinoPackage
import scala.collection.mutable.Buffer

class Player(var hand: Buffer[Card], val board: Board) {
  require((hand.size <= 4 && hand.size >= 0), "Wrong hand size")

  override def toString = hand.mkString(", ")

  val collected: Buffer[Card] = Buffer()
  def points: Int = ???

  def inspectAction(target: Card): Option[Set[Set[Card]]] = {
    val board = this.board.cards
   
    val targ = target.valueHand
    val sopivat = board.filter(_.valueTable <= targ).toSet
   
    val setit = sopivat.subsets().toList.filter(_.map(_.valueTable).sum == targ)
    
    if(setit.isEmpty) None
    else Option(setit.toSet)

  }

}