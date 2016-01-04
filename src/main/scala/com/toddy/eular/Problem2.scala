package com.toddy.eular

class Problem2 extends Problem {
  def run = {
    val total =
      fibValuesUpToInt(4000000)
      .filter( _ % 2 == 0)
      .sum
    println(s"Sum of even-valued fibonacci values no greater than four million: $total")
  }

  def fibValuesUpToInt(ceil: Int, x: Int = 1, y: Int = 2, currentVals: Seq[Int] = Seq(1, 2)): Seq[Int] = {
    nextFibValue(x, y) match {
      case z if z > ceil => currentVals
      case q => fibValuesUpToInt(ceil, y, q, currentVals :+ q)
    }
  }

  def nextFibValue(x: Int, y: Int): Int =
    x + y

}
