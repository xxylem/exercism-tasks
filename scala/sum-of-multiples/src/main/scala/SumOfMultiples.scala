object SumOfMultiples {

  def sum(factors: Set[Int], limit: Int): Int = {
    factors.flatMap(factor => (factor until limit by factor).toSet).sum
  }

}

