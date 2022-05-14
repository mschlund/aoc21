// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class DiveTest extends munit.FunSuite {
  val commands = """|forward 5
                            |down 5
                            |forward 8
                            |up 3
                            |down 8
                            |forward 2""".stripMargin
  val expectedCmds = Seq(
    Command(Direction.Forward, 5),
    Command(Direction.Down, 5),
    Command(Direction.Forward, 8),
    Command(Direction.Up, 3),
    Command(Direction.Down, 8),
    Command(Direction.Forward, 2),
  )
  test("Position") {
    val x = Position(0,0)
    x.forward(3)
    x.up(2)
    assertEquals(x.getPos, (3,-2))
  }

  test("Parse string-commands") {
    assertEquals(string2Commands(commands), expectedCmds)
  }

  test("Example 1") {
    val start = Position(0,0)
    assertEquals(executeCommands(start, string2Commands(commands)), Position(15,10))
  }
}
