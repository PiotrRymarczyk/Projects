nosetests --with-doctest --with-coverage --cover-package=qcv_comparator --cover-html --cover-xml --rednose -v
@echo off
rem nosetests --with-doctest --with-coverage --cover-html --cover-xml --rednose -v
rem nosetests --with-doctest --with-coverage --cover-html --cover-xml -v
@echo on
pylint qcv_comparator.py
