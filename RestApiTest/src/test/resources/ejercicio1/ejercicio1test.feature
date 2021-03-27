Feature: Ejercicio1

  @ProjectoToken
  Scenario: As admin user
  I want to create a project with token auth
  So that i am able to manipulate the project

    Given i have access to the Todo.ly

    When i send GET request to url http://todo.ly/api/authentication/token.json
    And i get the property TokenString and save it in TokenValue

    When i send POST request to url http://todo.ly/api/projects.json with
    """
    {
      "Content":"ejercicio1",
      "Icon":"1"
    }
    """
    Then i expect the status code 200
    And i expect the response body
    """
    {
        "Id": "IGNORE",
        "Content": "ejercicio1",
        "ItemsCount": 0,
        "Icon": 1,
        "ItemType": 2,
        "ParentId": null,
        "Collapsed": false,
        "ItemOrder": "IGNORE",
        "Children": [
        ],
        "IsProjectShared": false,
        "ProjectShareOwnerName": null,
        "ProjectShareOwnerEmail": null,
        "IsShareApproved": false,
        "IsOwnProject": true,
        "LastSyncedDateTime": "IGNORE",
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "SyncClientCreationId": null
    }
    """