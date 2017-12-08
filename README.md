## Índice
* ![Introdução](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#agroempresarial--sistema-de-gerenciamento)
* ![1. Diagrama E-R - Modelo de banco de dados](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#1-diagrama-e-r---modelo-de-banco-de-dados)
* ![2. Diagrama de Classe](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#2-diagrama-de-classe)
* ![3. Caso de uso](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#3-caso-de-uso)
* ![4. Tecnologias Utilizadas](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#4-tecnologias-utilizadas)
* ![5. Interface do sistema](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#5-interface-do-sistema)
  * ![5.1. Login](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#51-login)
  * ![5.2 Menu Principal](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#52-menu-principal)
  * ![5.3 Menus](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#53-menus)
  * ![5.4 Cadastros de Cliente](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#54-cadastros-de-cliente)
  * ![5.5 Manutenção](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#55-manuten%C3%A7%C3%A3o)
  * ![5.6 Consultas](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#56-consultas)
  * ![5.7 Orçamento](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#57-or%C3%A7amento)
  * ![5.8 Vendas](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#58-vendas)
  * ![5.9  Fazer Pedidos](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#59--fazer-pedidos)
  * ![5.10 Entrada de estoque](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#510-entrada-de-estoque)
  * ![5.11 Contas a receber](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#511-contas-a-receber)
  * ![5.12 Relatórios](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#512-relat%C3%B3rios)
  * ![5.13 Gráficos](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#513-gr%C3%A1ficos)
  * ![5.14 Controle de Acesso](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#514-controle-de-acesso)
* ![6. Segurança do Sistema](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#6-seguran%C3%A7a-do-sistema)
  * ![6.1. SQL Injection](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#61-sql-injection)
  * ![6.2. Erros de preenchimentos de formulários](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#62-erros-de-preenchimentos-de-formul%C3%A1rios)
     * ![6.2.1. Valor inválido](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#621-valor-inv%C3%A1lido)
     * ![6.2.2. Preenchimento obrigatório](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#622-preenchimento-obrigat%C3%B3rio)
  * ![6.3. MD5](https://github.com/LeonardoPSouzaPortfolio/AgroEmpresarial-SistemaDeGerenciamento#63-md5)

 ------------------------------

# Agro Empresarial - Sistema De Gerenciamento

&nbsp;&nbsp;&nbsp;&nbsp;Este artigo descreve um sistema de gerenciamento para empresas de vendas de peças agrícolas onde é possível efetuar a venda de peças controlando seu estoque com entradas e saídas e uma ferramenta financeira responsável pelo gerenciamento de pagamentos. Abordando também o desenvolvimento do sistema em etapas contendo diagramas de caso de uso, diagrama de classes, modelagem de banco de dados, tecnologias utilizadas. principais telas do sistemas e as camada de segurança do sistema.

### 1. Diagrama E-R - Modelo de banco de dados
A **figura 1** representa graficamente as entidades e seus relacionamentos com as de mais entidades do banco de dados.

<img src="https://uploaddeimagens.com.br/images/000/872/063/original/1.png?1490623965" alt="Diagrama ER" title="Clique para ampliar">
  <p align="center">
    <b>Figura 1 - Diagrama ER</b>
  </p>
</img>

### 2. Diagrama de Classe
A **figura 2** descreve a estrutura do sistema modelando suas classes descrevendo, seus atributos e as relações entre objetos.

<img src="https://uploaddeimagens.com.br/images/000/872/078/full/5.png?1490625145" alt="Diagrama de classe" title="Clique para ampliar">
  <p align="center">
    <b>Figura 2 - Diagrama de classe</b>
  </p>
</img>

### 3. Caso de uso
A figura 3 representa o diagrama de caso de uso e descrevendo como cada “autor” operará o sistema.

<img src="https://uploaddeimagens.com.br/images/000/872/094/full/6.png?1490625904" alt="Diagrama de caso de uso" title="Clique para ampliar">
  <p align="center">
    <b>Figura 3 - Diagrama de caso de uso</b>
  </p>
</img>

 ### 4. Tecnologias Utilizadas

 **Java** - Linguagem de programação utilizada.
 
 **Swing** - Interface gráfica do java para criação das telas.
 
 **JPA** - Para persistência dos dados com a implementação do **Hibernate**.
 
 **iText** - Usado para geração de notas fiscais e relatórios.
 
 **JfreeChart** - Usado para geração de gráficos.
 
 **MySql** - Banco de dados
 
 ### 5. Interface do sistema
&nbsp;&nbsp;&nbsp;&nbsp;Nesse tópico serão mostradas as principais telas do sistemas seguindo de suas funcionalidades.
 
 #### 5.1. Login
&nbsp;&nbsp;&nbsp;&nbsp;Inicialmente o sistema inicia na tela de “login” **figura 4** onde o funcionário irá entrar com seus dados de autenticação.

<img src="https://uploaddeimagens.com.br/images/000/872/103/full/7.png?1490626274"
alt="Tela de login" title="Clique para ampliar">
  <p align="center">
    <b>Figura 4 - Tela de login</b>
  </p>
</img>

#### 5.2 Menu Principal
&nbsp;&nbsp;&nbsp;&nbsp;A tela de “menu principal” **figura 5** serão informadas algumas informações como o dia da semana, data e hora atual e o horário que o usuário entrou no sistema.

<img src="https://uploaddeimagens.com.br/images/000/872/106/full/9.png?1490626408">
 alt="Tela do menu principal" title="Clique para ampliar">
  <p align="center">
    <b>Figura 5 - Menu Principal</b>
  </p>
</img>
 #### 5.3 Menus
&nbsp;&nbsp;&nbsp;&nbsp;No menu principal **figura 6** encontra-se na barra de menu, o menu de manutenção onde contará com a manutenção dos dados do sistema, menu gerenciamento onde contará com parte administrativa e financeira, menu de relatórios onde são gerado os relatórios de dados e apuramentos financeiros e no menu de gráficos onde são mostrados diversos tipos de gráficos e gráficos comparativos, já na tela do sistema encontra-se os botões de “cadastrar cliente”, “Efetuar Venda”, “Consultar” e o botão de “Efetuar Orçamento”. Os botões encontrados na tela de “menu principal” serão todas de “acesso normal”, ou seja, qualquer usuário poderá ter acesso às ações do botões.

<img src="https://uploaddeimagens.com.br/images/000/872/115/full/10.png?1490626952 " alt="Tela de menus" title="Clique para ampliar">
  <p align="center">
    <b>Figura 6 - Menus</b>
  </p>
</img>



#### 5.4 Cadastros de Cliente
&nbsp;&nbsp;&nbsp;&nbsp;No Botão de “cadastrar cliente”  **figura 7** é apresentada uma tela de cadastros de usuário nela encontramos um “painel de navegação”, “painel de filtro e ordenação”, “tabela de listagem de registros“, “campos de formulários” e o “painel de ações”.

&nbsp;&nbsp;&nbsp;&nbsp;O painel de navegação tem a utilidade de navegar entre os registro do sistema, alternando entre “primeiro registro”, “registro anterior”, “próximo registro”, “último registro” e “fechar aplicação”.

&nbsp;&nbsp;&nbsp;&nbsp;No painel de “filtro e ordenação” pode-se filtrar a ordem de apresentação dos registros na “tabela de listagem de registros”, a listagem é feita de ordem crescente e pode-se filtrar a pesquisa por nome.

&nbsp;&nbsp;&nbsp;&nbsp;A “tabela de listagem de registro” exibe os registros cadastrados na base de dados do sistema. Através dessa tabela pode-se selecionar um registro para editá-lo ou excluí-lo.

&nbsp;&nbsp;&nbsp;&nbsp;No “campo de formulário” é onde são escritas as informações necessárias para o cadastros de um registro, os campos vem desabilitado por padrão, onde só são habilitado caso um novo registro seja solicitado ou editado.

&nbsp;&nbsp;&nbsp;&nbsp;No “painel de ações” são encontrados os botões “novo”, “editar”, “gravar” e “cancelar”. Por padrão os botões “novo” e “editar” vem habilitados. Assim podendo adicionar um novo registro e editar um registro selecionado.

<img src="https://uploaddeimagens.com.br/images/000/872/120/full/11.png?1490627503" alt="Tela de cadastros de cliente" title="Clique para ampliar">
  <p align="center">
    <b>Figura 7 - Tela de cadastros de cliente</b>
  </p>
</img>




#### 5.5 Manutenção
&nbsp;&nbsp;&nbsp;&nbsp;As telas dos itens da manutenção  **figura8** possui um layout diferente do layout apresentado no do “Cadastros de Cliente”. Embora ambas tenham a mesma implementação nos painéis foi escolhido deixar os layout da tela de “cadastros de cliente” do “menu principal” com uma interface mais amigável para o funcionário poder operar as ações, enquanto nas telas de manutenções serem mais limpas porém mas com o layout menos amigável para facilitar dar manutenção aos arquivos. Nas telas de manutenções foi incluído o botão de excluir registro.

<img src="https://uploaddeimagens.com.br/images/000/872/133/full/12.png?1490628214" alt="Tela de manutenção de cliente" title="Clique para ampliar">
  <p align="center">
    <b>Figura 8 - Tela de manutenção de cliente</b>
  </p>
</img>



#### 5.6 Consultas
&nbsp;&nbsp;&nbsp;&nbsp;O menu de “consultar”  **figura 9** se deve para fins de consultas, verifica se um produto existe em estoque ou se um cliente e cadastrado no sistema.

<img src="https://uploaddeimagens.com.br/images/000/872/137/full/13.png?1490628317" alt="Tela de menu de consulta" title="Clique para ampliar">
  <p align="center">
    <b>Figura 9 - Tela de menu de consulta</b>
  </p>
</img>



#### 5.7 Orçamento
&nbsp;&nbsp;&nbsp;&nbsp;O menu de “Efetuar Orçamento”  **figura 10** possui a finalidade de simular uma venda, ou seja, calcular o valor total de uma compra sem haver necessidade de efetuar uma venda tendo a opção de imprimir a nota de orçamento após concluir o orçamento.

<img src="https://uploaddeimagens.com.br/images/000/872/143/full/14.png?1490628658" alt="Tela de efetuar orçamento" title="Clique para ampliar">
  <p align="center">
    <b>Figura 10 - Tela de efetuar orçamento</b>
  </p>
</img>



#### 5.8 Vendas
&nbsp;&nbsp;&nbsp;&nbsp;O menu de “Efetuar venda”  **figura 11** efetua uma venda.

<img src="https://uploaddeimagens.com.br/images/000/872/148/full/15.png?1490629275" alt="Tela de movimento - venda" title="Clique para ampliar">
  <p align="center">
    <b>Figura 11 - Tela de movimento - venda</b>
  </p>
</img>



&nbsp;&nbsp;&nbsp;&nbsp;Ao concluir a venda automaticamente fará a baixa de estoque e será exibida uma tela de “confirmação de pagamento”  **figura 12** onde o cliente poder escolher a forma de pagamento desejado.

<img src="https://uploaddeimagens.com.br/images/000/872/149/full/16.png?1490629303" alt="Tela de confirmação de pagamento" title="Clique para ampliar">
  <p align="center">
    <b>Figura 12 - Tela de confirmação de pagamento</b>
  </p>
</img>



&nbsp;&nbsp;&nbsp;&nbsp;O menu de “confirmação de pagamento” disponibiliza imprimir a nota fiscal da compra. Ao imprimir a nota fiscal  **figura 13** um PDF com os dados da compra.

<img src="https://uploaddeimagens.com.br/images/000/872/150/full/17.png?1490629328" alt="Relatório da venda" title="Clique para ampliar">
  <p align="center">
    <b>Figura 13 - Relatório da venda </b>
  </p>
</img>

#### 5.9  Fazer Pedidos
&nbsp;&nbsp;&nbsp;&nbsp;O menu de “pedidos”  **figura 14** e onde são feitas as listas de produtos que pretendem dar entrada de estoque, são listadas no painel de produto somente os produtos com o “estoque” abaixo do “estoque crítico” assim facilitando quais produtos estão com falta de estoque podendo assim pesquisar na barra de pesquisa por outros produtos já cadastrados ou adicionar novos produtos. Após a conclusão do pedido é habilitado o botão de imprimir os pedidos.

<img src="https://uploaddeimagens.com.br/images/000/872/157/full/18.png?1490629684" alt="Tela de requerimento de pedidos" title="Clique para ampliar">
  <p align="center">
    <b>Figura 14 - Tela de requerimento de pedidos</b>
  </p>
</img>

#### 5.10 Entrada de estoque
&nbsp;&nbsp;&nbsp;&nbsp;Na entrada de estoque  **figura 15** e o menu onde são inseridos a entrada de produto na empresa, adicionando o valor ao estoque do produto existente.

<img src="https://uploaddeimagens.com.br/images/000/872/162/full/19.png?1490630264" alt="Tela de entrada de produtos" title="Clique para ampliar">
  <p align="center">
    <b>Figura 15 - Tela de entrada de produtos</b>
  </p>
</img>

#### 5.11 Contas a receber
&nbsp;&nbsp;&nbsp;&nbsp;Esse e o menu onde são listadas as contas a serem pagas assim como registrar um pagamento feito a prazo informando o valor pago e assim calculando o “valor restante” como mostrado na  **figura 16** .
Quando o “valor restante” de um pagamento for igual a 0 (zero) automaticamente o status
da conta e mudada para “pago” .

<img src="https://uploaddeimagens.com.br/images/000/872/164/full/20.png?1490630395" alt="Tela de contas a receber" title="Clique para ampliar">
  <p align="center">
    <b>Figura 16 - Tela de contas a receber</b>
  </p>
</img>

#### 5.12 Relatórios
&nbsp;&nbsp;&nbsp;&nbsp;No menu de “Relatórios”  **figura 17** se encontram os relatórios de produtos cadastrados, produtos mais vendidos, relatório de vendas diária, apuramento de vendas diária, mensal e anual, balanço anual e relatórios de vendas avançados

<img src="https://uploaddeimagens.com.br/images/000/872/169/full/21.png?1490630618" alt="Tela de emissão de relatórios" title="Clique para ampliar">
  <p align="center">
    <b>Figura 17 - Tela de emissão de relatórios</b>
  </p>
</img>

#### 5.13 Gráficos
&nbsp;&nbsp;&nbsp;&nbsp;No menu de “Gráficos”  **figura 18** são encontrados gráficos de produtos mais vendidos em vários formatos de gráficos, apuramento mensal e anual, gráficos comparativos onde é possível comparar o apuramento de vendas em duas diferentes épocas (mês/ano).

<img src="https://uploaddeimagens.com.br/images/000/872/172/full/22.png?1490630751" alt="Tela de geração de gráfico" title="Clique para ampliar">
  <p align="center">
    <b>Figura 18 - Tela de geração de gráfico</b>
  </p>
</img>

#### 5.14 Controle de Acesso
&nbsp;&nbsp;&nbsp;&nbsp;O menu “Controle de Acesso”  **figura 19** e onde são concedidos os acessos ao sistema, nele é possível selecionar quais ferramentas do sistema cada usuário terá acesso.

<img src="https://uploaddeimagens.com.br/images/000/872/176/full/23.png?1490630867" alt="Tela de controle de acesso" title="Clique para ampliar">
  <p align="center">
    <b>Figura 19 - Tela de controle de acesso</b>
  </p>
</img>

### 6. Segurança do Sistema
&nbsp;&nbsp;&nbsp;&nbsp;Neste tópico são apresentadas as seguranças e como estão sendo tratados os campos de formulários de maneira que evite possíveis erros de usuários.

#### 6.1. SQL Injection
&nbsp;&nbsp;&nbsp;&nbsp;SQL Injection é uma técnica onde um atacante cria ou altera comandos SQL existentes para expor dados escondidos, ou sobrescrever dados valiosos, ou ainda executar comandos de sistema perigosos no servidor.

&nbsp;&nbsp;&nbsp;&nbsp;O sistema é implementado com o implementação do hibernate e com especificação JPA, essas ferramentas evitam falhas de seguranças como SQL Injection.

#### 6.2. Erros de preenchimentos de formulários
&nbsp;&nbsp;&nbsp;&nbsp;E muito comum formulários aceitar qualquer tipo de valores como preencher letras em campos numéricos ou mesmo esquecer de preencher um campo obrigatório.

#### 6.2.1. Valor inválido
&nbsp;&nbsp;&nbsp;&nbsp;Para evitar esses tipo de erro de usuários foi usada uma classe para tratar preenchimentos de campos impedindo de inserir letras em campos numéricos, converter valores de preços para números flutuantes.

#### 6.2.2. Preenchimento obrigatório
&nbsp;&nbsp;&nbsp;&nbsp;Para evitar que um formulário seja concluído com campos obrigatórios vazios foi criado um método “trataCampos” onde verifica se os campos obrigatórios foi preenchidos caso contrário exibirá uma mensagem informando o campos a serem preenchidos e assim
impedindo que conclua o formulário sem o preenchimento dos campos.

#### 6.3. MD5
&nbsp;&nbsp;&nbsp;&nbsp;O MD5 que é um algoritmo de hash de 128 bits unidirecional usado para criptografar senhas. No formulário de funcionários onde é inserido a senha, ao sair do campo automaticamente é gerado o MD5 no campo senha transformando o valor inserido num hash de 32 caracteres.

&nbsp;&nbsp;&nbsp;&nbsp;Na tela de login onde é inserido o login e a senha do usuário o valor do campo senha é convertido no hash e verificando a integridade do login.
