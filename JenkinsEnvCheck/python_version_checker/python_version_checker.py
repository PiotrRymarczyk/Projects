'''
Created:      2017/11/07
Last changes: 2017/11/07

@author: Piotr Rymarczyk

'''

import sys

def get_python_version():
    '''
    return python version (major,minor,micro)
    '''
    (a,b,c,d,e) = sys.version_info
    return (a,b,c)

def main():
    '''
    main function
    '''
    pass

if __name__ == '__main__':
    main()
   