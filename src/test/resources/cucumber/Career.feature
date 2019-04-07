Feature: Career page of Hexad.de

  As a candidate,
  I want to use the career page of the hexad.de

  Scenario: Navigate to Hexad.de career page

  When User opens career site of the hexad website
  Then Career page is rendered


  Scenario: Navigate to Apply Page

    When User opens career site of the hexad website
    Then Career page is rendered
    When User click the Apply button
    Then Career Apply Page is rendered