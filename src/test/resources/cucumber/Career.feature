Feature: Career page of Hexad.de

  As a candidate,
  I want to use the career page of the hexad.de

  Background:
    When User opens career page of the hexad website
    Then Career page is rendered

  Scenario: Navigate to Apply Page
    When User click the Apply button
    Then Career Apply Page is rendered

  Scenario: Verify Job description of the UI developer job
    When User click the Job Description button of the UI developer job
    Then Job Description of the UI developer job is displayed correctly

  Scenario: Verify validation on the 'Full Name' field when career form submitted without entering any information
    When User click the Apply button
    Then Career Apply Page is rendered
    When User clicks the Submit Button
    Then User should see the validation message to fill the Full Name

  Scenario: Verify validation on the 'Email' field when career form submitted with just the 'Full Name' field
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Full Name' as "John"
    And User clicks the Submit Button
    Then User should see the validation message to fill the Email

  Scenario: Verify validation on the 'Phone' field when career form submitted with just the 'Full Name' and 'Email' fields
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Full Name' as "John"
    And User sets the 'Email' as "johnd@gmail.com"
    When User clicks the Submit Button
    Then User should see the validation message to fill the Phone

  Scenario: Verify validation on the 'Upload' field when career form submitted with just the 'Full Name', 'Email' and 'Phone' fields
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Full Name' as "John"
    And User sets the 'Email' as "johnd@gmail.com"
    And User sets the 'Phone' as "1234567890"
    When User clicks the Submit Button
    Then User should see the validation message to Upload a Resume file

  Scenario: Verify validation for the 'Terms and Conditions' checkbox when all other required fields on the career form are submitted
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Full Name' as "John"
    And User sets the 'Email' as "johnd@gmail.com"
    And User sets the 'Phone' as "1234567890"
    And User selects the file to upload
    When User clicks the Submit Button
    Then User should see the validation message for the 'Terms and Conditions' checkbox

  Scenario: Verify validation on the 'Email' field when user enters 'Email' field in a bad format
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Full Name' as "John"
    And User sets the 'Email' as "johnd@"
    When User clicks the Submit Button
    Then User should see the validation message to enter a valid email address

  Scenario: Verify submission of the form with valid values
    When User click the Apply button
    Then Career Apply Page is rendered
    When User sets the 'Title' as "Mr"
    And User sets the 'Full Name' as "John Doe"
    And User sets the 'Email' as "johnd@gmail.com"
    And User sets the 'Address' as "445 Mount Eden Road, Mount Eden, Auckland"
    And User sets the 'Phone' as "1234567890"
    And User selects the file to upload
    And User selects the 'Position' as "UI Developer"
    And User selects the 'Job Type' as "Full-Time"
    And User clicks the 'Terms and Conditions' checkbox
#   #Uncomment the following two lines if you want to test the positive flow
#    When User clicks the Submit Button
#    Then User should see the details submitted successfully message