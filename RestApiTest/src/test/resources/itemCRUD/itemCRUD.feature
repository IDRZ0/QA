Feature: Item

  @Items
  Scenario: As admin user,
    i want to create, get, update and delete items,
    so that, i am able to manipulate them.

    Given yo tengo acceso a Todo.ly
    When yo envio una peticion POST a la url http://todo.ly/api/items.json con json
    """
    {
      "Content":"IgnacioItem"
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero el response body sea
    """
    {
        "Id": IGNORE,
        "Content": "IgnacioItem",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676934
    }
    """
    And yo obtengo el Id y lo guardo en ID_ITEM
    When yo envio una peticion PUT al url http://todo.ly/api/items/ID_ITEM.json con json
    """
    {
      "Content":"IgnacioItemPUT"
    }
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero el response body sea
    """
    {
        "Id": ID_ITEM,
        "Content": "IgnacioItemPUT",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676934
    }
    """
    When yo envio una peticion GET al url http://todo.ly/api/items/ID_ITEM.json con json
    """
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero el response body sea
    """
   {
        "Id": ID_ITEM,
        "Content": "IgnacioItemPUT",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": false,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676934
    }
    """
    When yo envio una peticion DELETE al url http://todo.ly/api/items/ID_ITEM.json con json
    """
    """
    Then yo espero que el codigo de respuesta sea 200
    And yo espero el response body sea
    """
    {
        "Id": ID_ITEM,
        "Content": "IgnacioItemPUT",
        "ItemType": 1,
        "Checked": false,
        "ProjectId": null,
        "ParentId": null,
        "Path": "",
        "Collapsed": false,
        "DateString": null,
        "DateStringPriority": 0,
        "DueDate": "",
        "Recurrence": null,
        "ItemOrder": null,
        "Priority": 4,
        "LastSyncedDateTime": "IGNORE",
        "Children": [],
        "DueDateTime": null,
        "CreatedDate": "IGNORE",
        "LastCheckedDate": null,
        "LastUpdatedDate": "IGNORE",
        "Deleted": true,
        "Notes": "",
        "InHistory": false,
        "SyncClientCreationId": null,
        "DueTimeSpecified": true,
        "OwnerId": 676934
    }
    """