Feature: Place the order for Products

@PlaceOrder
Scenario: Search Experience for product search in both home and Offers Page

Given User is on GreenCart Landing Page
When user searched with Shortname <Name> and extracted actual name of the Product 
And Added "3" items of the selected product to the cart
#Then user searched for <Name> shortname in offers page 
#And validate product name matches with landing Page
Then User proceeds to Checkout and validate the <Name> items in checkout page
And verify user has ability to enter promo code and place the order

Examples:
| Name |
| Tom  |
#| Beet |