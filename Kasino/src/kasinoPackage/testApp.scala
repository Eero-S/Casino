package kasinoPackage
import scala.io.StdIn.{readLine,readInt}

object testApp extends App {
  Game.createDeck

  
  Game.shuffle
 // println(Game.deck)
  Game.createPlayers
 // println(Game.players)
 
  
  Game.fillBoard()
  Game.deal  
  println("board: " + Game.board)
  for(i <- 0 until Game.amountOfPlayers){
    println("p" + (i+1) + " hand: " + Game.players(i))
  }
  
  val p1 = Game.players.head
  val p2 = Game.players(1)
  for(i <- 0 until 4){
    println( p1.inspectAction(p1.hand(i)) + " - " + p1.hand(i).toString() )
  }
  
  for(i <- 0 until 4){
    println( p2.inspectAction(p1.hand(i)) + " - " + p2.hand(i).toString() )
  }
  
 
  
  p1.play()
}