import time
import datetime
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

		
ids = driver.find_elements_by_class_name("results")
index = 0
longest_time = 0
for ii in ids:
	index += 1
	a = ii.find_element_by_xpath(".//tbody/tr[2]/td[3]")
	print (a.text)
	a = ii.find_element_by_xpath(".//tbody/tr[2]/td[4]")
	print (a.text)
	start_time_text = ii.find_element_by_xpath(".//tbody/tr[2]/td[13]")
	print (start_time_text.text)
	stop_time_text = ii.find_element_by_xpath(".//tbody/tr[2]/td[14]")
	print (stop_time_text.text)
	number_text = ii.find_element_by_xpath(".//tbody/tr[2]/td[16]")
	print (number_text.text)
	
	start_time = datetime.datetime.strptime(start_time_text.text, "%Y-%m-%d %H:%M:%S")
	stop_time = datetime.datetime.strptime(stop_time_text.text, "%Y-%m-%d %H:%M:%S")
	difference_time = stop_time - start_time
	print (difference_time)
	if index == 1:
		longest_time = difference_time
	else:
		if (difference_time > longest_time):
			longest_time = difference_time
	#print ((stop_time - start_time)/int(number_text.text))
	
	print ("--------------------------------")
print ("Znalazlem " + str(index) + " tablic class='results'")
print ("Longest time: " + str(longest_time))
		

# String cellText = driver.findElement(By.xpath(" //table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();

assert "No results found." not in driver.page_source
#driver.close()
