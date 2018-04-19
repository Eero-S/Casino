package kasinoPackage
import scala.collection.mutable.Buffer
import scala.io.StdIn._

object Game {

  var deck: Buffer[Card] = Buffer()
  val board = new Board(Buffer())
  val players: Buffer[Player] = Buffer()

  def createDeck = {
    val ranks = Vector("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    for (i <- 1 to 13) {
      if (i == 1) {
        deck += new Card(14, i, "Diamonds", ranks(i - 1), 1)
        deck += new Card(14, i, "Hearts", ranks(i - 1), 1)
        deck += new Card(14, i, "Clubs", ranks(i - 1), 1)
        deck += new Card(14, i, "Spades", ranks(i - 1), 1)
      } else if (i == 2) {
        deck += new Card(i, i, "Diamonds", ranks(i - 1), 0)
        deck += new Card(i, i, "Hearts", ranks(i - 1), 0)
        deck += new Card(i, i, "Clubs", ranks(i - 1), 0)
        deck += new Card(15, i, "Spades", ranks(i - 1), 1)
      } else if (i == 10) {
        deck += new Card(16, i, "Diamonds", ranks(i - 1), 2)
        deck += new Card(i, i, "Hearts", ranks(i - 1), 0)
        deck += new Card(i, i, "Clubs", ranks(i - 1), 0)
        deck += new Card(i, i, "Spades", ranks(i - 1), 0)
      } else {
        deck += new Card(i, i, "Diamonds", ranks(i - 1), 0)
        deck += new Card(i, i, "Hearts", ranks(i - 1), 0)
        deck += new Card(i, i, "Clubs", ranks(i - 1), 0)
        deck += new Card(i, i, "Spades", ranks(i - 1), 0)
      }
    }
    this.shuffle
    this.fillBoard()
  }

  def createPlayers = {
    println("How many players?")
    val numberOfPlayers = readInt()
    println("Nice, we created " + numberOfPlayers + " players!")
    println("What are the names of the players?")
    val names = Buffer[String]()
    for (i <- 0 until numberOfPlayers) {
      println("Name of player " + (i + 1) + "?")
      names += readLine()
    }
    for (i <- 0 until numberOfPlayers) {
      players += new Player(Buffer(), board, names(i))
    }
    this.welcomeMsg
  }

  def fillHands() = {
    while (players.exists(_.hand.length < 4)) {
      for (i <- 0 until players.length) {
        if (players(i).hand.length < 4)
          players(i).hand += deck.head
        deck.remove(0, 1)
      }
    }
  }

  // Helpers
  
 
  
  
  private def shuffle = {
    deck = scala.util.Random.shuffle(deck)
  }
  private def fillBoard() = {
    while (board.cards.size < 4) {
      board.cards += deck.head
      deck.remove(0, 1)
    }
  }
  private def welcomeMsg = {
    val names = players.map(_.name)
    if (players.size == 1) println("Welcome " + names.head)
    else println("Welcome " + names.init.mkString(", ") + " and " + names.last)

  }

}

