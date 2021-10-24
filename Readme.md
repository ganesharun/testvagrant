# Test Vagrant Test Automation
This is cucumber based test automation suite.

The automation pack has been built using JDK: 11 and mvn 3.6

To run the automation pack please install JDK 11 and mvn 3.6  

the necessary environment variables should be set.

# Libraries Used in the Project
1. Cucumber 5.7
2. TestNG 7.0.1
3. Extent Reports 5.0.4
4. Selenium 4.0.0
5. Log 4j 1.2.17
6. HTML Unit Driver 2.5.2
7. Rest Assured 4.4.0
8. assertj 3.21.0

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