Feature: filter tools by price

  Background:
    Given user logged in
    And the system is connected with a local database
    And the page for display tools is opened


  Scenario: filter tools by price (there are items within given price range)
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to filter displayed tools by price within range [200,600]
    Then the system shows a list of tools that belong to this price range as follows:
      | Name          | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator      | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |

  Scenario: filter tools by price (there are no items in this price range)
    Given There are tools stored in the inventory as follows:
      | Name             | label | Expiration date | Category | Price | Supplier  | Quantity | Reusable | Minimum quantity |
      | Elevator         | 555   | 2023/01/01      | Surgical | 500   | Supplier1 | 10       | true     | 3                |
      | Needle holder    | 1215  | 2023/01/01      | Surgical | 200   | s1        | 10       | true     | 3                |
      | Bracket tweezers | 840   | 2023/05/01      | Ortho    | 150   | s2        | 10       | true     | 3                |
    When the user requests to filter displayed tools by price within range [700,1000]
    Then The system will respond with a message : "No items found"