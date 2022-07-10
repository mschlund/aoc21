import better.files._

@main def hello: Unit =
  val input = File("resources/input")
  val dirs = determineIncDec(input.contentAsString)
  val dirsWin3 = determineIncDecSliding(input.contentAsString, 3)
  println(s"Number of Incs: ${getNumberIncs(dirs)}")
  println(s"Number of Incs (winsize 3): ${getNumberIncs(dirsWin3)}")
