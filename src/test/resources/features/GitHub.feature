@Test
Feature: Login user page GitHub

  Scenario Outline: SigIn session in the page Github correctly
    Given the user navigates to www.github.com/login
    When the user enter your <user> and <password>
    And click in the Sig in button and see de home page
    Then the user close session correctly

    Examples:
      |user|                  |password|
      |yulianavelres@gmail.com||PruebasAuto123!|
      |yulianavelres@gmail.com||HolaMundo|
      |PruebasAuto123!||yulianavelres@gmail.com|