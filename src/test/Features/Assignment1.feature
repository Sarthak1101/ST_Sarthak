Feature: User login


Background:
Given user launches the application
When user enters the credentials
And Clicks on Sign-in button
Then user should be able to login

@QA
Scenario: Selet among different tabs in category bar
Given user verifies "Women" 
When user clicks Tops in Women 
And user can view tops
And user clicks on Tshirts option in Tops
And user selects and adds a tshirt to cart
And user proceeds to checkout

