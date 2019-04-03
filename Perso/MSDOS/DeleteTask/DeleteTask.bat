@echo off
::===========================================
::Alterable part
SET name=notepad++.exe
::===========================================

::===========================================
::Non alterable part #DONT TOUCH THIS#
SET curDir=%cd%

::Search running processus
taskkill /IM "%name%" /T /F
::===========================================