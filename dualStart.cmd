@echo off
:: Change directory to the project root
cd /d %~dp0

:: Run Maven to build the project, skipping tests
start cmd /k mvnw.cmd clean package -DskipTests
:: Wait for the build to complete by checking for the.jar file
:waitBuild
if not exist target/whatever-0.0.1-SNAPSHOT.jar (
    timeout /t 5 /nobreak >nul 2>nul
    goto :waitBuild
)
echo Build completed.

:: Now, start the Java application
start cmd /k java -jar target/whatever-0.0.1-SNAPSHOT.jar

:: Navigate to the frontend directory and start the frontend
cd /d frontend
npm run start
