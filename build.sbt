name := "progfun"

version := "1.0"

libraryDependencies ++= {
  //val akkaVersion = "2.4.7"
  Seq(
    "org.scalatest"              %% "scalatest"       % "2.2.6"       % "test",
    "com.typesafe.scala-logging" %% "scala-logging"   % "3.1.0",
    "ch.qos.logback"              % "logback-classic" % "1.1.7"
  )
}
