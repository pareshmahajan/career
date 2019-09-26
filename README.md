## Description

Selenium tests for career page of [some company](https://hexad.de/en/careers.html)

## Assumption:
Test cases for headers footers and other contents are excluded from the script for user flows of career page.

## Pre-requisite to run the tests:
- Firefox browser (version 66.0.2) should have been installed on the client machine where execution will be kicked off

## How to run tests:
`./gradlew clean test` 

## After execution, summary report of the tests can be found at:
`build/reports/tests/test/index.html`

## Detailed report can be found at:
`build/reports/tests/test/packages/default-package.html`

## Notes:
- Last two lines of the 'Scenario: Verify submission of the form with valid values' has been commented out since this tests are being run against the live site.
- While writing the scripts, found that email validation is not treating `user@gmail` value as incorrect.  

