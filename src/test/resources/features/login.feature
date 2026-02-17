
Feature: Login Functionality

    Scenario: Valid to login to bank website
        Given user is on login page
        When user enters username and password
        And user clicks on login button
        Then user should navigate to Homepage