Feature: CreateItem

  @PostItem
  Scenario: As admin user
    I want to create an item
    So that, i am able to manipulate the item

    Given yo tengo acceso a Todo.ly
    When yo envio una peticion POST a la url http://todo.ly/api/items.json con json
    """
    {
      "Content":"IgnacioItem",
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero que el nombre del item sea "IgnacioItem"