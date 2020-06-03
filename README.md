# wicket-kendo-datatable
Wicket Kendo Datatable CRUD

Wicket is not used in many projects as today but still if you are working on legacy ones, you may still need to implement a full grid with CRUD functionalities.

The full working wicket kendo datatable Create, Delete, Update with customization and fixes for missing kendo.all.min.js for non-Pro users.
The original document is mentioned below but in my opinion was missing few important points:
http://www.7thweb.net/wicket-jquery-ui/kendo/datatable/CommandsDataTablePage?2
Making a field invisible. disable or returning a different editor rather than textfield was not easy to figure out by just looking at examples.

## Installation
To run this project you need maven 3.x, minimum java 8.
Run in command line: 
`mvn clean install`
import it in either intellij or eclipse and it should work.

I am using wicket 8.8 and Spring boot 2 and lambda. You don't need to use spring boot or lambda for running wicket kendo but just remember to remove annotationa and replace them with corresponding java code.
