package kasinoPackage
import scala.io.StdIn.{ readLine, readInt }

object testApp extends App {
  Game.createPlayers
  Game.createDeck
  
  
  Game.fillHands()
  println(Game.board)
  Game.players.foreach(println(_))
  Game.players.foreach(_.bestMove)
  
  
  
}