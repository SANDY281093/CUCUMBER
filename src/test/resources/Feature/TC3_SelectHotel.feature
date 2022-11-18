@SelectHotel
Feature: Verifying Adactin Hotel Select Hotel Page Details

  Scenario Outline: verifying Adactin Hotel select hotel
     Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"
    And User should select a hotel and click continue
    Then User should verify after selecting a hotel successs message "Book A Hotel"

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022  | 12/11/2022   | 1 - One       | 1 - One         |

  Scenario Outline: verifying Adactin Hotel without selecting a hotel
      Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"
    And User should click continue without select a hotel
    Then User should verify without selecting a hotel error message "Please Select a Hotel"

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022  | 12/11/2022   | 1 - One       | 1 - One         |
