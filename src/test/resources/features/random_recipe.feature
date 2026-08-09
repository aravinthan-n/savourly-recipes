Feature: Random Recipe / Surprise Me

  AS A user
  I WANT to request a random recipe suggestion
  SO THAT I can easily decide what to cook next

  Scenario: Request a random recipe when recipes exist
    Given the following recipes exist in the system:
      | Name                 | Cooking Time | Main Ingredients           |
      | Lemon Chicken        | 30 minutes   | Chicken, Lemon, Thyme      |
      | Beef Stroganoff      | 30 minutes   | Beef, Mustard, Mushrooms   |
      | Chicken Caesar Salad | 25 minutes   | Lettuce, Chicken, Parmesan |
    When a random recipe is requested
    Then a valid random recipe from the system is returned

  Scenario: Request a random recipe when no recipes exist
    When a random recipe is requested when no recipes exist
    Then the message "Sorry, we currently have no recipes for you" is displayed
