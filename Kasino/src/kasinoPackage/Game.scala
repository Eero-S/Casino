package kasinoPackage
import scala.collection.mutable.Buffer

object Game {

  val deck: Buffer[Card] = Buffer()

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
    scala.util.Random.shuffle(deck)
  }
  
  val players: Buffer[Player] = Buffer()
  val board: Buffer[Card] = Buffer()
  
  
  
  def deal() = {
    for(i <- 0 until 2){
    players += new Player(deck.take(4))
    deck.remove(4)
    }
    board ++ deck.take(4)
    deck.remove(4)
  }
  
  
  
  
}

