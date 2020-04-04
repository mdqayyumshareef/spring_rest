# spring_rest

This code sample demonstrates rest api with spring boot and spring data JPA.

Clone the project and open the folder in IntelliJ, then simply run the project.


I have used employee example to demonstrate the APIs

Employee Attributes:

* ID - long
* name - String
* role - String

### APIs

* New employee - POST: localhost:8080/employee (body: name, role)
* For all employees - GET: localhost:8080/employee
* Employee details by ID - GET: localhost:8080/employee/{ID}
* Update employee - PUT: localhost:8080/employee/{ID} (body: name, role)
* Delete employee - DELETE: localhost:8080/employee/{ID}