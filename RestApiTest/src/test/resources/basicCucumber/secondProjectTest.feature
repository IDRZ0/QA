Feature: Project

  # variables debemos usar simbolos de <NOMBRE DE LA VARIABLE>

  @Projectos
  Scenario Outline: As admin user
  I want to create, update and delete a project
  So that i am able to manipulate the project

    Given yo tengo acceso a Todo.ly
    When yo envio una peticion POST a la url http://todo.ly/api/projects.json con json
    """
    {
      "Content":"<nombreProject>",
      "Icon":"<iconProject>"
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero que el nombre del project sea "<nombreProject>"

    Examples:
      | nombreProject    | iconProject |
      | IgnacioCucumber1 | 1           |
      | IgnacioCucumber2 | 2           |
      | IgnacioCucumber3 | 3           |
      | IgnacioCucumber4 | 4           |