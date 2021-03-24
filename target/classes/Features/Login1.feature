Feature: Test Login Functionality

  Scenario Outline: Check Login is Successful with valid credentials
    Given Browser is open
    When User is on Homepage
    Then User Click on Sign-in button
    Then User navigated to sign in page
    Then User Enters the Valid Email or "<MobileNumber>"
    And User Click on Continue button
    Then User Enters the Valid Password
    And User Click on Sign-In button
    Then User Navigated to the home page
    And User Mousehover on Accounts and List tab
    And User Click on Sign out button
    Then User Successfully logout 
  
   Examples: 
      | MobileNumber  | 
      | 9553347470 |  