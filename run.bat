@echo off
TITLE Redirect Landing Page - Spring Boot
echo.
echo ====================================================
echo   SPRING BOOT REDIRECT LANDING PAGE
echo ====================================================
echo.
echo Kiem tra moi truong Java...
java -version 2>nul
if %errorlevel% neq 0 (
    echo Khong tim thay Java. Vui long khoi dong lai may hoac terminal de cap nhat bien moi truong.
    pause
    exit /b
)

echo.
echo Dang khoi chay ung dung tai http://elementor-page.org ...
call mvn spring-boot:run

pause
