Feature:
  As a potential customer I want to navigate through landing page and click everything related to slots machine to check how it works

  Scenario: Verify slots machine page opens in default stae
    Given slots start page is opened
    Then slot machine is displayed
    And Try Me button points to Spin button
    And current bet equals 1

  Scenario: Verify Sping button works and Try Me label changes position
    When client clicks Spin button
    Then slots are spun
    And Total spins amount reduced or upgraded if win or loose
    And Try Me button points to Change Background button

  Scenario: Verify background changes and Try Me label changes position
    When client clicks Change Background button
    Then background changes
    And Try me button not displayed

  Scenario: Verify icons change
    When client clicks Change Icons button
    Then icons change

  Scenario: Verify machine changes
    When client clicks Change Machine button
    Then machine changes

  @NewBrowser
  Scenario: Verify that client cant decrease bet lower than 1
    Given slots start page is opened
    When client press arrow to decrease bet 2 times
    Then current bet equals 1

  Scenario: Verify client can increase bet and multiplier changes accordingly
    When client press arrow to increase bet 8 times
    Then current bet equals 9
    And win chart shows updated multiplies by current bet amount

  Scenario: Verify client cant increase bet higher than 10
    When client press arrow to increase bet 4 times
    Then current bet equals 10

  Scenario: Verify client can decrease bet and multiplier changes accordingly
    When client press arrow to decrease bet 6 times
    Then current bet equals 4
    And win chart shows updated multiplies by current bet amount

  Scenario: Spin until win to verify won points amount
    When client clicks Spin button until win
    Then Total spins amount reduced or upgraded if win or loose
    Then last win field updates or remains according to win or loose

  Scenario: Spin and lose right after win to verify last win records are saved
    When client clicks Spin button to lose
    Then Total spins amount reduced or upgraded if win or loose
    Then last win field updates or remains according to win or loose
    ## here test will fail as actual bug related to resetting last win label after second spin is present

  @NewBrowser
  Scenario: Verify client redirected to PayPal page after Buy Now by PayPal
    Given slots start page is opened
    When client clicks Buy Now with Paypal button
    Then current page url has text paypal.com

  @NewBrowser
  Scenario: Verify client redirected to BitPay page after Buy Now by Bitcoin
    Given slots start page is opened
    When client clicks Buy Now with Bitcoin button
    Then current page url has text bitpay.com