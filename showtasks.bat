call runcrud.bat
if "%ERRORLEVEL%" == "0" goto rename
echo.
echo GRADLEW BUILD has errors – breaking work
goto fail

start "C:\Program Files (x86)\Internet Explorer\iexplore.exe" www.gmail.com


:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.