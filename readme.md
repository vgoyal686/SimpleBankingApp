## SimpleBankingApp

#### Tech Stack:
- Java 1.8
- Mysql v8.0.20
- maven v3.5.0 
- Spring Boot v2.3.2

#### Info:
- There are two API's, one for transaction according to transaction type which is credit and debit, Other one is for checking the account balance. 
- There are two main entities in this system, both entities has common info like id, createdAt, updatedAt, createdBy, updatedBy, one is Account which includes some basic info of account like accountNumber, currentBalance etc., Other is Transaction which includes accountNumber, transactionType, transactionAmount etc.

#### DB:
- Mysql is used
- Two Main Entities: Account, Transaction.
- Flyway datamigration is used, scripts are present in src/main/resources/db/migration. Scripts will create the tables and fill up some demo data if theses things are not present.

#### Steps to run:
- install and setup jdk 1.8.
- install mysql v8.0.20.
- install maven if not installed.
- maven clean build and run the application.