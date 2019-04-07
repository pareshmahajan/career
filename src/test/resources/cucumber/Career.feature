Feature: Career page of Hexad.de

  As a candidate,
  I want to use the career page of the hexad.de

  Background:
    When User opens career site of the hexad website
    Then Career page is rendered

  Scenario: Navigate to Apply Page
    When User click the Apply button
    Then Career Apply Page is rendered

  Scenario: Verify Job description of the UI developer job
    When User click the Job Description button of the UI developer job
    Then Job Description of the UI developer job is displayed correctly