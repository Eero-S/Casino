package kasinoPackage
import processing.core._
import scala.collection.mutable.Buffer

class ProcessingTest extends PApplet {

  override def settings() = {
    size(1024, 768)
  }

  def overRect(x: Int, y: Int, width: Int, height: Int): Boolean = {
    if (mouseX >= x && mouseX <= x + width &&
      mouseY >= y && mouseY <= y + height) {
      true;
    } else {
      false;
    }
  }

  class Button(text: String) {

  }

  override def draw() = {
   /* if (mousePressed && overRect(250, 250, 50, 50)) {
      fill(0);

    } else {
      fill(126);
    }
    * 
    */

    rectMode(PConstants.CENTER)
    var buttons = Buffer[Button]()
    buttons += new Button("Play")
    buttons += new Button("Pla")
    buttons += new Button("Pl")
    for(i <- buttons.indices){
      val x = width / 2
      val H = height/buttons.length
      val y = i*H
      val w = width / 3
      val h = height / 7
      
      rect(x,y,w,h)
    }
  }

  /*override def draw() = {
    background(220,220,220)
    var stage = 0
    if(stage == 0){

    } else {



    fill(0, 100, 0);
    ellipse(width / 2, height / 2, 850, 400);
    }

  }
  *
  */
}

object ProcessingTest extends App {
  PApplet.main("kasinoPackage.ProcessingTest")
}

trait view
case object menu extends view
case object kasino extends view














