package kasinoPackage
import processing.core._
import scala.collection.mutable.Buffer

class ProcessingTest extends PApplet {
  override def settings() = {
    size(1024, 768)
  }

  val game = Game
  var state = 0

  def overRect(x: Float, y: Float, width: Float, height: Float): Boolean = {
    if (mouseX > (x - width / 2F) && mouseX < (x + width / 2F) && mouseY > (y - height / 2F) && mouseY < (y + height / 2F)) {
      true;
    } else {
      false;
    }
  }

  class Button(val text: String) {

  }

  override def draw() = {
    val Bwidth = width / 3F
    val Bheight = height / 7F
    val Bx = width / 2F

    state match {
      case 0 => stateMenu()
      case 1 => stateCreatePlayers()
      case 2 => stateGame()
    }

    def stateMenu() = {
      background(255, 250, 250)
      textAlign(PConstants.CENTER, PConstants.CENTER)
      rectMode(PConstants.CENTER)
      val buttons = Buffer[Button]()

      buttons += new Button("Play")
      buttons += new Button("Exit")

      for (i <- buttons.indices) {
        val x = Bx
        val y = 200 + (i) * 150
        val w = Bwidth
        val h = Bheight
        textSize(45);

        text(buttons(i).text, x, y, w, h)
        if (overRect(x, y, w, h)) {
          fill(0)
          stroke(220, 220, 220)
          strokeWeight(3)
          rect(x, y, w, h)
          fill(220, 220, 220)
          text(buttons(i).text, x, y, w, h)
          if (mousePressed && i == 0) {
            state = 1
            println(state)
          } else if (mousePressed) {
            exit()
          }

        } else {
          fill(0)
          stroke(31, 41, 71)
          strokeWeight(2)
          rect(x, y, w, h)
          fill(220, 220, 220)
          text(buttons(i).text, x, y, w, h)
        }
      }
    }

    def stateCreatePlayers() = {
      background(255, 250, 250)
      textAlign(PConstants.CENTER, PConstants.CENTER)
      rectMode(PConstants.CENTER)

      val buttons = Buffer[Button]()
      buttons += new Button("1")
      buttons += new Button("2")
      buttons += new Button("3")
      buttons += new Button("4")

      for (i <- buttons.indices) {
        val x = Bx
        val y = 200 + (i) * 150
        val w = Bwidth
        val h = Bheight
        textSize(45);

        text(buttons(i).text, x, y, w, h)
        if (overRect(x, y, w, h)) {
          fill(0)
          stroke(220, 220, 220)
          strokeWeight(3)
          rect(x, y, w, h)
          fill(220, 220, 220)
          text(buttons(i).text, x, y, w, h)
          if (mousePressed) {
            val n = i + 1
           // game.createPlayers(n)
            state = 2
          }

        } else {
          fill(0)
          stroke(31, 41, 71)
          strokeWeight(2)
          rect(x, y, w, h)
          fill(220, 220, 220)
          text(buttons(i).text, x, y, w, h)
        }
      }
    }

    def stateGame() = {
      background(220, 220, 220)
      fill(0, 100, 0)
      stroke(139, 69, 19)
      strokeWeight(4)
      ellipse(width / 2F, height / 3F, 860, 470)

    }

  }

}

object ProcessingTest extends App {
  PApplet.main("kasinoPackage.ProcessingTest")
}
















