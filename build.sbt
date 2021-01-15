import sbt._
import org.scalajs.linker.interface.ModuleSplitStyle

inThisBuild(
  List(
    scalaVersion := "2.13.3",
    name := "ttg",
    logLevel := Level.Info,
    scalacOptions ++= Seq(
      "-deprecation",
      "-language:_",
      "-Ymacro-annotations",
      "-Xlint:infer-any",
    )
  )
)

val jsSettings = Seq(
  scalaJSLinkerConfig ~= {
    _.withModuleKind(ModuleKind.ESModule).withModuleSplitStyle(ModuleSplitStyle.SmallestModules)
  },
  resolvers += Resolver.bintrayRepo("aappddeevv", "maven"),
  addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.1" cross CrossVersion.full),
  addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "1.1.0",
    "ttg" %%% "react" % "0.1.0-M7",
    "ttg" %%% "react-dom" % "0.1.0-M7",
    "ttg" %%% "vdom" % "0.1.0-M7"
  )
)

Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val root = project
  .in(file("."))
  .aggregate(webui)

lazy val webui = project
  .settings(jsSettings)
  .settings(scalaJSUseMainModuleInitializer := true)
  .enablePlugins(ScalaJSPlugin)
