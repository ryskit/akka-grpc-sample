import Settings._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.2"

lazy val root = (project in file("."))
  .settings(baseSettings)
  .settings(
    name := "akka-grpc-sample",
    libraryDependencies ++= Seq(
      "com.thesamet.scalapb" %% "compilerplugin" % "0.11.10",
      "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion
    ),
    excludeDependencies ++= Seq(
      "com.thesamet.scalapb" % "scalapb-runtime_2.13",
      "org.scala-lang.modules" % "scala-collection-compat_2.13"
    )
  )
  .enablePlugins(AkkaGrpcPlugin)
