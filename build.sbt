name := "filmes"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
//  "mysql" % "mysql-connector-java" % "5.1.29"
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4"
)     

play.Project.playJavaSettings
