@echo off
if not exist out mkdir out
javac -encoding UTF-8 -d out src\visitor\*.java test\visitor\*.java
echo ===== Programa =====
java -cp out visitor.Main
echo.
echo ===== Testes =====
java -cp out visitor.TesteVisitor
pause
