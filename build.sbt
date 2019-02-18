name := "twc"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= testDependencies

lazy val testDependencies = Seq(
  "org.scalatest"         %% "scalatest"           % "3.0.5"     % Test,
  "org.scalacheck"        %% "scalacheck"          % "1.14.0"    % Test,
  "org.mockito"            % "mockito-core"        % "2.23.4"    % Test
)