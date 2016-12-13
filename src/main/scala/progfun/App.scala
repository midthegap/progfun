package progfun

class Coffee {
  val prezzo = 1.0
}

class CartaCredito {
  def paga(p: Double) = {
    println(s"Pagato $p euro tramite carta di credito")
  }
}


object App {

  def buyCoffee(cc: CartaCredito): Coffee = {
    val coffee = new Coffee()
    cc.paga(coffee.prezzo)

    coffee
  }

  def buyCoffees(cc: CartaCredito, n: Int): List[Coffee] = {
    // con var result e' ri-assegnabile
    var result = List[Coffee]()

    for (i <- Range(0, n))
      result = buyCoffee(cc) :: result

    result
  }

  /**
    * Program entry point.
    */
  def main(args: Array[String]) {
    val cc = new CartaCredito
    println("Result is " + buyCoffee(cc))

    val coffees = buyCoffees(cc, 10)
    println(s"comprati ${coffees.length} caffe'")
  }

}
