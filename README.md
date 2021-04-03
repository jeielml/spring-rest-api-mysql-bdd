# spring-rest-api-mysql-bdd
Spring Rest API with MySQL sample to create, update, list and remove records using some bdd approaches

## Quick start

Follow the instructions bellow to run th project localy.


### Requirements

You will need the [JDK 11](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk11-downloads-2133151.html) installed to compile the project.
You will need the Apache maven Version 3.5.4 installed to compile the project

### About this project

This is a Spring Boot Maven RestFul API whitch uses MySQL database to store the worstest movies winners for Golden Raspberry Awards

#### Changing Initial Data Source

To change the initial Data Source replace the `src/main/resources/initialdatasource.csv` file content

### Composing your MySQL Enviroment

#### Access the project folder and run
```ssh
docker-compose up -d
```

Docker will create two images linked by the network "logon-compose-network"

* `my-sql` image link your computer port 3306 to docker port 3306 under network "logon-compose-network" ana mantains your volume (see docker compose file)
    
* `mysql-workbench` image link your computer port 3000 to docker port 3000 under network "logon-compose-network"

To access MySQL Workbench throw your browser acess `http://localhost:3000`

Inside MySQL Workbench create a new connection to your MySQL database by de following steps:

- Create a connection to MySQL using the host `my-sql` (host name inside "logon-compose-network")
- Set 'logon' as database name
- Set 'logon' as user name
- Set 'logon' as password

### Running the project

```ssh
 mvn spring-boot:run
```

### Access H2 in memory database

-  http://localhost:8080/h2-console

```
jdbc url = jdbc:h2:mem:testdb
user name = sa
password = password
```

### Restful Local API 

Thi api is on staging enviroment, after 30 minutes of inactivitie it stand by

#### Busca Todos os Fornecedores
```
curl --location --request GET 'http://localhost:8080/api/fornecedores'
```

#### Busca Fornecedor pelo Id
```
curl --location --request GET 'http://localhost:8080/api/fornecedores/1'
```


#### Atualiza Fornecedor pelo Id
```
curl --location --request PUT 'http://localhost:8080/api/fornecedores/1' \
--header 'Content-Type: application/json' \
--data-raw '{
"nome":"jaaziel"
}'
```

#### Cria Fornecedor
```
curl --location --request POST 'http://localhost:8080/api/fornecedores' \
--header 'Content-Type: application/json' \
--data-raw '{
    "nome":"joal",
    "cnpj":"123456789"
}'
```

