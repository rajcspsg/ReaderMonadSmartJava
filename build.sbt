name := "ReaderMonadSmartJava"

version := "1.0"

scalaVersion := "2.12.1"

lazy val coreSettings = Seq(name := "core", version := "1.0", scalaVersion := "2.12.1")

lazy val nonReaderMonadExampleSettings = Seq(name := "nonReaderMonadExample", version := "1.0", scalaVersion := "2.12.1")

lazy val readerMonadExampleSettings = Seq(name := "readerMonadExample", version := "1.0", scalaVersion := "2.12.1")

lazy val readerMonadTExampleSettings = Seq(name := "readerMonadTExample", version := "1.0", scalaVersion := "2.12.1")

lazy val readerMonadTFutureWithOptionExampleSettings = Seq(name := "readerMonadTFutureWithOptionExample", version := "1.0", scalaVersion := "2.12.1")

lazy val core = (project in file("core")).settings(coreSettings)

lazy val nonReaderMonadExample = (project in file("nonReaderMonadExample")).settings(nonReaderMonadExampleSettings).dependsOn(core)

lazy val readerMonadExample = (project in file("readerMonadExample")).settings(readerMonadExampleSettings).dependsOn(core)

lazy val readerMonadTExample = (project in file("readerMonadTExample")).settings(readerMonadTExampleSettings).dependsOn(core)

lazy val readerMonadTFutureWithOptionExample = (project in file("readerMonadTFutureWithOptionExample")).settings(readerMonadTExampleSettings).dependsOn(core)


        