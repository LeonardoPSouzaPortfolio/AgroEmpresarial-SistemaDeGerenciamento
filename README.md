# AgroEmpresarial-SistemaDeGerenciamento
Java + Swing + JPA(hibernate) + iText + JfreeChart + MySql

### Diagrama E-R - Modelo de banco de dados
O diagrama E-R (Entidade-Relacionamento) foi pensado e modelado para atender
as necessidades e as funcionalidades presentes no sistema. O diagrama em questao˜
apresenta como cada tabela do banco de dados se relaciona.
Para atender as funcionalidades de controle de vendas, pedidos, orc¸amentos e entrada
de produtos foi escolhido implementar em duas tabelas para melhor performance
do banco, uma para guardar registro do mesmo como data e nome de funcionario e outra ´
para guardar os detalhes desse registro, ou seja, quais produtos foram adicionados como
mostrado na Figura 1 assim evitando redundancia de dados. 

![1](http://187.7.106.14:7963/uploads/Leonardo/tcc-leonardo/76ac41223a/1.png)


Agora serao apresentadas as principais tabelas do E-R. A Figura 2 mostra a tabela ˜
de “produto” ela tem vinculac¸ao com as tabelas “unidade”, “vendaDetalhe”, “orcamen- ˜
toRegistro”, “fornecedor” e “entradaProdutoDetalhe”. A vinculac¸ao do “Produto” com ˜
a tabela “unidade” refere-se a unidade de medida do produto, ou seja, se o produto sera´
vendido por unidade, pacote, caixa ou comprimento. A vinculac¸ao que se tem do “Pro- ˜
duto” com a “vendaDetalhe” trata-se de uma lista de produtos de uma venda, ou seja,
na “vendaRegistro” registras os dados de uma venda como nome do cliente, nome do
“funcionario” que esta efetuando a venda, a data da venda e o valor da venda, enquanto ´
os produtos da venda sao registrados na tabela “vendaDetalhe” onde detalha quais pro- ˜
dutos, sua quantidade e o valor unitario de cada. O mesmo funciona com a vinculac¸ ´ ao˜
do “orcamentoRegistro” e “orcamentoDetalhe” com a tabela “produto”. Na vinculac¸ao˜
entre “produto” e “fornecedor” se tem para fins de consultas, saber qual e o fornecedor ´
de um produto em estoque, e a vinculac¸ao do “produto” e “entradaProdutoDetalhe” segue ˜
a mesma que se tem nas “vendaDetalhe” e “orcamentoDetalhe” fazendo a listagem de
produtos para a entrada de estoque.

![2](http://187.7.106.14:7963/uploads/Leonardo/tcc-leonardo/ece5a2ac61/2.png)

