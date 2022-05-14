val scala3Version = "3.1.2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "02-dive",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
     "org.scalameta" %% "munit" % "0.7.29" % Test,
     ("com.github.pathikrit" %% "better-files" % "3.9.1").cross(CrossVersion.for3Use2_13),
    )
  )
