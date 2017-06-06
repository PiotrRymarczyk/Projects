import time
import re
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.alert import Alert
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait

driver = webdriver.Firefox()
driver.get("http://testfarm.mgc.mentorg.com/beta/?section=groupruns&action=results&id=124602")
assert "Group Runs" in driver.title

elem = driver.find_element_by_name('pass')
elem.send_keys("PASSWORD HERE")
elem = driver.find_element_by_name('user')
elem.send_keys("USER NAME HERE")
elem.send_keys(Keys.RETURN)

time.sleep(10)

ids = driver.find_elements_by_xpath('//*[@id]')
for ii in ids:
	found_id= ii.get_attribute('id')
	if re.search("testrunResultsExpandButton_", found_id):
		print ("ATR: " + found_id)
		ii.click()
		time.sleep(7)
	
#    element = WebDriverWait(driver, 10).until(
#        EC.presence_of_element_located((By.ID, "myDynamicElement"))	

		
		
		
#driver.find_element_by_xpath("(//img[@type='#SUCCEEDED#'])[2]").click()		


#results_2_expand = "(//img[@type='#SUCCEEDED#'])[" + str(index) + "]"
#driver.find_element_by_xpath(results_2_expand).click()		
		
		
		
ids = driver.find_elements_by_xpath("//*[@type='#SUCCEEDED#']")
index = 1
for ii in ids:
	if re.search("img", ii.tag_name):
		print ("Expanded group SUCCEEDED[" + str(index) + "]")
		ii.click()
		index += 1
		time.sleep(15)

		
ids = driver.find_elements_by_class_name("results")
index = 0
for ii in ids:
	index += 1
print ("Znalazlem " + str(index) + " tablic class='results'")
		
assert "No results found." not in driver.page_source
#driver.close()
