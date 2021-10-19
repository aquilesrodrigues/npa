# npa
NExT - 

===========================================================================

## Spring Boot

Criado pela spring Source em 2012. O Spring Boot tem o propósito de facilitar o setup de projetos Spring. Nenhuma configuração extra de arquivos web, banco e suporte a transação é requerido. Com isso, ganhamos produtividade.

-------------------------------------------------------------

O Spring Boot fornece a maioria dos componentes baseados no Spring que são necessários na maioria das  aplicações de maneira pré-configurada. Você escolhe os módulos que deseja através dos starters  que você incluiu no arquivo  **pom.xml** do seu projeto. 

O Spring Boot pode ser executado em qualquer IDE que dê suporte ao Maven.

Spring disponibiliza a página Spring Initializr (https://start.spring.io/). Nesta página, com alguns cliques, você pode habilitar os módulos desejados em seu projeto.
Se o projeto for gerado a partir do Spring Initializr, tudo isso fica disponível e ainda traz uma instância do Tomcat configurada com um servidor web. Você também pode trocar o servidor web do Tomcat para o Jetty.

Estas configurações todas podem ser feitas também  pela via de comando ou pela sua IDE com o Spring Tool Suite.

:bulb: Spring Boot possui 3 principais componentes::point_down: 

> :ballot_box_with_check: Spring Boot Starter;
> :ballot_box_with_check: Spring Boot AutoConfigurator;
> :ballot_box_with_check: Spring Boot Actuator.

**Spring Boot Starter** - Sua função principal é combinar as várias dependências provinientes de um projeto Spring Boot em uma única dependência.Spring Boot utiliza os inicializadores (*starters*)
**Spring Boot AutoConfigurator** - fornecer as diretivas para resolução de *views* e *resolvers*, define que o servidor web deve ser exposto em localhost na porta 8080.
**Spring Boot Actuator** - As principais funções são o provisionamento de endpoints e a obter métricas da aplicação.

No arquivo "application.properties" atribuímos valores de propriedades para projeto Spring-Boot. 
Outras formas de definir estas propriedades em nosso projeto é  inserindo valores no arquivo **pom.xml**, no arquivo application.yml, utilizando variáveis de ambiente e através do **Command Line**.

Arquivo **pom.xml**

~~~xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.5</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.project</groupId>
	<artifactId>npa</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>npa</name>
	<description>My Project</description>
	<packaging>jar</packaging>
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.20</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
~~~

O diretório padrão do arquivo "***application.properties***"  em um projeto Spring Boot é  **src/main/resources** .

~~~
#Configuracao para postgresql

server.port=8081
app.message=Esta e a propriedade do arquivo ${spring.application.name}

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://enderecodoservidor:5432/nomebanco
spring.datasource.username=myname
spring.datasource.password=mypassword
spring.datasource.validationQuery=SELECT 1

spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
~~~



:bulb: Em uma classe de configuração java podemos mapear propriedades com chaves em comum inserindo a anotação @ConfigurationProperties

--------------------------------------------------------------------------

:bulb: Podemos habilitar o recurso de visualização do log nas formas :point_down:

> :ballot_box_with_check: Alterando a verbosidade nos pacotes do Spring para DEBUG ou TRACE.

> :ballot_box_with_check: Incluindo no arquivo "application.properties"  ou no application.yml a propriedade "debug"="true"

----------------------------------------------------------------------------

:bulb: O arquivo **fat/uber jar** é criado após gerar o build em um projeto Spring Boot. contendo seus pacotes *e* todas as suas dependências. Ele fica disponível para execução.

:bulb: O Spring já possui nativamente as configurações no artefato “spring-boot-autoconfigure”.
Quando desejamos trabalhar com o conceito de auto configuration devemos inserir um conjunto de anotações que definem as dependências em uma classe. Como exemplo temos::point_down: 

> :ballot_box_with_check: A anotação @Condicional em nível de classe;

> :ballot_box_with_check: Depois anotações do conjunto da @Condicional (@CondicionalOnClass | @CondicionalMissingBean | @CondicionalOnProperty)

:vertical_traffic_light: **Comandos no terminal:** 

 **mvn spring-boot:run** --> Executa o projeto
 **mvn clean package**  --> Limpa, empacota a execução de testes unitários e fica pronto para execução.
> Exemplo:
>
> No arquivo pom.xml vamos encontrar o tipo de pacote de nosso projeto, vamos mudar a tag **<packaging>jar</packaging>**, onde podemos mudar "**jar**" para "**war**".
> e no terminal digitaremos novamente o comando:
>
>   `mvn clean package`
>
> :grey_exclamation: Os arquivos por padrão serão gerados na pasta **.\target**
> Este comando vai gerar um novo pacote com extensão .war
>
> Vamos movê-lo da pasta **target** para a pasta **apache-tomcat**
>
>  `mv target/springgoot.war apache-tomcat-9.0.26/webapps`
>
> Agora vamos entrar na pasta e executar:
>
> `cd apache-tomcat-9.0.26/bin`
> `./startup.sh` 
>
> Subir a aplicação com todas as dependências
> java -jar springboot.jar  - 
>
> Listar e exibir o conteúdo de nosso jar
> `jar tf <nomedoarquivo.jar>`

:exclamation: **Comandos passados pela linha de comandos terão prioridades sobre aqueles inseridos nos arquivos!****

| Arquivo de propriedade            | Linha de comando                                        |
| --------------------------------- | ------------------------------------------------------- |
| server.port=8081                  | mvn spring-boot:run -Dserver.port=8085                  |
| spring.application.name=SampleApp | mvn spring-boot:run -Dspring.application.name=SampleApp |
|                                   |                                                         |

 
