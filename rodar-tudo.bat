@echo off
set "RAIZ=%~dp0"
set "RAIZ=%RAIZ:~0,-1%"

echo Subindo backend (porta 8080)...
start "Backend - Spring" cmd /k "set "JAVA_HOME=%RAIZ%\tools\jdk" && set "PATH=%RAIZ%\tools\jdk\bin;%PATH%" && set "MAVEN_USER_HOME=%RAIZ%\tools\m2-wrapper" && cd /d "%RAIZ%\backend" && "%RAIZ%\tools\maven\bin\mvn.cmd" spring-boot:run"

echo Aguardando o backend iniciar...
timeout /t 40 /nobreak >nul

echo Subindo frontend (porta 4200)...
start "Frontend - Angular" cmd /k "set "PATH=%RAIZ%\tools\node;%PATH%" && cd /d "%RAIZ%\frontend" && node_modules\.bin\ng.cmd serve --proxy-config proxy.conf.json"

echo.
echo Frontend: http://localhost:4200
echo Backend:  http://localhost:8080
pause