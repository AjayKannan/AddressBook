# AddressBook

# Features used

Spring security with basic auth (test username=user password=user)
AOP for logging ( refer LoggingAOPConfig.java)
H2 database for in memory tables ( refer data.sql for test data)
Swagger documentation
Mocito for mock and junit



# checkout from git
git clone https://github.com/AjayKannan/AddressBook.git

# build jar and execute
cd AddressBook

mvn clean install

cd target

java -jar address-book-0.0.1-SNAPSHOT.jar

# For swagger documentaion
http://localhost:9090/swagger-ui.html 

# To test search contact in address book
curl -X GET  http://localhost:9090/v1/contact?surname=kannan -H "Authorization: Basic dXNlcjp1c2Vy"

# to fetch address for a contact
curl -X GET  http://localhost:9090/v1/contact/1/address -H "Authorization: Basic dXNlcjp1c2Vy"


