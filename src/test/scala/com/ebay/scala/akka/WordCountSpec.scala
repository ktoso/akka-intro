package com.ebay.scala.akka

import org.scalatest.{FlatSpecLike, Matchers}
import akka.testkit.{ImplicitSender, TestKit}
import akka.actor.{ActorRef, Props, ActorSystem}
import com.ebay.scala.akka.WordCountProtocol.{Count, CheckCount, CountAllWordsIn}
import scala.concurrent.duration._

class WordCountSpec extends TestKit(ActorSystem("test-system")) with FlatSpecLike with Matchers
  with ImplicitSender {

  val counter: ActorRef = ??? // todo create actor

  it should "count words" in {
    // given
    counter ! CountAllWordsIn(Books.Sherlock)

    // when
    Thread.sleep(1000)
    counter ! CheckCount

    // then
    expectMsg(Count(431))
  }
}
