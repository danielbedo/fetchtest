package com.position

import fetch.Fetch
import cats.Id
import fetch.unsafe.implicits._
import fetch.syntax._
import fetch.implicits._
import scala.concurrent._
import ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

object Run extends App {
  import Sources._

  def getUser(id: UserId): Fetch[User] = Fetch(id)

  val fetchUser: Fetch[User] = getUser(1)
  fetchUser.runA[Id]

  Await.result(fetchUser.runA[Future], Duration.Inf)

}
