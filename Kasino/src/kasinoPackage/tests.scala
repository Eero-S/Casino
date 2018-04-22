package kasinoPackage
import processing.core._

class tests extends PApplet {
  override def settings() {
    size(1024, 768)
    
  }

 

  override def draw() {
    textSize(25)
    text("ichi", width/2, 95);
    
    
  }

 
  override def mouseClicked() = {
    
  }

}

object tests extends App {
  PApplet.main("kasinoPackage.tests")
}