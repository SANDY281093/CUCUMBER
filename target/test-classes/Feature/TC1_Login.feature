@Login
Feature: Verifying Adactin Hotel Login Page Details

  Scenario Outline: Verifying Adactin Hotel login using valid data
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>"
    Then User should verify after login success message "Hello Sandy281093!"

    Examples: 
      | userName    | password |
      | Sandy281093 | SANdy@93 |

  Scenario Outline: Verifying Adactin Hotel login using valid data with Enter key
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"

    Examples: 
      | userName    | password |
      | Sandy281093 | SANdy@93 |

  Scenario Outline: Verifying Adactin Hotel login using Invalid credentials
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>"
    Then User should verify after login with invalid credential error message contains  "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName | password |
      | Sandy28  | SANdy93  |
