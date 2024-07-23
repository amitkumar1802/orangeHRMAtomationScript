**Project Structure:**

**Resources Folder**

Base Class: Contains the initialization of the WebDriver and utility methods like taking screenshots. This class reads the browser type from application.properties to avoid hardcoding values.
Application Properties: A properties file to store environment-specific configurations such as browser type, URLs, etc.
Log4j XML File: Used for logging purposes to track the execution of tests and to debug issues.
Tests

Login Test: A test method to validate the login functionality using data-driven testing. It reads multiple sets of data to ensure the login feature works correctly under various scenarios.
Dashboard Test: A test method to validate the dashboard functionality post-login using data-driven testing.
Page Object Model (POM)

Folder: Contains the page classes where each class represents a web page and its elements. The POM design pattern helps in maintaining and reusing the code for different pages.
Explanation: Each page class includes methods that perform actions on those web pages, such as login, navigating through the dashboard, etc.
Extent Reports

Folder: Contains the configuration for generating Extent Reports.
Explanation: Extent Reports provide a detailed view of the test execution, including passed, failed, and skipped tests along with screenshots for failed tests. It helps in understanding the test results and in debugging issues.
Listeners

Folder: Contains the TestNG listeners.
Explanation: Listeners are used to perform specific actions during the execution of tests, such as taking screenshots on test failure, logging test start and end times, and generating Extent Reports.
Maven

Usage: Maven is used as a build automation tool to manage dependencies, build the project, and run tests. The pom.xml file contains the necessary dependencies for Selenium, TestNG, Extent Reports, and other libraries.
Explanation: Maven simplifies the project setup by automatically downloading the required libraries and allows for easy project management and integration with CI/CD tools.
TestNG

Usage: TestNG is used as the test framework to manage and run test cases.
Explanation: TestNG provides features like parallel test execution, test configuration, data-driven testing, and reporting. It helps in organizing tests and provides detailed test reports.


*****************************************************************************************************************************************************************************************************************************************************


**How to Run the Tests**

1. Clone the Repository:  git clone <repository_url>
2. Navigate to the Project Directory: cd <project_directory>
3. Install Dependencies: mvn clean install
4. Run Tests: mvn test

*****************************************************************************************************************************************************************************************************************************************************

**Dependencies**

Selenium WebDriver: For browser automation.
TestNG: For test management and execution.
Maven: For project build and dependency management.
Extent Reports: For generating test execution reports.
Log4j: For logging.
WebDriverManager: For managing browser drivers automatically.
Log4j API: For logging API.
Log4j Core: For core logging functionalities.
Apache Commons IO: For file I/O operations required by Extent Reports.


*****************************************************************************************************************************************************************************************************************************************************

**Conclusion**

This framework is designed to be robust and scalable, enabling efficient testing of web applications. By following best practices and design patterns, it ensures maintainability and reusability of code.
