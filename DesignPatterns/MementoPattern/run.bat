@echo off
setlocal

cd /d "%~dp0"
set "OUTPUT_DIR=%TEMP%\memento-pattern-classes"

if not exist "%OUTPUT_DIR%" mkdir "%OUTPUT_DIR%"

javac -d "%OUTPUT_DIR%" *.java
if errorlevel 1 exit /b %errorlevel%

java -cp "%OUTPUT_DIR%" Main
exit /b %errorlevel%
