<p><a href="materiais de apoio/02-implementacao-de-modelo-conceitual.pdf" target="_blank">Implementa��o do Modelo Conceitual</a></p>

-------------------------------------------------------------------------------
<h1>Se��o 01 - Introdu��o</h1>

<h2>Vis�o geral do curso</h2>

<img src="imgs/01.PNG"/>

Boas pr�ticas em Engenharia de Software.

<img src="imgs/02.PNG"/>

<img src="imgs/03.PNG"/>


-------------------------------------------------------------------------------------
<h1>Se��o 02 - Implementa��o do modelo conceitual</h1>

<h2>Vis�o geral do estudo de caso do cap�tulo</h2>

Diagrama de Classes

<img src="imgs/04.PNG"/>

<h2>Nivelamento JPA</h2>

<img src="imgs/05.PNG"/>

Configura��o do JPA no projeto:
* Crie uma pasta "META-INF" a partir da pasta "src".
* Dentro da pasta META-INF crie um arquivo "persistence.xml".
* Conte�do do arquivo persistence.xml:

```xml

<?xml version="1.0" encoding="UTF-8"?>
<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence
http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd"
version="2.1">
<persistence-unit name="exemplo-jpa" transaction-type="RESOURCE_LOCAL">
		<properties>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
			<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/aulajpa" />
			<property name="javax.persistence.jdbc.user" value="root" />
			<property name="javax.persistence.jdbc.password" value="" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
		</properties>
	</persistence-unit>
</persistence>

```
