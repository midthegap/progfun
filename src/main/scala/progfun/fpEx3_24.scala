/*
  Implement hasSubsequence for checking whether a List contains another List as a subsequence. For instance, List(1,2,3,4) would have
  List(1,2) , List(2,3) , and List(4) as subsequences, among others.
*/
object fpex324 {
  /* true if sup starts with sub */
  def startsWith[A](sup: List[A], sub: List[A]): Boolean =
    if (sup.size < sub.size) false
    else sub match {
      case Nil => true
      case h :: t => (sup.head == h) && startsWith(sup.tail, t)
    }

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean =
    sub match {
      case Nil => true
      case h :: t => sup.dropWhile(_ != h) match {
        case Nil => false
        case h1 :: t1 => {
          val found = startsWith(t1, t)
          if (found) true
          else hasSubsequence(t1, sub)
        }
      }
    }

  def test() {
    val l1 = List(1, 2, 3, 4, 5, 6)
    val l2 = List(11, 12)
    val l3 = List(2, 5)
    val l4 = List(3, 4,  5)

    println(hasSubsequence(l1, l2))  // false
    println(hasSubsequence(l1, l3))  // false
    println(hasSubsequence(l1, l4))  // true
  }
}
