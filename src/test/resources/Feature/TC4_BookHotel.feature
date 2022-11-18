@BookHotel
Feature: Verifying Adactin Hotel Book Hotel Page Details

  Scenario Outline: Verifying Adactin Hotel book a hotel
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"
    And User should select a hotel and click continue
    Then User should verify after selecting a hotel successs message "Book A Hotel"
    And User should book hotel "<firstName>","<lastName>" and "<billingAddress>"
      | cardNo           | creditCardType   | selectMonth | selectYear | cvv |
      | 0123456789123456 | American Express | December    |       2022 | 012 |
      | 0123456789123456 | VISA             | November    |       2022 | 456 |
      | 0123456789123456 | Master Card      | December    |       2022 | 789 |
    Then User should verify after booking success message "Booking Confirmation" and saved order id

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022  | 12/11/2022   | 1 - One       | 1 - One         | Santhosh  | Kumar    | Chennai        |

  Scenario Outline: Verifying Adactin Hotel book a hotel without entering any fields
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should search hotel "<location>","<hotels>","<roomType>","<numberOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrenPerRoom>"
    Then User should verify after searching a hotel success message "Select Hotel"
    And User should select a hotel and click continue
    Then User should verify after selecting a hotel successs message "Book A Hotel"
    And User should click book now
    Then User should verify after click book now button error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022  | 12/11/2022   | 1 - One       | 1 - One         |
