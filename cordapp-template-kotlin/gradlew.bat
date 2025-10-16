@echo off
REM Gradle wrapper script for Windows

SET DIRNAME=%~dp0
SET GRADLE_WRAPPER_JAR=%DIRNAME%gradle\wrapper\gradle-wrapper.jar
SET GRADLE_USER_HOME=%DIRNAME%\.gradle

java -jar "%GRADLE_WRAPPER_JAR%" %*