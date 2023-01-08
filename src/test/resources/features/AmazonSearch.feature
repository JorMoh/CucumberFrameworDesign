Feature: Amazon Search
As an amazon user,
I want to search Amazon website,
so that I can find what I am looking for and compare options.

@amazonSearchTest
Scenario Outline: Search items on Amazon
 Given I am on the Amazon homepage
 When I enter a search item "<Test Data>" 
 And I click on the search button
 Then I should see the search item "<Test Data>" on the results page
 
 Examples:
 |Test Data|
 |  Chanel |
 |  Dior   |
 | Versace |





