package com.ebay.scala.akka

object WordCountProtocol {

  sealed trait WordCountMessage

  case class CountAllWordsIn(content: String) extends WordCountMessage
  case class CountWordsInLine(content: String) extends WordCountMessage

  case object CheckCount extends WordCountMessage

  case class Count(n: Long) extends WordCountMessage
}
