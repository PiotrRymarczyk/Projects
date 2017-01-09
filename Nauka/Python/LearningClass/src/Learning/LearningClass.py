'''
Created on 07.12.2016

@author: prymarcz
'''

class LearningClass(object):
    '''
    classdocs
    '''

    def __init__(self, params):
        '''
        Constructor
        '''
        self.message = params
        
    def PrintMe(self):
        print(self.message)
