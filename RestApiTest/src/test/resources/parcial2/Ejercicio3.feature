Feature: TokenGETDelete

  @TokenGetAndDelete
  Scenario: As Admin
  i want to get and delete token
  so that i can manipulate tokens

    Given i got access to todoly

    When i send the GET request to url http://todo.ly/api/authentication/token.json
    And i get a property TokenString and save it in TokenValue
    Then i expect a response body
    """
    {
      "TokenString": TokenValue,
      "UserEmail": "ignacio@prueba.com",
      "ExpirationTime": "IGNORE"
    }
    """

    When i send the DELETE request to url http://todo.ly/api/authentication/token.json
    Then i expect a response body
    """
    {
      "TokenString": TokenValue,
      "UserEmail": "ignacio@prueba.com",
      "ExpirationTime": "IGNORE"
    }
    """