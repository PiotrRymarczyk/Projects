from selenium import webdriver
from behave import given, when, then

@given('We have PhantomJS installed')
def step_impl(context):
    context.driver = webdriver.PhantomJS()
    context.driver.set_window_size(1200, 800)

@when('We open google.com')
def step_impl(context):
    context.driver.get('http://google.com')

@then('PhantomJS will open it')
def step_impl(context):
    assert "Google" in context.driver.title

def after_feature(context):
    context.driver.close()
