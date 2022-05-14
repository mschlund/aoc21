class SonarTests extends munit.FunSuite {
  val scans =  """|199
                  |200
                  |208
                  |210
                  |200
                  |207
                  |240
                  |269
                  |260
                  |263""".stripMargin
  val dirs = determineIncDec(scans)
  val dirWin3 = determineIncDecSliding(scans, 3)

  test("(star1) Example 1 inc/dec"){
    val expectedDirs = Seq(Direction.Inc, Direction.Inc, Direction.Inc, Direction.Dec,
                           Direction.Inc, Direction.Inc, Direction.Inc, Direction.Dec, Direction.Inc)
    assertEquals(dirs, expectedDirs)
  }
  
  test("(star1) Count incs") {
    val num_inc = dirs.count(_ == Direction.Inc)
    assertEquals(num_inc, 7)
  }

  test("(star2) Example 1 inc/dec") {
    val expectedDirsWin3 = Seq(Direction.Inc, Direction.Eq, Direction.Dec, Direction.Inc,
     Direction.Inc, Direction.Inc, Direction.Inc)
    assertEquals(dirWin3, expectedDirsWin3)
  }
  
  
}
