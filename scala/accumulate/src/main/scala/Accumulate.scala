class Accumulate {
  def accumulate[A, B](f: (A) => B, list : List[A]): List[B] =

    list match {
      case Nil => Nil
      case a :: rest => f(a) :: accumulate(f, rest)
    }

}
