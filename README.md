Hudl Login Page Automation
How to run the tests
1. From terminal
    * Go to the project root folder where the pom.xml file is present
    * Run the maven command - mvn clean test -Dcucumber.feature="com.hudl.app.stepdefs"
    * For Chrome please download the ChromeDriver and pass the location as a param like below, also need to pass browser as a param as the default browser on which tests will be run is Firefox.
        * mvn clean test -Dcucumber.feature="com.hudl.app.stepdefs" -Dbrowser="chrome" -Dchrome_driver_path=“<PATH_TO_CHROMEDRIVER>”
2. From TestRunner class
    * Right click and select Run 'TestRunner'
To view the test results - Open the results.html file under target directory, open in any browser.
