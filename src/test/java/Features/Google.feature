Feature: Open Google.com

  @google
  Scenario: Verify Google is opening in chrome browser
    Given Open google website
    And Terms and condition popup appears
    When User clicks I agree button
    And Close the browser
