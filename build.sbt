name := "http4s-sample"

version := "0.1"

scalaVersion := "2.12.8"
scalacOptions ++= Seq("-Ypartial-unification")

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-core" % "0.18.22",
  "org.http4s" %% "http4s-dsl" % "0.18.22",
  "org.http4s" %% "http4s-blaze-server" % "0.18.22",
  "org.http4s" %% "http4s-blaze-client" % "0.18.22",
  "org.slf4j" % "slf4j-log4j12" % "1.7.26"
)
