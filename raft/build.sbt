
name := "akka.js_demo"

scalaVersion in ThisBuild := "2.11.8"
scalacOptions in ThisBuild := Seq("-feature", "-language:_", "-deprecation")

lazy val root = project.in(file(".")).
  aggregate(demoJS, demoJVM)

lazy val demo = crossProject.in(file(".")).
  settings(
    name := "raft",
    fork in run := true
  ).
  jvmSettings(
    resolvers += "Akka Snapshots" at " http://repo.akka.io/snapshots/",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.5.0"
    )
  ).
  jsSettings(
    resolvers += Resolver.sonatypeRepo("releases"),
    libraryDependencies ++= Seq(
      "org.akka-js" %%% "akkajsactor" % "1.2.5.0"
    ),
    persistLauncher in Compile := true,
    scalaJSStage in Global := FastOptStage,
    scalaJSUseRhino in Global := false
  )

lazy val demoJVM = demo.jvm
lazy val demoJS = demo.js

cancelable in Global := true
