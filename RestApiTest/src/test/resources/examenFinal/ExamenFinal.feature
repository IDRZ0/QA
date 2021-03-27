Feature: ExamenFinal

  #este es un comentario
  @ExamenFinal
  Scenario: As admin user
  I want to create update and delete users
  So that i am able to manipulate users

    Given i get access to Todo.ly
    When i POST the request to url http://todo.ly/api/user.json with json
    """
    {
      "Email":"ignacio@final.com",
      "FullName": "Ignacio2",
      "Password":"2021"
    }
    """
    Then i expected in the status code 200
    And i expected in the response body
    """
    {
    "Id": "IGNORE",
    "Email": "ignacio@final.com",
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

    When i send then GET request to the url http://todo.ly/api/authentication/token.json with user ignacio@final.com and pass 2021
    And i get an property TokenString and save it on TokenValue

    When i f POST request to url http://todo.ly/api/user/0.json with an json
    """
    {
      "FullName": "Ignacio"
    }
    """
    Then i expected in the status code 200
    And i expected in the response body
    """
    {
    "Id": "IGNORE",
    "Email": "ignacio@final.com",
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

    When i send DELETE request to http://todo.ly/api/user/0.json
    Then i expected in the status code 200
    And i expected in the response body
    """
{
    "Id": "IGNORE",
    "Email": "ignacio@final.com",
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