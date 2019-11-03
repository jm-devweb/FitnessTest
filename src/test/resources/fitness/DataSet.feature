Feature: DataSet

  Scenario Template: Add Set
    Given Create a new Dataset <input>
    When Get size
    Then Check the size <expected output>
    Examples:
      |input|expected output|
      |SQUAT;10;50.5|1|

  Scenario Template: Stat One
    Given Set exercise<input>
    When Calculate state one
    Then Check state one <expected output>
    Examples:
      |input|expected output|
      |SQUAT|poids moyen soulevé :  50,8 kg poids max soulevé :  55.0 kg|

  Scenario Template: Stat Two
    Given Set exercise<input>
    When Calculate state two
    Then Check state two <expected output>
    Examples:
      |input|expected output|
      |SQUAT|nombre moyen de répétitions : 11 reps nombre max de répétition : 12 reps|

  Scenario Template: Stat Three
    Given Set exercise<input>
    When Calculate state three
    Then Check state three <expected output>
    Examples:
      |input|expected output|
      |SQUAT|poids moyen soulevé par set : 559,3 kg poids max soulevé par set : 600 kg|