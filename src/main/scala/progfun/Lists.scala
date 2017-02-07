package progfun

object Lists {
  val a = List(1,2,3)
  val b = Nil
  val c = List()
  val d = List(3,7,1,10,4,9)

  val e = 0 :: a

  // lists are immutable: this does not compile!
  //a = 0 :: a

  val f = a ++ d

  val testa = a.head   // 1
  val coda = a.tail    // List(2,3)

  /** Somma degli elementi della lista */
  def sum(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else l.head + sum(l.tail)
  }

  /* e' tail recursive? proviamo a stampare */
  def sum2(l: List[Int]): Int = {
    if (l.isEmpty) 0
    else {
      println("sommo " + l.head)
      val r = l.head + sum2(l.tail)
      println("risulato " + r)
      r
    }
  }

  /** Somma degli elementi della lista, tail recursive way */
  def sum3(l: List[Int]): Int = {
    @annotation.tailrec
    def sumAcc(l: List[Int], sum: Int): Int = {
      if (l.isEmpty) sum
      else sumAcc(l.tail, sum + l.head)
    }

    sumAcc(l, 0)
  }

  /** Trasforma ogni elemento nel suo quadrato */
  def square(l: List[Int]): List[Int] =
    if (l.isEmpty) Nil
    else (l.head * l.head) :: square(l.tail)

  /** Trasforma ogni elemento nel suo negato */
  def neg(l: List[Int]): List[Int] =
    if (l.isEmpty) Nil
    else (-l.head) :: neg(l.tail)

  /** possiamo generalizzare: applica una funzione generica a
    * tutti gli elementi della lista
    */
  def transform(l: List[Int], f: (Int => Int)): List[Int] = {
    if (l.isEmpty) Nil
    else f(l.head) :: transform(l.tail, f)
  }

  def negate(x: Int) = -x
  def sqr(x: Int) = x * x

  transform(a, negate)
  transform(a, sqr)

  /*
   * La trasformazione, o proiezione, o mapping e' un'operazione
   * molto frequente, le liste di Scala prevedono una funzione
   * ad hoc: map()
   */

   a.map(negate)

   /* map() prende come parametro una funzione, possiamo usare
    * anonymous functions.
    * Ad esempio: ogni numero viene trasformato in 0 o 1, in base
    * al resto della divisione per 2
    */

  b.map( (x: Int) => x % 2 )

  /* map() trasforma in elementi di tipo diverso.
   * Ad es.: quali sono i numeri pari?
   */
  val bpari: List[Boolean] = b.map( (x: Int) => x % 2 == 0)

  /* una stringa per ogni numero */
  val bstring: List[String] = b.map( (x: Int) =>
    if (x % 2 == 0)
      x + " e' pari"
    else
      x + " e' dispari" )

  /* una piccola funzione di utilita' per List: mkString */
  bstring.mkString("\n")

  /* altre funzioni di List: filtrare gli elementi */
  b.filter( (x: Int) => x % 2 == 0)

  /* opereazioni di riduzione (reduce) della lista, ad es:
   * la somma di tutti gli elementi della lista.
   * La funzione foldLeft ha come argoment:
   *  - un valore iniziale,
   *  - una funzione in grado di fondere un valore della lista
   *    con il valore iniziale
   * La funzione viene applicata fino a esaurimento.
   */
  val sum = (x1: Int, x2: Int) => x1 + x2
  b.foldLeft(0)(sum)
  b.foldRight(0)(sum)

  /* La documentazione Scala riporta (nota: si tratta di List[A]):
   * def foldLeft[B](z: B)(op: (B, A) ⇒ B): B
   *   Applies a binary operator to a start value and all elements
   *   of this sequence, going left to right.
   */
  b.foldLeft("0")((s: String, i: Int) => s + " + " + i)

  /* C'e' anche il complementare:
   * def foldRight[B](z: B)(op: (A, B) ⇒ B): B
   *   Applies a binary operator to all elements of this list
   *   and a start value, going right to left.
   */
   b.foldRight("0")((i: Int, s: String) => i + " + " + s)


  /** pattern matching */
  def fun(a: List[Int]) = a match {
    case List(0, p, q) => p + q
    case List() => -1
  }

  def fun2(a: List[Int], acc: Int): Int = a match {
    case h :: t => fun2(t, acc + h)
    case Nil => acc
  }

}
