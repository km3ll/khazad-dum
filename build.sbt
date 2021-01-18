name := "testdrive-scala"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "com.typesafe"                %  "config"         % "1.3.2",
  "org.scalatest"               %% "scalatest"      % "3.0.5",
  "com.github.julien-truffaut"  %% "monocle-core"   % "2.0.3",
  "com.github.julien-truffaut"  %% "monocle-macro"  % "2.0.3"
)