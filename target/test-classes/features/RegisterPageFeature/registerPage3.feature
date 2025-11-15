Feature: Registeration with empty email id 
    Scenario: Show error message
        Given User is on Account page
        When User only enter password
        Then User see error message