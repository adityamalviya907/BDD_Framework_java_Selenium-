Behavioural driven development automation framework using selenium, cucumber-java, , maven, phantomjs



Tools and technologies used:

1. Language: Java 8
2. Logging: log4j
3. BDD framework: Cucumber jvm
4. Automation tool: Selenium webdriver
5. Build tool: maven
 
Setting up the project:
$ cd selenium_BDD_framework
$ mvn clean install


Running the tests: There are 2 scenarios named as @scenario1 and @scenario2. Ran the tests on chrome, firefox46 

To run both scenarios (@scenario1 and @scenario2) (by default browser would be chrome):
$ mvn test

To run test with configurable browser (for firefox, use -Dbrowser=firefox)
$ mvn test -Dbrowser=chrome

To run tests headlessly
$ mvn test -Dheadless=yes

To run specific scenario:
$ mvn test -Dcucumber.options="--tags @scenario3"

To run multiple mentioned scenarios:
$ mvn test -Dcucumber.options="--tags @scenario3,@scenario2"


Features of the framework:
1. BDD framework using Cucumber-jvm. Features can be written easily using Given,When, Then etc.
2. Browser(chrome/firefox) can be configured at run time  from command line.