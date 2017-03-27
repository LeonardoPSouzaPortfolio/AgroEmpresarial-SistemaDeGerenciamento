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

#### Menu Principal
A tela de “menu principal” serão informadas algumas informações como o dia da semana, data e hora atual e o horario que o usuário entrou no sistema. 

<img src="https://uploaddeimagens.com.br/images/000/872/106/full/9.png?1490626408">
 
 #### Menus
No menu principal encontra-se na barra de menu, o menu de manutencção onde contará com a manutenção dos dados do sistema, menu gerenciamento onde contará com parte administrativa e financeira, menu de relatorios onde são gerado os relatórios de dados e apuramentos financeiros e no menu de graficos onde são mostrados diversos tipos de graficos e gráficos comparativos, já na tela do sistema encontra-se os botões de “cadastrar cliente”, “Efetuar Venda”, “Consultar” e o botao de “Efetuar Orçamento”. Os botões encontrados na tela de “menu principal” serão todas de “acesso normal”, ou seja, qualquer usuário poderá ter acesso as ações do botões.

<img src="https://uploaddeimagens.com.br/images/000/872/115/full/10.png?1490626952 ">

#### Cadastros de Cliente
No Botao de “cadastrar cliente” é apresentada uma tela de cadastros de usuário nela encontramos um “painel de navegação”, “painel de filtro e ordenação”, “tabela de listagem de registros“, “campos de formularios” e o “painel de ações”. 

O painel de navegação tem a utilidade de navegar entre os registro do sistema, alternando entre “primeiro registro”, “registro anterior”, “proximo registro”, “último registro” e “fechar aplicação”. 

No painel de “filtro e ordenação” pode-se filtrar a ordem de apresentação dos registros na “tabela de listagem de registros”, a listagem e feita de ordem crescente e pode-se filtrar a pesquisa por nome. 

A “tabela de listagem de registro” exibe os registros cadastrados na base de dados do sistema. Atraves dessa tabela pode-se selecionar um registro para edita-lo ou exclui-lo. 

No “campo de formulário” ´ e onde são escritas as informações necessárias para o cadastros de um registro, os campos vem desabilitado por padrão, onde só são habilitado caso um novo registro seja solicitado ou editado. 

No “painel de ações” são encontrados os botões “novo”, “editar”, “gravar” e “cancelar”. Por padrao os botões “novo” e “editar” vem habilitados. Assim podendo adicionar um novo registro e editar um registro selecionado.

<img src="https://uploaddeimagens.com.br/images/000/872/120/full/11.png?1490627503">
