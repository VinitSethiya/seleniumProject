Feature: Registeration with empty email id 
    Scenario: Show error message
        Given User is on Account page for only email
        When User only enter email
        Then User see error message for empty password