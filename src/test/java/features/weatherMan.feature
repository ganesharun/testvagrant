Feature: that validates weather information from different sources and enables a comparison between them
#
  Scenario Outline:
    Given user navigates to "https://www.accuweather.com/"
    When the page is loaded successfully search for "<city>"
    Then get the api temparature details from the api for the "<city>"
    Examples:
    |city|
    |Chennai|
    |Bengaluru|
    |Delhi|
    |Pune |
    |Mumbai|