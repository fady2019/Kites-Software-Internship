Feature: filter tools by category

  Background:
    Given user logged in
    And the system is connected with a local database
    And the page for display tools is opened


  Scenario: filter tools by category (there are items in this category)
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to filter displayed tools by category "Surgical"
    Then the system shows a list of tools that belong to this category as follows:
      | Name          | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator      | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |

   Scenario: filter tools by category (there are no items in this category)
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to filter displayed tools by category "Endo"
    Then The system will respond with a message : "No items found"
