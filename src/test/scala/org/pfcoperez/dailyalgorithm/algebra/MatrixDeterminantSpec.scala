package org.pfcoperez.dailyalgorithm.algebra

import org.pfcoperez.dailyalgorithm.Algebra.Matrix._
import org.pfcoperez.dailyalgorithm.Algebra.Matrix.NumericMatrix.Implicits._

import org.scalatest.{FlatSpec, Matchers}

class MatrixDeterminantSpec extends FlatSpec with Matchers {

  "LUP Decomposition determinant calculation method" should "provide right determinant values" in {

    val M: Matrix[Double] = Array(
      Array( 2,  0,  2, 0.6),
      Array( 3,  3,  4,  -2),
      Array( 5,  5,  4,   2),
      Array(-1, -2,3.4,  -1)
    )


    M.det shouldBe -120.0



  }

}
