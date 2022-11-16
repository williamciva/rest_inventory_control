# Rest Inventory Control

Essa aplicação REST API tem como objetivo controlar estoques.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.



### 📋 Pré-requisitos

```
JDK-14 ou Superior
Maven-3.8.6
```
Para ambos os binários acima serão necessário que as variávies de ambiente estejam configuradas corretamente.

[Configurando Variáveis de Ambiente JAVA_HOME e MAVEN_HOME no Windows e Unix](https://medium.com/beelabacademy/configurando-variáveis-de-ambiente-java-home-e-maven-home-no-windows-e-unix-d9461f783c26)



### 🔧 Instalação
Execute em seu terminal:

```
git clone https://github.com/williamciva/rest_inventory_control.git
```

Acesse o repositório clonado utilziando seu terminal:

```
cd rest_inventory_control

```

##### 👷🏻‍♂️ Desenvolvimento

Para realizar a instalação da API em Desenvolvimento se todos os pré requisitos estiverem OK, basta rodar o comando de incialização Maven:

```
mvn spring-boot:run
```

##### 🔥 Produção

Para realizar a instalação da API em produção é recomendável que você faça o build da aplicação em um .JAR e depois o execute utilizando o java. Para isso execute em seu terminal ainda dentro da pasta do projeto:

```
mvn clean package
```
```
java -jar .\target\rest-inventory-control.jar
```



## 🛠️ Construído com

* [Spring Boot](https://spring.io) - Framework API
* [Maven](https://maven.apache.org/) - Gerente de Dependência
* [H2 database](https://www.h2database.com/html/main.html) - Banco de Dados in memory para testes.
* [MySql](https://www.mysql.com) - Banco de Dados Relacional utilizado em Produção.
* [SpringFox](https://springfox.github.io/springfox/) - Utilizado para a Integração com Swagger.
* [Swagger](https://swagger.io) - Documentação da API.



## ✒️ Autores

#### 👨🏻‍💻 Desenvolvimento:
* [William Civa](https://github.com/williamciva) 
* [Andriano Toazza](https://github.com/DolAndi)
* [Fabio Zanella](https://github.com/ZFabioC)
* [Juliano Rodrigues](https://github.com/JulianoRodrigues07)

#### 📃 Documentação:
* [William Civa](https://github.com/williamciva) 



## 📄 Licença Free.



## 🎁 Agradecimentos

* Um café ☕ ao Mestre [*Ricardo da Silva Ogliari*](https://www.linkedin.com/in/ricardoogliari/) por suas aulas de POO e Spring Boot.
* Um brinde 🍻 a todos os usuários do Stack Overflow por salvarem nossas cabeças !!



## 📄 Diagrama da funcionalidade.
![](https://github.com/williamciva/rest_inventory_control/blob/main/DiagramaRestInventory.png)




---



