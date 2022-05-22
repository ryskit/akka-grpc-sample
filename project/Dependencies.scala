import sbt._

object Dependencies {

  object Versions {
    val circe = "0.14.1"
    val scalaTest = "3.2.12"
  }

  object Libraries {
    val protoGoogleCommonProtos =
      "com.google.api.grpc" % "proto-google-common-protos" % "2.8.3" % "protobuf-src"

    val circeCore = "io.circe" %% "circe-core" % Versions.circe
    val circeParser = "io.circe" %% "circe-parser" % Versions.circe
    val circeGeneric = "io.circe" %% "circe-generic" % Versions.circe

    val scalatest = "org.scalatest" %% "scalatest" % Versions.scalaTest % Test
  }
}
