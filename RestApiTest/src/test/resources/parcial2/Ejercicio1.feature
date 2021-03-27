Feature: Ejercicio1

  #este es un comentario
  @Parcial2
  Scenario: As admin user
  I want to create adnd update users
  So that i am able to manipulate users

    Given i got access to Todo.ly
    When i POST request to url http://todo.ly/api/user.json with json
    """
    {
      "Email":"ignacio@project.com",
      "FullName": "Ignacio2",
      "Password":"prueba2021"
    }
    """
    Then i expect in the status code 200
    And i expect in the response body
    """
    {
    "Id": "IGNORE",
    "Email": "ignacio@project.com",
    "Password": null,
    "FullName": "Ignacio2",
    "TimeZone": 0,
    "IsProUser": false,
    "DefaultProjectId": "IGNORE",
    "AddItemMoreExpanded": false,
    "EditDueDateMoreExpanded": false,
    "ListSortType": 0,
    "FirstDayOfWeek": 0,
    "NewTaskDueDate": -1,
    "TimeZoneId": "Pacific Standard Time"
}
    """

    When i send then GET request to url http://todo.ly/api/authentication/token.json with user ignacio@project.com and pass prueba2021
    And i get an property TokenString and save it in TokenValue

    When i POST a request to url http://todo.ly/api/user/0.json with json
    """
    {
      "FullName": "Ignacio"
    }
    """
    Then i expect in the status code 200
    And i expect in the response body
    """
    {
    "Id": "IGNORE",
    "Email": "ignacio@project.com",
    "Password": null,
    "FullName": "Ignacio",
    "TimeZone": 0,
    "IsProUser": false,
    "DefaultProjectId": "IGNORE",
    "AddItemMoreExpanded": false,
    "EditDueDateMoreExpanded": false,
    "ListSortType": 0,
    "FirstDayOfWeek": 0,
    "NewTaskDueDate": -1,
    "TimeZoneId": "Pacific Standard Time"
}
    """