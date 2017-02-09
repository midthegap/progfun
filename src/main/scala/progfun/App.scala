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
    println(s"fattoriale di 5 imp: ${Factorial.imperativeFactorial(5)}, functional: ${Factorial.factorial(5)}")

    test.stampa()
  }

}
