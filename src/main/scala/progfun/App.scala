package progfun

class Coffee {
  val prezzo = 1.0
}

class CartaCredito {
  def charge(p: Double): Option[Double] =
    if (Math.random() > 0.5) {
      val totale = p * (1.05)
      println(s"Pagato $totale euro tramite carta di credito")
      Some(totale)
    } else {
      println("Pagamento non riuscito")
      None
    }
}

case class Payment(cc: CartaCredito, amount: Double) {
  def pay(): Option[Double] = {
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
    RNG.go()
  }

}
