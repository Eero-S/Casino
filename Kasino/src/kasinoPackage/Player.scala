package kasinoPackage
import scala.collection.mutable.Buffer

class Player(var hand: Buffer[Card], val board: Board) {
  require((hand.size <= 4 && hand.size >= 0), "Wrong hand size")

  override def toString = hand.mkString(", ")

  val collected: Buffer[Card] = Buffer()
  def points: Int = ???

  def inspectAction = {

    def otettavat(card: Card) = {
      val v = card.valueHand
      val samat = board.cards.filter(_.valueTable == v).toSet
      val smallers = board.cards.filter(_.valueTable < v).sortBy(_.valueTable)

      var kelpaavat = Set[Set[Card]]()
      kelpaavat += samat

      val asdd = smallers.map(_.valueTable).sum

      if (asdd < v) {
        // stop
      } else if (asdd == v) {
        // ota talteen
      } else {
        val isoin = smallers.last
        val loput = smallers.dropRight(1)
        val sopivat1 = loput.filter(_.valueTable == v - isoin.valueTable)
        val loput2 = loput.filter(_.valueTable < v - isoin.valueTable)

        if (loput2.map(_.valueTable).sum < v - isoin.valueTable) {
          // stop
        } else if (loput2.map(_.valueTable).sum == v - isoin.valueTable) {
          // ota talteen
        } else {
          

        }
      }

    }

  }

}