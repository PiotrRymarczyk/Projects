'''
Created on 29.11.2016

@author: prymarcz
'''

def line_sorter(line):
    '''
    line_sorter gets line and sort connections for net or pin
    if incorrect type is passed then TypeError exception is raised
    
    >>> line_sorter("NET : 'GND' R5-2 Q1-3 C3-2 J1-1 J1-2 D2-K C9-2 C4-2 D1-K C7-2 C8-2 C1-2 C10-2")
    "NET : 'GND' C1-2 C10-2 C3-2 C4-2 C7-2 C8-2 C9-2 D1-K D2-K J1-1 J1-2 Q1-3 R5-2"
    
    >>> line_sorter(8)
    Traceback (most recent call last):
    ...
    TypeError: String type expected
    '''
    if not isinstance(line, str):
        raise TypeError("String type expected")
    else:
        sorted_line = ""
        # check if line is not comment, if it is then return it unchanged
        if line.startswith("#"):
            sorted_line = line
        else:
            # split line by space and put in into list
            line_split = line.split(" ")
            # copy first 3 items to table.
            output_table = line_split[0:3]
            # sort rest of line_split table
            line_split = line_split[3:]
            line_split.sort()
            # add sorted table to output_table
            output_table.extend(line_split)
            # generate output string
            sorted_line = " ".join(output_table)
        return sorted_line

def sum_multi_parameters(first, second, *multi):
    '''
    tests of variable list of parameters passed to funcion
    if incorrect type is passed then TypeError exception is raised
        
    >>> sum_multi_parameters(1,2,3,4)
    10
    
    >>> sum_multi_parameters("1",2)
    Traceback (most recent call last):
    ...
    TypeError: Integer type expected as parameters
    '''
    if not isinstance(first, int) or not isinstance(second, int):
        raise TypeError("Integer type expected as parameters")
    number = first + second
    for i in multi:
        if not isinstance(i, int):
            raise TypeError("Integer type expected as parameters")
        number += i
    return number

def main():
    '''
    funkcja main, bezuzyteczna teraz
    '''
    print("Nothing to show yet")
    print(sum_multi_parameters(1, 2, "3"))

if __name__ == '__main__':
    main()
