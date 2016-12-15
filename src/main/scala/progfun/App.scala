package progfun

class Coffee {
  val prezzo = 1.0
}

class CartaCredito {
  def charge(p: Double) = {
    println(s"Pagato $p euro tramite carta di credito")
  }
}

case class Payment(cc: CartaCredito, amount: Double) {
  def pay() {
    cc.charge(amount)
  }
}

object App {

  def buyCoffee(cc: CartaCredito): (Coffee, Payment) = {
    val coffee = new Coffee()
    val payment = Payment(cc, coffee.prezzo)

    (coffee, payment)
  }

  def buyCoffees(cc: CartaCredito, n: Int): List[(Coffee, Payment)] = {
    Range(0, n).map((i: Int) => buyCoffee(cc)).toList
  }

  /**
    * Program entry point.
    */
  def main(args: Array[String]) {
    val cc = new CartaCredito
    val coffeePayment = buyCoffee(cc)
    println("Ho preso un " + coffeePayment._1)
    coffeePayment._2.pay()

    val coffees = buyCoffees(cc, 10)
    println(s"comprati ${coffees.length} caffe', da pagare!")
    coffees.map(_._2.pay())
  }

}
