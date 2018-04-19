package kasinoPackage
import scala.collection.mutable.Buffer
import scala.io.StdIn._

class Player(var hand: Buffer[Card], val board: Board, val name: String) {
  require((hand.size <= 4 && hand.size >= 0), "Wrong hand size")

  override def toString = hand.mkString(", ")

  val collected: Buffer[Card] = Buffer()
  var points = 0

  def inspectAction(target: Card): Option[Seq[Seq[Card]]] = {
    val board = this.board.cards
    val targ = target.valueHand
    val sopivat = board.filter(_.valueTable <= targ).toSet
    val cards = sopivat.subsets().toList.map(_.toSeq).filter(_.map(_.valueTable).sum == targ).distinct
    if (cards.isEmpty) None
    else Option(cards)

  }

  def chooseAction() {
    println("card?")
    val fromHand = readInt()
    require(fromHand > 0 && fromHand < 4)

    val card = this.hand(fromHand)
    val tableCards = inspectAction(card)

    if (tableCards.isEmpty) {
      println("you got nothing")
      board.add(card)
    } else {
      val sets = tableCards.get.toSeq

      if (sets.length == 1) {
        collect(sets.head)
      } else {
        println("index of the set?")
        val indexOfset = readInt()
        val cards = sets(indexOfset)
        println((cards).mkString(", "))
        collect(cards)
      }

    }
    removeFromHand(card)

  }

  def bestMove = {    

    var m: Map[Int, Seq[Seq[Card]]] = Map()

    for (i <- 0 until hand.length) {
      val x = this.inspectAction(hand(i))

      if (!x.isEmpty) {
        val a = x.get.filter(b => b.map(_.points).sum == x.get.maxBy(_.map(_.points).sum).map(_.points).sum) // Most points per card
        m = m ++ Map(i -> a)
      }
    }
    println(m)

  }

  private def collect(cards: Seq[Card]) = {
    collected ++= cards
    board.take(cards)
  }

  private def removeFromHand(card: Card) = {
    hand -= card
  }

  def calcPointCards = collected.map(_.points).sum
  def calcSpades = collected.filter(_.suit == "Spades").length
  def calcLength = collected.size

}