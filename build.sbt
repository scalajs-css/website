enablePlugins(ScalaJSPlugin)

name := "scalajs-css-website"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "core" % "2017.6.0-SNAPSHOT",
  "scalajs-react-interface" %%% "web" % "2017.6.0-SNAPSHOT",
  "scalajs-react-interface" %%% "vdom" % "2017.6.0-SNAPSHOT",
  "scalajs-react-interface" %%% "web-router" % "2017.6.0-SNAPSHOT",
  "scalajs-css" %%% "core" % "2017.6.24-RC",
  "scalajs-react-interface" %%% "universal" % "2017.6.0-SNAPSHOT"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-P:scalajs:sjsDefinedByDefault" // TODO remove this when we upgrade to scala.js 1.0
)

scalaJSModuleKind := ModuleKind.CommonJSModule

scalaJSUseMainModuleInitializer := true

resolvers += Resolver.bintrayRepo("scalajs-react-interface", "maven")
resolvers += Resolver.bintrayRepo("scalajs-css", "maven")

artifactPath in Compile in fastOptJS := new File("./assets/scalajs-output.js")
artifactPath in Compile in fullOptJS := new File("./assets/scalajs-output.js")

lazy val web = config("web")

val dev = Def.taskKey[Unit]("fastOpt and dev build")
val prod = Def.taskKey[Unit]("fastOpt and prod build")

dev in web := {
  import sys.process._
  (fastOptJS in Compile).value
}

prod in web := {
  import sys.process._
  (fullOptJS in Compile).value
}
