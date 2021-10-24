# TestVagrant Test Automation
This is cucumber based test automation suite.

The automation pack has been built using JDK: 11 and mvn 3.6

To run the automation pack please install JDK 11 and mvn 3.6  

the necessary environment variables should be set.

# Libraries Used in the Project
1. Cucumber 7.0.0
2. TestNG 7.0.1
3. Selenium 4.0.0
4. Log 4j 1.2.17
5. Rest Assured 4.4.0
6. assertj 3.21.0

# Feature File

Path : ./src/test/java/features

All the feature files will be placed in this path. The feature files will have scenarios and step definition written in Gherkin.

# Step Definition Path

./src/test/java/steps

For the steps defined in the feature files, the step definition will be done in the java class in this package. 

#Steps to Run
 
From Command Line:
Once inside the folder run 

mvn test

#Reports

The reports will get stored in the target folder.
Cucumber-JVM-report.html is the report file, it can be opened in a browser to view the execution report. 

#Driver Configuration:
Chrome 95 is used as a default browser. Please update the driver in the ./src/resources/drivers folder based on the chrome version and os.


for MAC - 'chromedriver_mac'
for Windows - 'chromedriver_win.exe'
for Linux  = 'chromedriver_linux'

#Object Details:

The objects in the framework are maintained using page object model.
POM related can be found in ./src/test/java/pages/

#Assumption:
The temperature difference is set at 1, the script will throw exception when the difference exceeds 1. the value could be changed from the feature file.
