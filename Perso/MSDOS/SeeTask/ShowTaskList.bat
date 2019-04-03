@echo off
SET curDir=%cd%
if exist %curDir%\TaskList.txt del %curDir%\TaskList.txt
tasklist > %curDir%\TaskList.txt