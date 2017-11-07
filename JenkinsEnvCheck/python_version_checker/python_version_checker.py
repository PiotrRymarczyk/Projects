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
    (major_version, minor_version, micro_version, _, _) = sys.version_info
    
    return (major_version, minor_version, micro_version)

def main():
    '''
    main function
    '''
    pass

if __name__ == '__main__':
    main()
   