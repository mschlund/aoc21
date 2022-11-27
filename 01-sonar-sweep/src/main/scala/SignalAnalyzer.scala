enum Direction:
  case Inc, Dec, Eq

def getNumberIncs(dirs: Seq[Direction]): Int =
  dirs.count(_ == Direction.Inc)

def determineIncDec(signal: String): Seq[Direction] =
  val lines = getLines(signal)
  val nums = lines.map(_.toInt)
  numsToIncDec(nums)

def determineIncDecSliding(signal: String, windowSize: Int): Seq[Direction] =
  val lines = getLines(signal)
  val nums = lines.map(_.toInt)
  val aggSignal = sumAggregateWindow(nums, windowSize)
  numsToIncDec(aggSignal)

private def sumAggregateWindow(signalNum: Seq[Int], windowSize: Int): Seq[Int] =
  val aggregateSignal = signalNum.sliding(windowSize).map(_.sum)
  aggregateSignal.toSeq

private def getLines(signal: String): Seq[String] =
  signal.split('\n')

private def numsToIncDec(signalNum: Seq[Int]): Seq[Direction] =
  val nums = signalNum :+ 0
  val numsShifted = 0 +: signalNum

  val pairs = numsShifted.zip(nums)
  val dirs = pairs.map(compare).drop(1).dropRight(1)
  dirs

private def compare(a: Int, b: Int): Direction =
  if a < b then Direction.Inc
  else if a > b then Direction.Dec
  else Direction.Eq
