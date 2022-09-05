Feature: Display tools

  Background:
    Given user logged in
    And the system is connected with a local database


  Scenario: Display tools (database not empty)
    Given There are tools stored in the inventory as follows:
      | Name          | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator      | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
    And the user is logged in
    When the user requests to display the tools in the inventory
    Then the system shows a list of tools that exists in the inventory as follows:
      | Name          | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator      | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |

  Scenario: Display tools (database is empty)
    Given stock empty
    And the user is logged in
    When the user requests to display the tools in the inventory
    Then The system will respond with a "message"
