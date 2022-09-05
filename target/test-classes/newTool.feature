Feature: Add new tool

  Background:
    Given user logged in as an inventory manager
    And User add the attributes of the tool as:
      | Name     | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |

  Scenario: Add new tool
    Given inventory manager logged in
    When inventory manager requests to add a tool "Needle holder" with label "1215", expiration date "2023/01/01", category "Surgical", price "200", supplier "s1", quantity "10", reusable "true", minimum quantity "3"
    Then the system makes the reservation as
      | Name          | label | Expiration date | Category | Price | Supplier | Quantity | Reusable | Minimum quantity |
      | Needle holder | 1215  | 2023/01/01      | Surgical | 200   | s1       | 10       | true     | 3                |

  Scenario: Add existing tool
    Given inventory manager logged in
    When inventory manager requests to add a tool "Elevator" with label "555", expiration date "2023/01/01", category "Surgical", price "500", supplier "Supplier1", quantity "10", reusable "true", minimum quantity "3"
    Then The system will respond with an error "message"


