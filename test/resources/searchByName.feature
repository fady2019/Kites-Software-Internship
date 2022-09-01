Feature: Search tools by name

  Background:
    Given user logged in
    And the system is connected with a local database
    And the page for display tools is opened


  Scenario: search for an existing item by name
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to search for a tool from displayed tools by name "Elevator"
    Then the system shows the tool named "Elevator"
      | Name     | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |

  Scenario: search for a tool by name that is not found in database
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to search for a tool from displayed tools by name "drill"
    Then The system will respond with a message : "No items found"

