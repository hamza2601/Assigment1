Feature: Temperature Based Navigation
  Actor will be taken to one of two pages depending on the termperature.

  Scenario: Admin checks temperature
    Given the actor is on the homepage
    When actor read the displayed temperature
    Then actor will either buy sunscreen or moisturizer
#
#    Scenario: Admin buys cheapest sunscreen
#      Given Admin is on the buy sunscreen homepages
#      When Admin views prices of all the sunscreens
#      Then Admin will buy the cheapest SPF-30 and SPF-50

