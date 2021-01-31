name := "Assignment"
version :="1.0"
scalaVersion := "2.12.12"

lazy val firstModule = (project in file("firstModule")).settings(
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % Test
)

lazy val secondModule = (project in file("secondModule")).settings(
    libraryDependencies ++= Seq(
        "org.scalatest" %% "scalatest" % "3.2.3" % Test,
        "org.mockito" %% "mockito-scala" % "1.5.12" % Test
    )
)

lazy val root = (project in file(".")).aggregate(firstModule,secondModule)