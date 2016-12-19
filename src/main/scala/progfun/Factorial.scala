package progfun

import scala.annotation.tailrec

object Factorial {

  /** Imperative factorial fun */
  def imperativeFactorial(n: Int): Int = {
    var result = 1

    for(i <- Range(1,n)) {
      result = result * (i + 1)
    }

    result
  }

  def factorial(n: Int): Int = {
    @tailrec
    def go(n: Int, acc: Int): Int = {
      if (n == 1) acc
      else go(n-1, acc * n)
    }

    go (n, 1)
  }


}
