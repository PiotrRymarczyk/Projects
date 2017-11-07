'''
Created on 2017/11/06
Modified on 2017/11/06

@author: Piotr Rymarczyk

UnitTests for Python Version

'''

import unittest
import sys
from python_version_checker.python_version_checker import  get_python_version


class Test_PythonVersion(unittest.TestCase):
    '''
    UnitTests for python's version
    '''
    
    def test_check_if_3(self):
        (result,b,c) =  get_python_version()
        message = 'Major version is {0}, expected 3'.format(result)
        self.assertEqual(result, 3, message)
    
    def test_check_if_2(self):
        (result,b,c) =  get_python_version()
        message = 'Major version is {0}, expected 3'.format(result)
        self.assertEqual(result, 2, message)

if __name__ == "__main__":
    unittest.main()