@echo off
set NOW=%CD%

cd %NOW%\dalgen-mysql
start gen-mysql.bat
  
cd %NOW%\dalgen-sqlite
start gen-sqlite.bat
