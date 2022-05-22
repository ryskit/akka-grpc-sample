import sbt.Keys.scalaVersion

object Settings {
  val scala31 = "3.1.2"

  val baseSettings = Seq(
    scalaVersion := scala31
  )
}
