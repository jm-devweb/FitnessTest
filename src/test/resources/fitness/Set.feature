Feature: Set

  Scenario Template: Give the list of set
    Given the list of type set <input>
    When the list in the class is
    Then Check the list <expected output>
    Examples:
      | input | expected output |
      |SQUATLEG_EXTENSIONLEG_CURLLEG_PRESSCRUNCHPLANKBENCH_PRESSTRICEPS_EXTENSIONBICEPS_CURL|SQUATLEG_EXTENSIONLEG_CURLLEG_PRESSCRUNCHPLANKBENCH_PRESSTRICEPS_EXTENSIONBICEPS_CURL|

  Scenario Template: Get type
    Given Create a new set <input>
    When Get type
    Then Check the type <expected output>
    Examples:
      |input|expected output|
      |SQUAT;10;50.5|SQUAT|

  Scenario Template: Get repetition
    Given Create a new set <input>
    When Get repetition
    Then Check the repetition <expected output>
    Examples:
      |input| expected output |
      |SQUAT;10;50.5|10|

  Scenario Template: Get weight
    Given Create a new set <input>
    When Get weight
    Then Check the weight <expected output>
    Examples:
      | input | expected output |
      |SQUAT;10;50.5|50.5|
