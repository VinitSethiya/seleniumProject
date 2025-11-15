Feature: Registeration with empty email id 
    Scenario: Show error message
        Given User is on Account page for just button click
        When User enter register without clicking 
        Then User see error message for empty email and password