@homepage2
Feature: Home page with three arrivals only
    Scenario: Find Three sliders on home page
    Given On home page scroll down
    When Check the number of arrivals
    Then If 3 arrivals quit