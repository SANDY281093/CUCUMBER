@SearchHotel
Feature: Verifying Adactin Hotel Search Hotel Page Details

  Scenario Outline: verifying Adactin Hotel search hotel using valid data
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022| 12/11/2022   | 1 - One       | 1 - One         |

  Scenario Outline: verifying Adactin Hotel search hotel using only mandatory fields
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel enter only mandatory fields "<location>","<numberOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"

    Examples: 
      | userName    | password | location | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | 1 - One       | 11/11/2022| 12/11/2022   | 1 - One       |

  Scenario Outline: verifying Adactin Hotel search hotel only invalid dates
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel with invalid date error message "Check-In Date shall be before than Check-Out Date","Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName    | password | location | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | 1 - One       | 11/11/2022| 10/11/2022   | 1 - One       |

  Scenario Outline: verifying Adactin Hotel search hotel without entering any credentials
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should  search hotel click search without entering any credentials
    Then User should verify after searching a hotel with error message "Please Select a Location"

    Examples: 
      | userName    | password |
      | Sandy281093 | SANdy@93 |
