Feature: that validates weather information from different sources and enables a comparison between them
#
  Scenario Outline:
    Given user navigates to "https://www.accuweather.com/"
    When the page is loaded successfully search for "<city>"
    Then get the temperature details of the location
    And get the api temperature details from the api for the "<city>"
    Then check if the difference in temperature is less than "2"
    Examples:
    |city|
    |Chennai|
