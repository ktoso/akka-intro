package com.ebay.scala.akka

import akka.actor.{ActorLogging, Props, Actor}
import com.ebay.scala.akka.WordCountProtocol._

/**
 * Top level actor, which aggregates word counts
 */
class WordCountActor extends Actor with ActorLogging {

  var totalCount = 0L

  val workers = Vector.fill(3) { context.system.actorOf(Props(classOf[WordCountActor])) }

  def receive = {

    case CountAllWordsIn(content) =>
      // todo split work to other actors

    case CountWordsInLine(line) =>
      // todo count words

    case CheckCount =>
      // todo reply with count

    case Count(n) =>
      // todo update counter
  }

  // this is not nice, such distribution would usualy be done by a Router instance
  private def tellPartitioned(l: Array[String]) {
    l.toList zip workers foreach { case (line, worker) =>
//      log.info(s"Telling ${worker.path.elements.last} to count words in: $line")
      worker ! CountWordsInLine(line)
    }
  }
}
