package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("simple balance: ()")(assert(balance("()".toList)))
  test("too many open: (()")(assert(!balance("(()".toList)))
  test("too many closed: ())")(assert(!balance("())".toList)))
  test("single open: (")(assert(!balance("(".toList)))
  test("single closed: )")(assert(!balance(")".toList)))
  test("wrapped: ((blah) + (blah))")(assert(balance("((blah) + (blah))".toList)))
  test("empty: []")(assert(balance("".toList)))
  test("random characters: 123456abc")(assert(balance("123456abc".toList)))

}
