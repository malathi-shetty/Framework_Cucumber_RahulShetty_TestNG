Feature: Search and Place the order for Products

@OffersPage
Scenario: Search Experience for product search in both home and Offers Page

Given User is on GreenCart Landing Page
#When user searched with Shortname "Tom" and extracted actual name of the Product
When user searched with Shortname <Name> and extracted actual name of the Product
#Then user searched for "Tom" shortname in offers page 
Then user searched for <Name> shortname in offers page 
And validate product name matches with landing Page

Examples:
| Name |
| Tom  |
| Beet |