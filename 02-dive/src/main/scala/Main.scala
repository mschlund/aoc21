import better.files._

@main def main: Unit =
  val input = File("src/resources/input")
  val start = Position(0,0)
  val resPosSimple = executeCommands(start, string2Commands(input.contentAsString))
  val resPosExt = executeCommandsWithAim(PositionWithAim(Position(0,0), 0) , string2Commands(input.contentAsString))
  println(s"Star 1: ${resPosSimple}")
  println(s"Mult: ${resPosSimple.horizontal*resPosSimple.depth}")
  
  println(s"\nStar 2: ${resPosExt}")
  println(s"Mult: ${resPosExt.horizontal * resPosExt.depth}")

  