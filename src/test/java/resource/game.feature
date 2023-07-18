Feature: Game Rock, Paper or Scissors

  Scenario: The user wins when chooses Rock and computer chooses Scissors
    Given the user will choose "rock"
    And the computer will chose "scissors"
    When they play
    Then the user wins