package recfun

import scala.annotation.tailrec

object Main {
  def main(args: Array[String]) {
    // Pascal's triangle
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    // Parenthesis balancing
    val is_balanced = balance(chars = "((test)()())".toList)
    printf("Parentheses matching: %s\n", is_balanced)

    // Change making

  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ((c == 0) || (c == r)) {
        1
      } else {
        pascal(c, r - 1) + pascal(c - 1, r - 1)
      }
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      @tailrec
      def balance_step(chars: List[Char], open: Int): Boolean = {
        if (chars.isEmpty) {
          if (open == 0) true else false
        } else if (chars.head == '(') {
          balance_step(chars.tail, open + 1)
        } else if (chars.head == ')') {
          if (open == 0) false else balance_step(chars.tail, open - 1)
        } else {
          balance_step(chars.tail, open)
        }
      }

      balance_step(chars, 0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0)
        1
      else if (money > 0 && coins.nonEmpty)
        countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else
        0
    }
  }
