package kasinoPackage

object testailua extends App{
  
  val a: List[Int] = List.range(1, 20)
  val targ = 7
  
  // testi = pöytä
  // target = pelattava kortti
  def testi(list: Seq[Int], target: Int) = {
    var palautukset = List[Int]()
    
    val noBigs = list.filter(_ < target) // isot ja samat pois
    val samat = list.filter(_ == target) // jos löytyy samoja, tallenna
    palautukset ++ samat
    
    // tarkastellaan loppuja
    if(noBigs.sum == target){ // jos loput.sum = target -> saadaan kaikki loput -> tallenna ja lopeta  
      palautukset ++ noBigs
    } else if (noBigs.size < 2){ // jos loput.sum < target, ei saada enää muuta
      // Do nothing
    } else { // jos loput.sum > target, selvitetään saadaanko jotain
      
      var p = noBigs.sorted // loput suuruusjärjestykseen
      
      while (p.size > 1){ // toista niin kauan kuin loppuja on jäljellä yli 1
        val isoin = p.last // listan isoin luku
        p = p.dropRight(1) // poistetaan sama luku listasta
        
        var samat1 = p.filter(_ == target - isoin)     // Poimi sopivat   
        if(samat1.size > 0 ){                          // Jos löytyy sopivia, tallenna
          (palautukset ++ samat1.:+(isoin)) 
        }
        
        var p1 = p.filter(_ < target - isoin)          // Poista isot, jäljellä olevat pienempiä kuin target - isoin
        
        if(p1.size > 1){ // jos pienempiä on alle 2, ei saada mitään, jos yli 1 jatketaan
          
        } else{
          // Do nothing
        }
        
        
      }
    }
  }
  
  def asd(lista:List[Int], target: Int) = {
    val l = lista.sorted.toBuffer
    var uus = Set[Set[Int]]()
    var i = 0
    while(i < l.length - 1){
      var ll = l.clone()
      ll.remove(i)
      
      val eka = ll.filter(_ == target - ll(i))
      if(!eka.isEmpty){
        val a = eka.+:(ll(i)).toSet
        println(a)
        uus =  uus.+(a) 
      }
            
      i += 1
    }
    println(uus)
  }
  asd(a, 8)
  
  
  
  
  
}