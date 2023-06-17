Feature: Virgin Games
  Checking currency in jackpots bingo

  Scenario: Verify data for currencies
    When    User send GET request to list endpoint
    And     User must get back valid status code 200
    Then    I verify amount is not negative

 