case class Position(var horizontal : Int, var depth : Int):
  def forward(units: Int) =
    horizontal += units
    this
  def up(units: Int) =
    depth -= units
    this
  def down(units: Int) =
    depth += units
    this
  def getPos = (horizontal, depth)

enum Direction:
  case Forward, Up, Down

case class Command(direction : Direction, units : Int)

private def stringDir2Dir(stringDir : String) : Direction =
  val normString = stringDir.toLowerCase.strip
  if normString == "forward" then
    Direction.Forward
  else if normString == "down" then
    Direction.Down
  else if normString == "up" then
    Direction.Up
  else
    println(s"ERROR -- Unknown dir, assuming 'Forward': $stringDir")
    Direction.Forward

private def line2Cmd(l: String) : Command =
  val splitLine = l.split(" ")
  Command(stringDir2Dir(splitLine(0)), splitLine(1).toInt)

def string2Commands(stringCommand: String) : Seq[Command] =
  val lines = stringCommand.split('\n')
  lines.map(line2Cmd)

def executeCommand(p: Position, c: Command) : Position =
  c.direction match
    case Direction.Forward => p.forward(c.units)
    case Direction.Up => p.up(c.units)
    case Direction.Down => p.down(c.units)

def executeCommands(startingPosition : Position, commands : Seq[Command]) : Position =
  commands.foldLeft(startingPosition)(executeCommand)