package org.busywait.d3

import utest._

object SpiralTests extends TestSuite {
  override def tests: Tests = Tests {
    'Part1 - {
      'StepsFrom1 - {
        val spiralMemory = new SpiralMemory(1)

        val steps = spiralMemory.steps()
        assert(steps == 0)
      }

      'StepsFrom3 - {
        val spiralMemory = new SpiralMemory(3)

        val steps = spiralMemory.steps()
        assert(steps == 2)
      }

      'StepsFrom12 - {
        val spiralMemory = new SpiralMemory(12)

        val steps = spiralMemory.steps()
        assert(steps == 3)
      }

      'StepsFrom17 - {
        val spiralMemory = new SpiralMemory(17)

        val steps = spiralMemory.steps()
        assert(steps == 4)
      }

      'StepsFrom21 - {
        val spiralMemory = new SpiralMemory(21)

        val steps = spiralMemory.steps()
        assert(steps == 4)
      }

      'StepsFrom23 - {
        val spiralMemory = new SpiralMemory(23)

        val steps = spiralMemory.steps()
        assert(steps == 2)
      }

      'StepsFrom1024 - {
        val spiralMemory = new SpiralMemory(1024)

        val steps = spiralMemory.steps()
        assert(steps == 31)
      }

      'SolutionTo - {
        val spiralMemory = new SpiralMemory(265149)

        val steps = spiralMemory.steps()
        println("Solution: " + steps)
        assert(steps == 438)
      }
    }

    'Part2 - {

    }
  }
}
