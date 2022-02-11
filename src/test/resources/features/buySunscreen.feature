Feature: Select cheapest SPF-50 and SPF-30 sunscreens
  Scenario: Admin will buy the least expensive sunscreens
    Given Admin is on the buy sunscreen homepages
    When Admin views prices of all the sunscreens
    Then Admin will buy the cheapest SPF-30 and SPF-50
