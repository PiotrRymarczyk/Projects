'''
Created on 07.12.2016

@author: prymarcz
'''
import unittest
from Learning import LearningClass


class Test(unittest.TestCase):


    def setUp(self):
        print("setUp")
        pass


    def tearDown(self):
        print("tearDown")
        pass


    def testName(self):
        print("testName")
        pass


if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()