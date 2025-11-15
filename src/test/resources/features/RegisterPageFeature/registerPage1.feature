@registerpage1
Feature: Registeration of a new User
Scenario: User sucsssfully register and navigated to Home page
    Given User is on the Website landing page
    When User go to registration page and register
    Then User should navigate to Home page