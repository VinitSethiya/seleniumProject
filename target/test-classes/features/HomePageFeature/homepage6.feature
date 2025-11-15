@homepage6
Feature: Adding book in basket
    Scenario: Book added sucsssfully and can view in View basket
        Given On the home page and go to product page
        When Click add to basket
        Then Book should be added in basket 