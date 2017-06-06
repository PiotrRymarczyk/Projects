# -*- coding: utf-8 -*-
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import Select
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest, time, re

class SelIDE(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://testfarm.mgc.mentorg.com/"
        self.verificationErrors = []
        self.accept_next_alert = True
    
    def test_sel_i_d_e(self):
        driver = self.driver
        driver.get(self.base_url + "/beta/?section=groupruns&action=results&id=124602")
        
        time.sleep(10)
        
        elem = driver.find_element_by_name('pass')
        elem.send_keys("PASSWORD HERE")
        elem = driver.find_element_by_name('user')
        elem.send_keys("USER NAME HERE")
        elem.send_keys(Keys.RETURN)
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898888").click()
        
#        time.sleep(10)
#        driver.find_element_by_css_selector("img.expandTestsTypeButton").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898889").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("//img[@type='#FAILED#']").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[2]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898883").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[3]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898886").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#FAILED#'])[2]").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[4]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898887").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[5]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898882").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[6]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898890").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[7]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898891").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[8]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898884").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[9]").click()
        
        time.sleep(10)
        driver.find_element_by_id("testrunResultsExpandButton_2898885").click()
        
        time.sleep(10)
        driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[10]").click()
        
    
    def is_element_present(self, how, what):
        try: self.driver.find_element(by=how, value=what)
        except NoSuchElementException as e: return False
        return True
    
    def is_alert_present(self):
        try: self.driver.switch_to_alert()
        except NoAlertPresentException as e: return False
        return True
    
    def close_alert_and_get_its_text(self):
        try:
            alert = self.driver.switch_to_alert()
            alert_text = alert.text
            if self.accept_next_alert:
                alert.accept()
            else:
                alert.dismiss()
            return alert_text
        finally: self.accept_next_alert = True
    
    def tearDown(self):
        #self.driver.quit()
        self.assertEqual([], self.verificationErrors)

if __name__ == "__main__":
    unittest.main()
