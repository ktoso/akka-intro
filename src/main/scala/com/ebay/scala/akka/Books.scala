package com.ebay.scala.akka

import scala.io.Source

object Books {
  lazy val Sherlock = {
    val source = Source.fromInputStream(getClass.getClassLoader.getResourceAsStream("pg1661.txt"))
    val text = source.getLines().mkString("\n")
    source.close()
    text
  }
}
