package kasinoPackage
import scala.collection.mutable.Buffer

object Game {

  var deck: Buffer[Card] = Buffer()
  def crateDeck = {
    val ranks = Vector("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    for (i <- 0 until 13) {
      deck += new Card(i, i, "Diamonds", ranks(i))
      deck += new Card(i, i, "Hearts", ranks(i))
      deck += new Card(i, i, "Clubs", ranks(i))
      deck += new Card(i, i, "Spades", ranks(i))
    }
  }
  def shuffle = {
    deck = scala.util.Random.shuffle(deck)
  }

  val amountOfPlayers: Int = 2
  val players: Buffer[Player] = Buffer()
  val board = new Board(deck.take(4))
  deck.remove(0, 4)

  def createPlayers = {
    for (i <- 0 until amountOfPlayers) {
      players += new Player(Buffer(), board)
    }
  }

  def deal() = {
    while (players.exists(_.hand.length < 4)) {
      for (i <- 0 until players.length) {
        if (players(i).hand.length < 4)
          players(i).hand += deck.head
        deck.remove(0, 1)
      }
    }

  }

}

