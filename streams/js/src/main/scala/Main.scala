package eu.unicredit

import akka.actor.ActorSystem

import scala.scalajs.js

object Main extends js.JSApp {

  def main() = {
    println("JS env")
    Run.run()
    //UI.start(AkkaConfig.config)
  }

}
