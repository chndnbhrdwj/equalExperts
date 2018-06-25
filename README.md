# Introduction
This repository contain the unit tests for creating and deleting a booking record from the link 
http://hotel-test.equalexperts.io/  

Tests have been implemented using 
* MacOS
* Java
* Selenium
* TestNG
* Maven

# PreRequisite
* Firefox Browser
* Maven (if running from command line)

# Test Execution
As this is a maven project, you can run the test by importing the project in a Java IDE

OR

you can also execute the tests with following command from project directory (maven need to be configured on machine)
`mvn clean test`

It launch the Firefox browser for test execution (geckodriver is bundled with the project) 

# Few Manual Test scenarios

* Save button should not be enabled unless mandatory fields are populated
* Error message should be displayed for the empty mandatory fields like 
    * firstname
    * surname
    * price
    * check-in date
    * check-out date

* Check-in date should not be in past
* Check-out date should always be greater than the check-in date
* New record should be created successfully with valid data for mandatory fields
* After deletion,the record should not be available 
* Pagination should be implemented to accommodate multiple records
* Should be able to search/retrieve an existing record
* Should be able to modify an existing record
 
