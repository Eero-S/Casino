package kasinoPackage

object testApp extends App {
  Game.crateDeck
  println(Game.deck)
  Game.shuffle
  println(Game.deck)
  Game.createPlayers
  println(Game.players)
  
  Game.deal  
  println("board: " + Game.board)
  for(i <- 0 until Game.amountOfPlayers){
    println("p" + (i+1) + " hand: " + Game.players(i))
  }
  
}