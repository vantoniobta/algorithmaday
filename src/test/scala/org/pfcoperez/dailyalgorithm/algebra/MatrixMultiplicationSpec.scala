package org.pfcoperez.dailyalgorithm.algebra

import org.pfcoperez.dailyalgorithm.Algebra.Matrix.NumericMatrix.MultiplicationMethods.{DivideAndConquer, NaiveMultiplicationMethod}
import org.pfcoperez.dailyalgorithm.Algebra.Matrix._
import org.scalatest.{Matchers, WordSpec}

object MatrixMultiplicationSpec {

  def randomIntMatrix(n: Int, m: Int): Matrix[Int] = {
    import scala.util.Random
    positionalValues(n,m) { case _ => Random.nextInt(100) }
  }

}

class MatrixMultiplicationSpec extends WordSpec with Matchers {

  import MatrixMultiplicationSpec._

  "A recursive D&Q multiplication algorithm" should {

    implicit val multiplicationMethod = DivideAndConquer(NaiveMultiplicationMethod)

    "be able to multiply square matrices by identities" in {

      (5 to 7) foreach { p => //matrix side size = 2^p

        val l = math.pow(2, p).toInt

        val randomMatrix = randomIntMatrix(l,l)

        (randomMatrix * identity(l,l)).deep should equal(randomMatrix)


      }


    }

    "be able to multiply arbitrary square matrices falling back to default method when needed" in {

     for(l <- 1 to 53) {

       val A = randomIntMatrix(l,l)
       val B = randomIntMatrix(l,l)

       (A*B).deep should equal(A.*(B)(NaiveMultiplicationMethod).deep)

     }

    }

  }

}
