Feature: CricInfo

  Scenario: verify match details in CricInfoPage
    Given I navigate to ESPNCricInfo webPage
    Given I have selected CountryEdition as "India"
    When I click on MatchType as "Ranji Trophy"
    And captureMatchCount for the selected matchType "Ranji Trophy"
    Then I verify MatchCount with MatchTiles and MatchCount should be same as MatchTiles Count

  Scenario Outline: verify match details in CricInfoPage
    Given I navigate to ESPNCricInfo webPage
    Given I select CountryEdition as "<countryEditionToSelect>"
    When I click MatchType as "<matchTypeToSelect>"
    And captureMatchCount for selected matchType "<matchTypeToSelect>"
    Then I verify MatchCount with MatchTiles and MatchCount should be same as MatchTiles Count

    Examples: 
      | countryEditionToSelect | matchTypeToSelect |
      | India                  | Ranji Trophy      |
      | Australia              | Spring Challenge  |
