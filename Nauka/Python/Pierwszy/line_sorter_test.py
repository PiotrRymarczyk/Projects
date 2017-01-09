#!/usr/bin/python

'''
Created on 29.11.2016

@author: prymarcz

UnitTests for line_sorter function from qcv_comparator

'''

import unittest
from qcv_comparator import line_sorter


class Test_line_sorter(unittest.TestCase):

    def test_01_NET_16connections(self):
        line = r"NET : 'GND' R5-2 Q1-3 C3-2 C5-2 J1-1 J1-2 D2-K C9-2 C2-2 C4-2 D1-K C7-2 C6-2 C8-2 C1-2 C10-2"
        expected = r"NET : 'GND' C1-2 C10-2 C2-2 C3-2 C4-2 C5-2 C6-2 C7-2 C8-2 C9-2 D1-K D2-K J1-1 J1-2 Q1-3 R5-2"
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_02_NET_4connections(self):
        line = r"NET : 'A00' U6-1 U2-10 U1-10 J1-3"
        expected = r"NET : 'A00' J1-3 U1-10 U2-10 U6-1"
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_03_NET_2connections(self):
        line = r"NET : '$2N35' R6-2 D2-A"
        expected = r"NET : '$2N35' D2-A R6-2"
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_04_NET_1connection(self):
        line = r"NET : 'A00' D2-A"
        expected = r"NET : 'A00' D2-A"
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_05_NET_0connections(self):
        line = r"NET : 'A00'"
        expected = r"NET : 'A00'"
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_05_PIN(self):
        line = r"PIN : '/U7' U7-9"        
        expected = r"PIN : '/U7' U7-9"        
        result = line_sorter(line)
        message = "Net is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_06_FlatNet(self):
        line = r"FlatNet: 'VSS_USBA'"
        expected = r"FlatNet: 'VSS_USBA'"
        result = line_sorter(line)
        message = "FlatNet is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_07_Comment(self):
        line = r"# begin one pin nets list"
        expected = r"# begin one pin nets list"
        result = line_sorter(line)
        message = "Comment is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)

    def test_08_2sections(self):
        line = r"one begin"
        expected = r"one begin"
        result = line_sorter(line)
        message = "2sections string is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)
        
    def test_09_empty_string(self):
        line = r""
        expected = r""
        result = line_sorter(line)
        message = "empty string is incorrectly sorted.\nExpected {0}\nResult   {1}".format(expected, result)
        self.assertEqual(result, expected, message)
    
    def test_10_integer(self):
        incorrect_type = 1
        self.assertRaises(TypeError, line_sorter, incorrect_type )
    
    def test_11_float(self):
        incorrect_type = 1.0
        self.assertRaises(TypeError, line_sorter, incorrect_type )
        
    def test_12_tuple(self):
        incorrect_type = (1,2)
        self.assertRaises(TypeError, line_sorter, incorrect_type )
        
    def test_13_list(self):
        incorrect_type = [1,2]
        self.assertRaises(TypeError, line_sorter, incorrect_type )
        
    def test_14_dict(self):
        incorrect_type = {1:"A",2:"B"}
        self.assertRaises(TypeError, line_sorter, incorrect_type )
        
    def test_15_set(self):
        # set defined as set([1,2]) to make sure that this test can be executed on Python2.x
        incorrect_type = set([1,2])
        self.assertRaises(TypeError, line_sorter, incorrect_type )
        
if __name__ == "__main__":
    unittest.main()
    