package org.busywait.d3

import utest._

object SpiralTests extends TestSuite {
  override def tests: Tests = Tests {
    'Part1 - {
      'StepsFrom1 - {
        val steps = SpiralMemory.steps(1)

        assert(steps == 0)
      }

      'StepsFrom3 - {
        val steps = SpiralMemory.steps(3)

        assert(steps == 2)
      }

      'StepsFrom12 - {
        val steps = SpiralMemory.steps(12)

        assert(steps == 3)
      }

      'StepsFrom17 - {
        val steps = SpiralMemory.steps(17)

        assert(steps == 4)
      }

      'StepsFrom21 - {
        val steps = SpiralMemory.steps(21)

        assert(steps == 4)
      }

      'StepsFrom23 - {
        val steps = SpiralMemory.steps(23)

        assert(steps == 2)
      }

      'StepsFrom1024 - {
        val steps = SpiralMemory.steps(1024)

        assert(steps == 31)
      }

      'SolutionTo - {
        val steps = SpiralMemory.steps(265149)

        println("Solution: " + steps)
        assert(steps == 438)
      }
    }

    'Part2 - {
      'SoluctoinTo1 - {
        val value = SpiralMemory.calculateAdjacentSquareValue(1)

        assert(value == 2)
      }

      'SolutionTo5 - {
        val value = SpiralMemory.calculateAdjacentSquareValue(5)

        assert(value == 10)
      }

      'SolutionTo - {
        val value = SpiralMemory.calculateAdjacentSquareValue(265149)

        println("Solution: " + value)
        assert(value == 265150)
      }
    }
  }
}
