@search
Feature: Verify search functionality

  Scenario: As a guest on the rightmove website I want to search for properties in a particular area
    Given I am on rightmove homepage
    When I do a sale search for "Orpington Station"
    And I verify "Orpington Station" is visible on filters page
    And I set the filters to shortlist the houses
    And click on 'find properties'
    Then I verify that I see results for search
    Then set the search results to 'newest listed'
    Then I select the first proeprty and verify that I am seeing the details of my selected property
