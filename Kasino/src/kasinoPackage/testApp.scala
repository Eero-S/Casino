package kasinoPackage

object testApp extends App {
  Game.crateDeck
  println(Game.deck)
  Game.shuffle
  println(Game.deck)
}