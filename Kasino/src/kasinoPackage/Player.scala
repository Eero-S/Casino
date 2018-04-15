package kasinoPackage
import scala.collection.mutable.Buffer
import scala.io.StdIn._

class Player(var hand: Buffer[Card], val board: Board) {
  require((hand.size <= 4 && hand.size >= 0), "Wrong hand size")

  override def toString = hand.mkString(", ")

  val collected: Buffer[Card] = Buffer()
  def points: Int = ???

  def inspectAction(target: Card): Option[Set[Seq[Card]]] = {
    val board = this.board.cards   
    val targ = target.valueHand
    val sopivat = board.filter(_.valueTable <= targ).toSet   
    val s = sopivat.subsets().toList.map(_.toSeq).filter(_.map(_.valueTable).sum == targ)
      
    if(s.isEmpty) None
    else Option(s.toSet)

  }
  
  def play(){
    println("card")
    val kortti = readInt()
    require(kortti > 0 && kortti < 4)
    println("index of the seq")
    val otettava = readInt()
    val asd = inspectAction(this.hand(kortti)).get
    val sd = asd.toList(otettava)
    println(sd)
  }

}