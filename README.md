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

<h1>Se��o 03 - Opera��es de CRUD e Casos de Uso</h1>

Valida��es de dados

* Sem acesso a dados
	* Sint�ticas
		* Campo n�o pode ser vazio.
		* Valor num�rico m�nimo e m�ximo.
		* Comprimento de string m�nimo e m�ximo.
		* Somente d�gitos.
		* Padr�o (express�o regular): (##)-####-####
	* Outras
		* Data futura / passada.
	* Mais de um campo
		* Confirma��o de senha igual � senha.

* Com acesso a dados
	* Email n�o pode ser repetido.
	* Cada cliente pode cadastrar no m�ximo tr�s cupons por m�s.

Entidade Categoria:

* Valida��es sint�ticas
	* Nome n�o pode ser vazio.
	* Nome deve conter entre 5 e 80 caracteres.

<h2>Nivelamento sobre SQL e JPQL</h2>

* JPQL
	* Linguagem de consulta da JPA.
	* Similar � SQL, por�m as consultas s�o expressas em "n�vel" de objetos.
	* � obrgat�ria a atribui��o de um "alias" (apelido) aos objetos pretendidos na consulta.
		* SELECT * FROM CLIENTE -> retorna um resultset com os dados da tabela CLIENTE
		* SELECT obj FROM Cliente obj -> retorna um List<Cliente>

<h2>Modelo Orientado a Objetos (Diagrama de Classes) x Modelo Relacional</h2>

* Existem certas diferen�as entre os dois modelos.

<img src="imgs/06.PNG"/>

* Consultas Simples
	* Produtos cuja categoria possui id = 1
	* SQL : SELECT * FROM PRODUTO WHERE CATEGORIA_ID = 1;
	* JPQL : SELECT obj FROM Produto obj WHERE obj.categoria.id = 1;

* Jun��o Simples
	* Produtos cuja categoria possui nome 'Inform�tica'
	* SQL : SELECT PRODUTO.* FROM PRODUTO, CATEGORIA WHERE PRODUTO.CATEGORIA_ID = CATEGORIA.ID AND CATEGORIA.NOME = 'Inform�tica'


* Opera��o "Produto Cartesiano"
	* Cruzamento de dados com mais de uma tabela.
	* SELECT * FROM PRODUTO, CATEGORIA

<img src="imgs/07.PNG"/>


* Opera��o "Jun��o":
	* SELECT * FROM PRODUTO, CATEGORIA WHERE PRODUTO.CATEGORIA_ID = CATEGORIA.ID 

<img src="imgs/08.PNG"/>

SELECT * FROM PRODUTO, CATEGORIA WHERE PRODUTO.CATEGORIA_ID = CATEGORIA.ID AND CATEGORIA.NOME = 'Inform�tica'

<img src="imgs/09.PNG"/>

* SQL: 
	* SELECT PRODUTO.* FROM PRODUTO, CATEGORIA WHERE PRODUTO.CATEGORIA_ID = CATEGORIA.ID AND CATEGORIA.NOME = 'Inform�tica'
	* Com Inner Join: SELECT * FROM PRODUTO INNER JOIN CATEGORIA cat ON PRODUTO.CATEGORIA_ID = cat.ID WHERE cat.NOME = 'Inform�tica'

JPQL: SELECT obj FROM Produto obj WHERE obj.categoria.nome = 'Inform�tica'

* Exemplo mais complexo
	* Recuperar todos os produtos cujo nome contenha um dado string, que perten�a a pelo menos uma categoria dentre as categorais de uma dada lista

<img src="imgs/10.PNG"/>

* Consulta o exemplo acima em SQL:  SELECT DISTINCT * FROM PRODUTO INNER JOIN PRODUTO_CATEGORIA cat1 ON PRODUTO.ID = cat1.PRODUTO_ID INNER JOIN CATEGORIA cat2 ON cat1.CATEGORIA_ID = cat2.ID WHERE PRODUTO.NOME LIKE ? AND cat2_.ID in (?, ?) => Substitu�do por Strings no Java.

* Consulta em JPQL: SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias => Substit�ido por Strings e Listas






