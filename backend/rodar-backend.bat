@echo off
setlocal

set "BACKEND=%~dp0"
set "RAIZ=%BACKEND%.."
set "JAVA_HOME=%RAIZ%\tools\jdk"
set "PATH=%RAIZ%\tools\jdk\bin;%PATH%"
set "MAVEN_USER_HOME=%RAIZ%\tools\m2-wrapper"

cd /d "%BACKEND%"
"%RAIZ%\tools\maven\bin\mvn.cmd" spring-boot:run

echo.
echo Backend encerrado.
pause