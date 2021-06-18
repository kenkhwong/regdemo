Instruction to run the application
==================================

Start localhost listening on port 8080:

./mvnw spring-boot:run

Example Json:

Endpoint: /users
{"username":"username1","password":"pasSw0rd","email":"user1@reply.com",
"dateOfBirth":"2003-04-02","creditCardNo":"1234567890123456"}

Endpoint: /payments
{"creditCardNo":"1234567890123456","amount":"100"}
