@Regression @create&Update @smokeTest
Feature: As a Crater user,
  I would like to be able to create and update items or services

  Background: 
    Given user is on the login page
    And user logs in
    And user navigates to Items tab

  @createItemOrService
  Scenario: user is able to create an item or service
    When user clicks on the Add Item button
    And user should be on item input page
    When user provides item information “name” and “price” and “unit” and “description”
    And click Save Item button
    Then the Item is added to the Item list table

  @updateItemOrService
  Scenario: user is able to update an item or service
    When selects the item “Books”
    And user should be on item details page
    When user updates the item price to thirty dollars
    And click Update Item button
    Then the Item price is updated to thirty dollars
