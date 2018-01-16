enablePlugins(ScalaJSPlugin)

name := "scalajs-css-website"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "scalajs-react-interface" %%% "web-bundle" % "2018.1.0-SNAPSHOT"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials"
)

scalaJSLinkerConfig ~= (_.withModuleKind(ModuleKind.CommonJSModule).withSourceMap(false))


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
