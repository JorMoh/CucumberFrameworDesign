@Regression @userManagement
Feature: Crater User Management
  User management foucuses on access authorization,
  and also creating, updating and deleting items.
  
  Background: 
  Given user is on the login page


  @validLoginTest @smokeTest
  Scenario: User is able to login successfully
    When user enters valid "adminuser@primetechschool.com" and "Testing123"
    And clicks login button
    Then user should be on the dashboard page
    And user quits the browser
    
  @invalidLogin  
  Scenario: Invalid login attempts
    When user enters invalid "ghd@yahoo.com" and "asdfsdfsg"
    And clicks login button
    Then an error message appears
    And user is not logged in
    And user quits the browser
    
  @invalidTestSets
    Scenario Outline: Invalid login attempts
    When user enters invalid username "<username>" and password "<password>"
    And clicks login button
    Then error messages appears
    And user is not logged in
    And user quits the browser
    
    Examples:
    | username                 |  password  |
    |helil@primetechschool.com |  sfdsgdh   |
    |    ghd@yahoo.com         | Testing123 |
    |                          | Testing123 |
    |helil@primetechschool.com |            |
    
             