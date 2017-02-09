package progfun

case class Persona(nome:String, cognome: String, eta: Int)

object test {
  val pippo = Persona("Pippo", "Rossi", 25)
  val mario = Persona("Mario", "Rossi", 28)
  val giovanni = Persona("Giovanni", "Neri", 19)
  val marco = Persona("Marco", "Bianchi", 36)
  val roberto = Persona("Roberto", "Verdi", 41)
  val laura = Persona("Laura", "Bianchi", 20)
  val michele = Persona("Michele", "Rossi", 15)

  val people = List[Persona](pippo, mario, giovanni, marco, roberto, laura, michele)

  // trovare gli under 24
  val teenagers = people.filter(p => p.eta < 24)
  println("i teenagers: " + teenagers.map(toNomeCompleto).mkString(","))

  // calcolare l'eta' media
  val etaMedia = people.foldLeft(0)((somma: Int, p: Persona) => somma + p.eta) / people.size
  println("Eta' media " + etaMedia)

  // trovare i parenti, cioe' chi ha lo stesso cognome
  // raggruppo in sottoinsiemi le persone con stesso cognome
  val relatives: Map[String, List[Persona]] = people.groupBy(p => p.cognome)
  // prendo solo i gruppi con 2+ persone
  val nonSingle = relatives.keys.filter(cognome => relatives(cognome).size > 1)
  // per ogni cognome, i parenti con nome completo
  val nomiCompleti = nonSingle
    .map(c => relatives(c))
    .map(l => l.map(toNomeCompleto))

  def toNomeCompleto(p: Persona): String = s"${p.nome} ${p.cognome}"

  def stampa() {
    for (n <- nomiCompleti)
      println("Sono parenti " + n.mkString(" e "))
  }
}
