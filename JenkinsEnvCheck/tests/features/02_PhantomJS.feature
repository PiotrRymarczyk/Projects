Feature: PhantomJS enabled

  Scenario: Open simple page with PhantomJS
    Given We have PhantomJS installed
     When We open google.com
     Then PhantomJS will open it