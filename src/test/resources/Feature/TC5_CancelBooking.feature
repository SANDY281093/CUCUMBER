@CancelBooking
Feature: Verifying Adactin Hotel Cancel Booking Hotel Page Details

  Scenario Outline: verifying Adactin Hotel cancel booking
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
    And User should cancel order id
    Then User should verify after cancelled order id success message "The booking has been cancelled."

    Examples: 
      | userName    | password | location | hotels      | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | billingAddress |
      | Sandy281093 | SANdy@93 | Paris    | Hotel Creek | Deluxe   | 1 - One       | 11/11/2022  | 12/11/2022   | 1 - One       | 1 - One         | Santhosh  | Kumar    | Chennai        |

  Scenario Outline: verifying Adactin Hotel cancel booking  by using existing order id
    Given User is on the Adactin hotel login page
    When User should perform  login "<userName>", "<password>" with Enter key
    Then User should verify after login success message "Hello Sandy281093!"
    And User should cancel the existing order id "<orderId>"
    Then User should verify after cancelled order id success message "The booking has been cancelled."

    Examples: 
      | userName    | password | orderId    |
      | Sandy281093 | SANdy@93 | E6C9WQ265M |
