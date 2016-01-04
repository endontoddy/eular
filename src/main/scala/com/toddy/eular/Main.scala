package com.toddy.eular

object Main extends App {

  val problemToRun = args(0).toInt

  val problems: Map[Int, Problem] = Map(
    1 -> new Problem1,
    2 -> new Problem2
  )

  println(s"Running Problem ${problemToRun.toString}...\n****************************")

  problems(problemToRun).run

  println("****************************\nAll Done")
}

trait Problem {
  def run: Unit
}
