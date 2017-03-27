# AgroEmpresarial-SistemaDeGerenciamento

 Este artigo descreve um sistema de gerenciamento para empresas de vendas de peças agrícolas onde e possível efetuar a venda de peças controlando seu estoque com entradas e saídas e uma ferramenta financeira responsavel pelo gerenciamento de pagamentos. Abordando tambem o desenvolvimento do sistema em etapas contendo diagramas de caso de uso, diagrama de classes, modelagem de banco de dados, tecnologias utilizadas, principais telas do sistemas.
 
 ------------------------------

### 1. Diagrama E-R - Modelo de banco de dados

<img src="https://uploaddeimagens.com.br/images/000/872/063/original/1.png?1490623965">

### 2. Diagrama de Classe

<img src="https://uploaddeimagens.com.br/images/000/872/078/full/5.png?1490625145">

### 3. Caso de uso

<img src="https://uploaddeimagens.com.br/images/000/872/094/full/6.png?1490625904">

 ### 4. Tecnologias Utilizadas
 Java + Swing + JPA(hibernate) + iText + JfreeChart + MySql
 
 ### 5. Interface do sistema
 Nesse topico serão mostradas as principais telas do sistemas seguindo de suas funcionalidades.
 
 #### 5.1. Login
Inicialmente o sistema inicia na tela de “login” Figura 7 onde o funcionario ir á entrar com seus dados de autenticacão.

<img src="https://uploaddeimagens.com.br/images/000/872/103/full/7.png?1490626274">

#### 5.2 Menu Principal
A tela de “menu principal” serão informadas algumas informações como o dia da semana, data e hora atual e o horario que o usuário entrou no sistema. 

<img src="https://uploaddeimagens.com.br/images/000/872/106/full/9.png?1490626408">
 
 #### 5.3 Menus
No menu principal encontra-se na barra de menu, o menu de manutencção onde contará com a manutenção dos dados do sistema, menu gerenciamento onde contará com parte administrativa e financeira, menu de relatorios onde são gerado os relatórios de dados e apuramentos financeiros e no menu de graficos onde são mostrados diversos tipos de graficos e gráficos comparativos, já na tela do sistema encontra-se os botões de “cadastrar cliente”, “Efetuar Venda”, “Consultar” e o botao de “Efetuar Orçamento”. Os botões encontrados na tela de “menu principal” serão todas de “acesso normal”, ou seja, qualquer usuário poderá ter acesso as ações do botões.

<img src="https://uploaddeimagens.com.br/images/000/872/115/full/10.png?1490626952 ">

#### 5.4 Cadastros de Cliente
No Botao de “cadastrar cliente” é apresentada uma tela de cadastros de usuário nela encontramos um “painel de navegação”, “painel de filtro e ordenação”, “tabela de listagem de registros“, “campos de formularios” e o “painel de ações”. 

O painel de navegação tem a utilidade de navegar entre os registro do sistema, alternando entre “primeiro registro”, “registro anterior”, “proximo registro”, “último registro” e “fechar aplicação”. 

No painel de “filtro e ordenação” pode-se filtrar a ordem de apresentação dos registros na “tabela de listagem de registros”, a listagem e feita de ordem crescente e pode-se filtrar a pesquisa por nome. 

A “tabela de listagem de registro” exibe os registros cadastrados na base de dados do sistema. Atraves dessa tabela pode-se selecionar um registro para edita-lo ou exclui-lo. 

No “campo de formulário” ´ e onde são escritas as informações necessárias para o cadastros de um registro, os campos vem desabilitado por padrão, onde só são habilitado caso um novo registro seja solicitado ou editado. 

No “painel de ações” são encontrados os botões “novo”, “editar”, “gravar” e “cancelar”. Por padrao os botões “novo” e “editar” vem habilitados. Assim podendo adicionar um novo registro e editar um registro selecionado.

<img src="https://uploaddeimagens.com.br/images/000/872/120/full/11.png?1490627503">


#### 5.5 Manutencção
As telas dos itens da manutenção possui um layout diferente do layout apresentado no do “Cadastros de Cliente”. Embora ambas tenha a mesma implementação nos paineis foi escolhido deixar os layout da tela de “cadastros de cliente” do “menu principal” ´
com uma interface mais amigavel para o funcionário poder operar as ações, enquanto nas telas de manutenções serem mais limpas porém mas com o layout menos amigável para facilitar dar manutenção aos arquivos. Nas telas de manutenções foi incluído o botao de excluir registro.

<img src="https://uploaddeimagens.com.br/images/000/872/133/full/12.png?1490628214">

#### 5.6 Consultas
O menu de “consultar” se deve para afins de consultas, verifica se um produto existe em estoque ou se um cliente e cadastrado no sistema.

<img src="https://uploaddeimagens.com.br/images/000/872/137/full/13.png?1490628317">

#### 5.7 Orçamento
O menu de “Efetuar Orçamento” possui a finalidade de simular uma venda, ou seja, calcular o valor total de uma compra sem haver necessidade de efetuar uma venda tendo a opção de imprimir a nota de orçamento após concluir o orçamento. 

<img src="https://uploaddeimagens.com.br/images/000/872/143/full/14.png?1490628658">

#### 5.8 Vendas
O menu de “Efetuar venda” efetua uma venda. 

<img src="https://uploaddeimagens.com.br/images/000/872/148/full/15.png?1490629275">

Ao concluir a venda automaticamente fara a baixa de estoque e será exibida uma tela de “confirmação de pagamento” onde o cliente poder escolher a forma de pagamento desejado.

<img src="https://uploaddeimagens.com.br/images/000/872/149/full/16.png?1490629303">

O menu de “confirmação de pagamento” disponibiliza imprimir a nota fiscal da compra. 

<img src="https://uploaddeimagens.com.br/images/000/872/150/full/17.png?1490629328">

#### 5.9  Fazer Pedidos
O menu de “pedidos” e onde são feitas as listas de produtos que pretendem dar entrada de estoque, são listadas no painel de produto somente os produtos com o “estoque” abaixo do “estoque crítico” assim facilitando quais produtos estão com falta de estoque podendo assim pesquisar na barra de pesquisa por outros produtos ja cadastrados ou adicionar novos produtos. Apos a conclusão do pedido é habilitado o botão de imprimir os pedidos.

<img src="https://uploaddeimagens.com.br/images/000/872/157/full/18.png?1490629684">
