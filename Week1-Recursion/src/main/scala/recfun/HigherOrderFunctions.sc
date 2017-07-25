val x = 3

def sumUntil(func: Int => Double, a: Int, b: Int): Double = {
  if (a > b) 0 else func(a) + sumUntil(func, a + 1, b)
}

def identity(a: Int): Int = a
def squared(a: Int): Int = a * a
def cubed(a: Int): Int = a * a * a
def factorial(a: Int): Int = {
  if (a == 0) 1 else a * factorial(a - 1)
}

sumUntil(factorial, 0, 5)