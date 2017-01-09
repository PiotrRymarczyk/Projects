#!/usr/bin/python

'''
Created on 29.11.2016

@author: prymarcz

UnitTests for sum_multi_parameters function from qcv_comparator

'''

import unittest
from qcv_comparator import sum_multi_parameters


class Test_sum_multi_parameters(unittest.TestCase):

    def test_01_2_parameters(self):
        expected = 3
        result = sum_multi_parameters(1,2)
        message = "Two parameters passed"
        self.assertEqual(result, expected, message)

    def test_02_7_parameters(self):
        expected = 28
        result = sum_multi_parameters(1,2,3,4,5,6,7)
        message = "Seven parameters passed"
        self.assertEqual(result, expected, message)

    def test_03_1st_parameter_of_incorrect_type(self):
        first = "1"
        second = 2
        self.assertRaises(TypeError, sum_multi_parameters, first, second)

    def test_04_2nd_parameter_of_incorrect_type(self):
        first = 1
        second = "incorrect"
        self.assertRaises(TypeError, sum_multi_parameters, first, second)
        
    def test_04_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = "incorrect"
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)

    def test_05_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = 'A'
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)
    
    def test_06_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = [1,2]
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)
    
    def test_07_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = (1,2)
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)
        
    def test_08_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = set([1,2])
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)
        
    def test_09_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = {1:9,2:15}
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)        
        
    def test_10_3rd_parameter_of_incorrect_type(self):
        first = 1
        second = 2
        third = 1.05
        self.assertRaises(TypeError, sum_multi_parameters, first, second, third)          
        
if __name__ == "__main__":
    unittest.main()
    