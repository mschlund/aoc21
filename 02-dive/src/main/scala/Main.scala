import better.files._

@main def main: Unit =
  val input = File("src/resources/input")
  val start = Position(0,0)
  val resPos = executeCommands(start, string2Commands(input.contentAsString))
  println(resPos)
  println(s"Mult: ${resPos.horizontal*resPos.depth}")

  