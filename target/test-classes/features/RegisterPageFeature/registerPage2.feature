@registerpage2
Feature: Registeration with incorrect email
    Scenario: Show warning for incorrect email
        Given On registration page
        When Enter invalid email
        Then Show warning for wrong email