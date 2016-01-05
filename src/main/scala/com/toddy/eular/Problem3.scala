package com.toddy.eular

/**
 * Problem 3 - Largest Prime Factor
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143?
 */
class Problem3 extends Problem {
  def run = {

    println(findLargestPrimeFactor(600851475143.0) match {
      case Some(x)  => s"Largest prime factor: $x"
      case _        => "No prime factors"
    })
  }

  def findLargestPrimeFactor(x: Double): Option[Double] =
    findFactors(x)
      .filter(isPrime)
      .sortWith( _.compareTo(_) > 0)
      .headOption

  def findFactors(x: Double): Seq[Double] = {
    var lowestMultiple = x
    var factors = collection.mutable.Map.empty[Double, Boolean]
    var currentFactor: Double = 2

    while(currentFactor < lowestMultiple) {
      if(x % currentFactor == 0) factors.+=((currentFactor, true), (x / currentFactor, true))
      currentFactor += 1
      lowestMultiple = x / currentFactor
    }

    factors.keys.toSeq
  }

  def isPrime(x: Double): Boolean =
    findFactors(x).isEmpty
}
