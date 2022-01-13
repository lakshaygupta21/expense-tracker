# expense-tracker

Please follow the steps in order to run this microservice on your local environment

1. Make sure Java 11 is set up on your machine

2. In application.properties, please update *spring.datasource.url* with your mariadb database url

3. After this you are all set and good to run the application. The application will run at port 8000

4. Check the following routes as per requirement

## Student

 1. /register    POST
 2. /student/{id}   GET
 
 
## Expense
 
 1. /create-expense   POST
 2. /get-expense/{student_id}   GET
 
 
## Dues

 1. /create-due   POST
 2. /get-dues/{student_id}/{due_type}    GET  ===> due_type can be **fifo** or **lifo**  
 3. /settle-dues   PUT
