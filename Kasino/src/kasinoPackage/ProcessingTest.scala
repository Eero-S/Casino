package kasinoPackage
import processing.core._
import scala.collection.mutable.Buffer

class ProcessingTest extends PApplet {
  override def settings() = {
    size(1024, 768)
  }

  override def setup() = {
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

  class Button(val text: String, go: => Unit) {
    def getGo = go

  }

  override def draw() = {
    val Bwidth = width / 3F
    val Bheight = height / 7F
    val Bx = width / 2F
    val yBase = height / 3F
    val yMargin = 150

    state match {
      case 0 => stateMenu()
      case 1 => stateGame()
    }

    def stateMenu() = {
      background(255, 250, 250)
      textAlign(PConstants.CENTER, PConstants.CENTER)
      rectMode(PConstants.CENTER)
      textSize(46);

      val buttons = Buffer[Button]()
      buttons += new Button("Play", state = 1)
      buttons += new Button("Exit", exit())

      buttonBuilder(buttons)

    }

    def stateGame() = {
      background(220, 220, 220)
      fill(0, 100, 0)
      stroke(139, 69, 19)
      strokeWeight(4)
      ellipse(width / 2F, height / 3F, 860, 470)
    }

    // Helper for building buttons
    def buttonBuilder(btns: Buffer[Button]) = {
      for (i <- btns.indices) {
        // Coordinates & size
        val x = Bx
        val y = yBase + (i) * yMargin
        val w = Bwidth
        val h = Bheight

        // Rectangle & text
        stroke(0)
        strokeWeight(3)
        fill(220, 220, 220)
        rect(x, y, w, h)
        fill(0)
        text(btns(i).text, x, y, w, h)

        if (overRect(x, y, w, h)) {
          rect(x, y, w, h)
          fill(220, 220, 220)
          text(btns(i).text, x, y, w, h)
          if (mousePressed) {
            btns(i).getGo
          }
        }

      }
    }

  }
}

object ProcessingTest extends App {
  PApplet.main("kasinoPackage.ProcessingTest")
}
















