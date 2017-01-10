nosetests --with-doctest --with-coverage --cover-package=utils --cover-html --cover-xml --rednose -v
@echo off
rem nosetests --with-doctest --with-coverage --cover-html --cover-xml --rednose -v
rem nosetests --with-doctest --with-coverage --cover-html --cover-xml -v
@echo on
pylint utils.py
