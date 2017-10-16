-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 26-Nov-2015 às 12:41
-- Versão do servidor: 5.6.25
-- PHP Version: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agroempresarial`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acesso`
--

CREATE TABLE IF NOT EXISTS `acesso` (
  `id` int(11) NOT NULL,
  `modelo` varchar(50) NOT NULL,
  `idFuncionario` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `acesso`
--

INSERT INTO `acesso` (`id`, `modelo`, `idFuncionario`) VALUES
(14, 'Bairro', 31),
(15, 'Cidade', 31),
(16, 'Cliente', 31),
(17, 'Fornecedor', 31),
(18, 'Função', 31),
(19, 'Funcionário', 31),
(20, 'Produto', 31),
(21, 'Tipo Fornecedor', 31),
(22, 'Tipo Pagamento', 31),
(23, 'Unidade', 31),
(24, 'Controle de Acesso', 31),
(25, 'Pedido', 31),
(26, 'Entrada', 31),
(27, 'Contas a receber', 31),
(28, 'Produto', 31),
(29, 'Mais Vendidos', 31),
(30, 'Vendas do dia', 31),
(31, 'Balanço Anual', 31),
(32, 'Pesquisa Venda', 31),
(33, 'Pizza', 31),
(34, 'Linha', 31),
(35, 'Barras', 31),
(36, 'Área', 31),
(37, 'Pizza', 31),
(38, 'Barras', 31),
(39, 'Valores Anual', 31),
(40, 'Valores por Epocas', 31),
(41, 'Entrada e Saída', 31),
(42, 'Produto', 33);

-- --------------------------------------------------------

--
-- Estrutura da tabela `bairro`
--

CREATE TABLE IF NOT EXISTS `bairro` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `idCidade` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `bairro`
--

INSERT INTO `bairro` (`id`, `nome`, `idCidade`) VALUES
(10, 'Simões Lopes', 12),
(11, 'Fragata', 12),
(12, 'Guabiroba', 12),
(13, 'Castilho', 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cidade`
--

CREATE TABLE IF NOT EXISTS `cidade` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cidade`
--

INSERT INTO `cidade` (`id`, `nome`) VALUES
(12, 'Pelotas');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL COMMENT 'codigo do cliente - auto-incremento',
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `rg` varchar(25) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  `clienteDesde` date DEFAULT NULL,
  `fone` varchar(50) DEFAULT NULL,
  `celular` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `idBairro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1 COMMENT='tabela que armazena os dados dos clientes';

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `cpf`, `rg`, `endereco`, `dataNascimento`, `clienteDesde`, `fone`, `celular`, `email`, `idBairro`) VALUES
(27, 'Fábio Lopes', '123.456.789-10', '1234567890', 'Rua 1', '1994-10-10', '2015-09-27', '(32)1234-5678', '(53)9876-5432', 'fabiolopes@senacrs.com', 10),
(28, 'Jarbas', '109.876.543-21', '0987654321', 'Rua 2', '0003-02-01', '2015-09-28', '(53)1111-1111', '(53)2222-2222', 'jarbasruiz@senacrs.com', 10),
(29, 'Adriano', '999.999.999-99', '9999999999', 'Rua 3', '1991-11-27', '2015-10-01', '(53)6668-2662', '(53)5454-5454', 'adrianogordo@senac.com', 10),
(30, 'Alessandro', '888.888.888-88', '8888888888', 'Rua 4', '1992-09-10', '2015-10-02', '(53)8888-8888', '(53)8888-8888', 'kakarotto@gmail.com', 10),
(31, 'Caio ', '888.888.888-88', '5151515151', 'Rua Torres Homem', '1993-11-10', '2015-10-05', '(54)0000-0000', NULL, 'abcde@gmail.com', 10),
(32, 'Aluno', '123.456.789-10', '1111111111', 'Rua 15', '1994-10-10', '2015-11-10', '(53)5353-5335', '(53)5335-3535', 'aluno@aluno.com', 13);

-- --------------------------------------------------------

--
-- Estrutura da tabela `entradaprodutodetalhe`
--

CREATE TABLE IF NOT EXISTS `entradaprodutodetalhe` (
  `idEntradaRegistro` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `qtde` int(11) DEFAULT NULL,
  `vlrUnitario` double(11,2) DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `entradaprodutodetalhe`
--

INSERT INTO `entradaprodutodetalhe` (`idEntradaRegistro`, `idProduto`, `qtde`, `vlrUnitario`, `vlrTotal`) VALUES
(1, 18, 5, 10.00, 50.00),
(1, 19, 5, 20.00, 100.00),
(1, 20, 5, 100.00, 500.00),
(1, 21, 5, 30.00, 150.00),
(1, 22, 5, 40.00, 200.00),
(2, 18, 5, 10.00, 50.00),
(2, 19, 4, 20.00, 80.00),
(3, 18, 5, 10.00, 50.00),
(3, 19, 5, 20.00, 100.00),
(4, 18, 5, 10.00, 50.00),
(4, 19, 5, 20.00, 100.00),
(4, 20, 5, 100.00, 500.00),
(5, 18, 4, 10.00, 40.00),
(5, 19, 1, 20.00, 20.00),
(6, 23, 4, 10.00, 40.00),
(8, 18, 2, 10.00, 20.00),
(8, 19, 5, 20.00, 100.00),
(8, 20, 5, 100.00, 500.00),
(8, 21, 2, 30.00, 60.00),
(9, 18, 2, 10.00, 20.00),
(10, 18, 1, 10.00, 10.00),
(11, 18, 1, 10.00, 10.00),
(12, 18, 1, 10.00, 10.00),
(12, 24, 1, 90.00, 90.00),
(13, 18, 3, 10.00, 30.00),
(13, 20, 5, 100.00, 500.00),
(14, 18, 1, 10.00, 10.00),
(14, 19, 5, 20.00, 100.00),
(14, 20, 3, 100.00, 300.00),
(14, 21, 4, 30.00, 120.00),
(14, 22, 4, 40.00, 160.00),
(14, 23, 5, 10.00, 50.00),
(14, 24, 5, 90.00, 450.00),
(15, 22, 4, 40.00, 160.00),
(15, 26, 3, 20.00, 60.00),
(16, 24, 6, 90.00, 540.00),
(17, 23, 3, 10.00, 30.00),
(17, 24, 5, 90.00, 450.00),
(18, 18, 1, 10.00, 10.00),
(18, 26, 2, 20.00, 40.00),
(19, 26, 1, 20.00, 20.00),
(20, 26, 1, 20.00, 20.00),
(21, 18, 1, 10.00, 10.00),
(21, 26, 1, 20.00, 20.00),
(22, 18, 1, 10.00, 10.00),
(22, 27, 2, 0.00, 0.00),
(23, 18, 1, 10.00, 10.00),
(23, 27, 1, 0.00, 0.00),
(24, 18, 1, 10.00, 10.00),
(24, 19, 2, 20.00, 40.00),
(25, 18, 1, 10.00, 10.00),
(25, 19, 1, 20.00, 20.00),
(25, 20, 1, 100.00, 100.00),
(26, 18, 1, 10.00, 10.00),
(26, 19, 1, 20.00, 20.00),
(26, 20, 1, 100.00, 100.00),
(27, 18, 1, 10.00, 10.00),
(27, 19, 1, 20.00, 20.00),
(27, 20, 1, 100.00, 100.00),
(28, 18, 1, 10.00, 10.00),
(28, 20, 1, 100.00, 100.00),
(29, 20, 1, 100.00, 100.00),
(30, 25, 2, 100.00, 200.00),
(30, 26, 1, 20.00, 20.00),
(30, 27, 1, 0.00, 0.00),
(31, 18, 1, 10.00, 10.00),
(31, 19, 1, 20.00, 20.00),
(31, 20, 1, 100.00, 100.00),
(32, 18, 1, 10.00, 10.00),
(32, 19, 1, 20.00, 20.00),
(32, 20, 1, 100.00, 100.00),
(33, 18, 1, 10.00, 10.00),
(33, 19, 1, 20.00, 20.00),
(33, 20, 1, 100.00, 100.00),
(34, 18, 1, 10.00, 10.00),
(35, 18, 1, 10.00, 10.00),
(35, 19, 2, 20.00, 40.00),
(35, 20, 2, 100.00, 200.00),
(36, 18, 5, 10.00, 50.00),
(36, 19, 5, 20.00, 100.00),
(36, 20, 5, 100.00, 500.00),
(37, 18, 1, 10.00, 10.00),
(37, 19, 1, 20.00, 20.00),
(37, 20, 3, 100.00, 300.00),
(38, 18, 4, 10.00, 40.00),
(38, 19, 4, 20.00, 80.00),
(38, 20, 2, 100.00, 200.00),
(39, 21, 3, 30.00, 90.00),
(39, 24, 5, 90.00, 450.00),
(39, 25, 5, 100.00, 500.00),
(40, 21, 2, 30.00, 60.00),
(40, 27, 1, 0.00, 0.00),
(41, 22, 10, 40.00, 400.00),
(41, 23, 1, 10.00, 10.00),
(42, 22, 1, 40.00, 40.00),
(42, 28, 1, 50.00, 50.00),
(42, 29, 4, 45.00, 180.00),
(43, 18, 1, 10.00, 10.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `entradaprodutoregistro`
--

CREATE TABLE IF NOT EXISTS `entradaprodutoregistro` (
  `id` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `dataEntrada` date DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `entradaprodutoregistro`
--

INSERT INTO `entradaprodutoregistro` (`id`, `idFornecedor`, `dataEntrada`, `vlrTotal`) VALUES
(1, 8, '2015-09-30', 1000.00),
(2, 8, '2015-10-01', 130.00),
(3, 8, '2015-10-01', 150.00),
(4, 8, '2015-10-01', 650.00),
(5, 8, '2015-10-01', 60.00),
(6, 8, '2015-10-05', 40.00),
(7, 8, '2015-10-09', NULL),
(8, 8, '2015-10-09', 680.00),
(9, 8, '2015-10-09', 20.00),
(10, 8, '2015-10-09', 10.00),
(11, 8, '2015-10-09', 10.00),
(12, 8, '2015-10-09', 100.00),
(13, 8, '2015-10-29', 530.00),
(14, 8, '2015-10-30', 1190.00),
(15, 8, '2015-10-30', 220.00),
(16, 8, '2015-10-31', 540.00),
(17, 8, '2015-11-06', 480.00),
(18, 8, '2015-11-06', 50.00),
(19, 8, '2015-11-06', 20.00),
(20, 8, '2015-11-06', 20.00),
(21, 8, '2015-11-06', 30.00),
(22, 8, '2015-11-06', 10.00),
(23, 8, '2015-11-06', 10.00),
(24, 8, '2015-11-06', 50.00),
(25, 8, '2015-11-06', 130.00),
(26, 8, '2015-11-06', 130.00),
(27, 8, '2015-11-06', 130.00),
(28, 8, '2015-11-06', 110.00),
(29, 8, '2015-11-06', 100.00),
(30, 8, '2015-11-06', 220.00),
(31, 8, '2015-11-06', 130.00),
(32, 8, '2015-11-06', 130.00),
(33, 8, '2015-11-06', 130.00),
(34, 8, '2015-11-06', 10.00),
(35, 8, '2015-11-06', 250.00),
(36, 8, '2015-11-06', 650.00),
(37, 8, '2015-11-06', 330.00),
(38, 8, '2015-11-06', 320.00),
(39, 8, '2015-11-07', 1040.00),
(40, 8, '2015-11-07', 0.00),
(41, 8, '2015-11-07', 10.00),
(42, 8, '2015-11-10', 270.00),
(43, 8, '2015-11-26', 10.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE IF NOT EXISTS `fornecedor` (
  `id` int(11) NOT NULL,
  `idTipoFornecedor` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `rg` varchar(25) DEFAULT NULL,
  `cnpj` varchar(25) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `site` varchar(100) DEFAULT NULL,
  `fone` varchar(13) DEFAULT NULL,
  `celular` varchar(13) DEFAULT NULL,
  `idBairro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id`, `idTipoFornecedor`, `nome`, `cpf`, `rg`, `cnpj`, `endereco`, `email`, `site`, `fone`, `celular`, `idBairro`) VALUES
(8, 6, 'Senac', NULL, NULL, '11.111.111/1111-11', 'Rua 2', 'senacrs@senac.com.br', 'senac.com.br', '(53)3232-3232', '(53)3030-3030', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcao`
--

CREATE TABLE IF NOT EXISTS `funcao` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcao`
--

INSERT INTO `funcao` (`id`, `nome`) VALUES
(13, 'Atendente'),
(14, 'Gerente'),
(15, 'Administrador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int(11) NOT NULL,
  `idFuncao` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `login` varchar(10) DEFAULT NULL,
  `senha` varchar(40) DEFAULT NULL,
  `admissao` date DEFAULT NULL,
  `acessoTotal` char(1) DEFAULT NULL,
  `idBairro` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `idFuncao`, `nome`, `login`, `senha`, `admissao`, `acessoTotal`, `idBairro`) VALUES
(31, 15, 'Leonardo Souza', 'Leonardo', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL, 10),
(32, 13, 'Eliton Fernando', 'Fernando', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL, 10),
(33, 15, 'Aluno', 'Aluno', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL, 12);

-- --------------------------------------------------------

--
-- Estrutura da tabela `orcamentodetalhe`
--

CREATE TABLE IF NOT EXISTS `orcamentodetalhe` (
  `idOrcamentoRegistro` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `qtde` int(11) DEFAULT NULL,
  `vlrUnitario` double(11,2) DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `orcamentodetalhe`
--

INSERT INTO `orcamentodetalhe` (`idOrcamentoRegistro`, `idProduto`, `qtde`, `vlrUnitario`, `vlrTotal`) VALUES
(1, 22, 5, 50.00, 250.00),
(1, 23, 1, 80.00, 80.00),
(2, 18, 1, 20.00, 20.00),
(2, 21, 1, 40.00, 40.00),
(2, 22, 1, 50.00, 50.00),
(2, 23, 5, 80.00, 400.00),
(3, 25, 5, 120.00, 600.00),
(4, 19, 3, 30.00, 90.00),
(4, 23, 1, 80.00, 80.00),
(4, 26, 1, 10.00, 10.00),
(5, 20, 1, 110.00, 110.00),
(6, 20, 1, 110.00, 110.00),
(6, 25, 2, 120.00, 240.00),
(7, 19, 1, 30.00, 30.00),
(7, 20, 1, 110.00, 110.00),
(7, 21, 1, 40.00, 40.00),
(7, 25, 1, 120.00, 120.00),
(8, 18, 1, 20.00, 20.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `orcamentoregistro`
--

CREATE TABLE IF NOT EXISTS `orcamentoregistro` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) DEFAULT NULL COMMENT 'codigo do cliente - auto-incremento',
  `idFuncionario` int(11) DEFAULT NULL,
  `dataOrcamento` date DEFAULT NULL,
  `vlrTotalOrcamento` double(11,2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `orcamentoregistro`
--

INSERT INTO `orcamentoregistro` (`id`, `idCliente`, `idFuncionario`, `dataOrcamento`, `vlrTotalOrcamento`) VALUES
(1, NULL, NULL, '2015-10-09', 330.00),
(2, NULL, NULL, '2015-10-09', 510.00),
(3, 27, 31, '2015-11-07', 600.00),
(4, 28, 31, '2015-11-07', 180.00),
(5, 28, 31, '2015-11-07', 110.00),
(6, 32, 33, '2015-11-10', 350.00),
(7, 27, 31, '2015-11-24', 420.00),
(8, 27, 32, '2015-11-26', 20.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentocliente`
--

CREATE TABLE IF NOT EXISTS `pagamentocliente` (
  `id` int(11) NOT NULL,
  `idTipoPagamento` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL COMMENT 'codigo do cliente - auto-incremento',
  `vlrCompra` double(11,2) DEFAULT NULL,
  `vlrDesconto` double(11,2) DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL,
  `dataPagamento` date DEFAULT NULL,
  `1vencimento` date DEFAULT NULL,
  `parcela` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamentoparafornecedor`
--

CREATE TABLE IF NOT EXISTS `pagamentoparafornecedor` (
  `id` int(11) NOT NULL,
  `idTipoPagamento` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL,
  `vlrDesconto` double(11,2) DEFAULT NULL,
  `vlrPago` double(11,2) DEFAULT NULL,
  `dataPagamento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidodetalhe`
--

CREATE TABLE IF NOT EXISTS `pedidodetalhe` (
  `idPedidoRegistro` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `qtdePedido` int(11) DEFAULT NULL,
  `vlrUnitario` double(11,2) DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedidodetalhe`
--

INSERT INTO `pedidodetalhe` (`idPedidoRegistro`, `idProduto`, `descricao`, `qtdePedido`, `vlrUnitario`, `vlrTotal`) VALUES
(1, 18, NULL, 10, 20.00, 200.00),
(1, 23, NULL, 2, 0.00, 0.00),
(2, 19, NULL, 5, 30.00, 150.00),
(2, 22, NULL, 2, 50.00, 100.00),
(2, 25, NULL, 1, 0.00, 0.00),
(3, 18, NULL, 7, 20.00, 140.00),
(4, 23, NULL, 1, 80.00, 80.00),
(4, 25, NULL, 2, 120.00, 240.00),
(5, 20, NULL, 5, 110.00, 550.00),
(5, 23, NULL, 1, 80.00, 80.00),
(5, 25, NULL, 1, 120.00, 120.00),
(5, 26, NULL, 1, 10.00, 10.00),
(6, 20, NULL, 5, 110.00, 550.00),
(6, 23, NULL, 1, 80.00, 80.00),
(6, 24, NULL, 1, 100.00, 100.00),
(6, 25, NULL, 1, 120.00, 120.00),
(7, 20, NULL, 5, 110.00, 550.00),
(7, 24, NULL, 3, 100.00, 300.00),
(8, 23, NULL, 3, 80.00, 240.00),
(8, 26, NULL, 1, 10.00, 10.00),
(9, 25, NULL, 3, 120.00, 360.00),
(10, 18, NULL, 1, 20.00, 20.00),
(10, 20, NULL, 2, 110.00, 220.00),
(11, 20, NULL, 1, 110.00, 110.00),
(11, 29, NULL, 2, 50.00, 100.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pedidoregistro`
--

CREATE TABLE IF NOT EXISTS `pedidoregistro` (
  `id` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `dataPedido` date DEFAULT NULL,
  `vlrPedido` double(11,2) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pedidoregistro`
--

INSERT INTO `pedidoregistro` (`id`, `idFornecedor`, `dataPedido`, `vlrPedido`) VALUES
(1, 8, '2015-10-05', 200.00),
(2, 8, '2015-10-30', 250.00),
(3, 8, '2015-10-30', 140.00),
(4, 8, '2015-10-31', 320.00),
(5, 8, '2015-11-07', 760.00),
(6, 8, '2015-11-07', 850.00),
(7, 8, '2015-11-07', 850.00),
(8, 8, '2015-11-07', 250.00),
(9, 8, '2015-11-07', 360.00),
(10, 8, '2015-11-10', 240.00),
(11, 8, '2015-11-26', 210.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `ID` int(11) NOT NULL,
  `idUnidade` int(11) NOT NULL,
  `idFornecedor` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL,
  `vlrCompra` double(11,2) DEFAULT NULL,
  `vlrVenda` double(11,2) DEFAULT NULL,
  `numEstoque` int(11) DEFAULT NULL,
  `numEstoqueCritico` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`ID`, `idUnidade`, `idFornecedor`, `descricao`, `vlrCompra`, `vlrVenda`, `numEstoque`, `numEstoqueCritico`) VALUES
(18, 16, 8, 'Produto 1', 10.00, 20.00, 0, 1),
(19, 16, 8, 'Produto 2', 20.00, 30.00, 5, 2),
(20, 16, 8, 'Produto 10', 100.00, 110.00, 4, 10),
(21, 16, 8, 'Produto 3', 30.00, 40.00, 4, 3),
(22, 16, 8, 'Produto 4', 40.00, 50.00, 5, 4),
(23, 16, 8, 'Produto 8', 10.00, 80.00, 2, 8),
(24, 16, 8, 'Produto 9', 90.00, 100.00, 5, 5),
(25, 16, 8, 'Produto 11', 100.00, 120.00, 5, 11),
(26, 16, 8, 'Produto 12', 20.00, 10.00, 5, 12),
(27, 16, 8, 'Produto 15', 0.00, 0.00, 5, 0),
(28, 16, 8, 'Produto 30', 50.00, 0.00, 1, 0),
(29, 16, 8, 'Produto 31', 45.00, 50.00, 2, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipofornecedor`
--

CREATE TABLE IF NOT EXISTS `tipofornecedor` (
  `id` int(11) NOT NULL,
  `descricao` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipofornecedor`
--

INSERT INTO `tipofornecedor` (`id`, `descricao`) VALUES
(5, 'Pessoa Física'),
(6, 'Pessoa Jurídica');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipopagamento`
--

CREATE TABLE IF NOT EXISTS `tipopagamento` (
  `id` int(11) NOT NULL,
  `descricao` varchar(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tipopagamento`
--

INSERT INTO `tipopagamento` (`id`, `descricao`) VALUES
(6, 'À vista'),
(7, 'C. Debito'),
(8, 'C. Credito'),
(9, 'Boleto');

-- --------------------------------------------------------

--
-- Estrutura da tabela `unidade`
--

CREATE TABLE IF NOT EXISTS `unidade` (
  `id` int(11) NOT NULL,
  `descricao` char(5) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1 COMMENT='armazena as diversas unidades dos produtos';

--
-- Extraindo dados da tabela `unidade`
--

INSERT INTO `unidade` (`id`, `descricao`) VALUES
(16, 'Und');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendadetalhe`
--

CREATE TABLE IF NOT EXISTS `vendadetalhe` (
  `idVendaRegistro` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `qtde` int(11) DEFAULT NULL,
  `vlrUnitario` double(11,2) DEFAULT NULL,
  `vlrTotal` double(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendadetalhe`
--

INSERT INTO `vendadetalhe` (`idVendaRegistro`, `idProduto`, `qtde`, `vlrUnitario`, `vlrTotal`) VALUES
(162, 18, 2, 20.00, 40.00),
(162, 19, 1, 30.00, 30.00),
(163, 18, 1, 20.00, 20.00),
(163, 19, 2, 30.00, 60.00),
(164, 18, 6, 20.00, 120.00),
(164, 19, 5, 30.00, 150.00),
(165, 18, 5, 20.00, 100.00),
(165, 20, 3, 110.00, 330.00),
(166, 19, 5, 30.00, 150.00),
(166, 20, 2, 110.00, 220.00),
(167, 21, 1, 40.00, 40.00),
(168, 21, 1, 40.00, 40.00),
(169, 22, 1, 50.00, 50.00),
(170, 21, 1, 40.00, 40.00),
(171, 21, 1, 40.00, 40.00),
(172, 19, 1, 30.00, 30.00),
(172, 21, 1, 40.00, 40.00),
(173, 22, 4, 50.00, 200.00),
(174, 18, 5, 20.00, 100.00),
(175, 20, 5, 110.00, 550.00),
(176, 19, 2, 30.00, 60.00),
(177, 19, 1, 30.00, 30.00),
(178, 19, 2, 30.00, 60.00),
(179, 18, 5, 20.00, 100.00),
(180, 20, 3, 110.00, 330.00),
(180, 21, 2, 40.00, 80.00),
(180, 22, 1, 50.00, 50.00),
(181, 22, 1, 50.00, 50.00),
(182, 22, 1, 50.00, 50.00),
(183, 22, 1, 50.00, 50.00),
(184, 20, 2, 110.00, 220.00),
(184, 21, 3, 40.00, 120.00),
(184, 22, 1, 50.00, 50.00),
(184, 23, 4, 0.00, 0.00),
(185, 19, 5, 30.00, 150.00),
(186, 18, 1, 20.00, 20.00),
(187, 18, 1, 20.00, 20.00),
(188, 18, 1, 20.00, 20.00),
(189, 18, 1, 20.00, 20.00),
(190, 18, 1, 20.00, 20.00),
(191, 22, 1, 50.00, 50.00),
(192, 22, 1, 50.00, 50.00),
(193, 22, 1, 50.00, 50.00),
(194, 22, 2, 50.00, 100.00),
(195, 18, 1, 20.00, 20.00),
(195, 19, 1, 30.00, 30.00),
(195, 20, 1, 110.00, 110.00),
(195, 21, 1, 40.00, 40.00),
(196, 18, 1, 20.00, 20.00),
(196, 19, 1, 30.00, 30.00),
(196, 20, 1, 110.00, 110.00),
(196, 21, 1, 40.00, 40.00),
(197, 19, 1, 30.00, 30.00),
(203, 19, 1, 30.00, 30.00),
(204, 19, 1, 30.00, 30.00),
(204, 20, 1, 110.00, 110.00),
(205, 19, 1, 30.00, 30.00),
(205, 20, 2, 110.00, 220.00),
(206, 19, 1, 30.00, 30.00),
(207, 19, 3, 30.00, 90.00),
(208, 20, 3, 110.00, 330.00),
(208, 24, 1, 100.00, 100.00),
(209, 18, 5, 20.00, 100.00),
(210, 22, 5, 50.00, 250.00),
(211, 23, 5, 80.00, 400.00),
(214, 18, 1, 20.00, 20.00),
(214, 21, 2, 40.00, 80.00),
(215, 18, 2, 20.00, 40.00),
(215, 21, 1, 40.00, 40.00),
(216, 20, 1, 110.00, 110.00),
(216, 21, 1, 40.00, 40.00),
(217, 18, 1, 20.00, 20.00),
(217, 20, 2, 110.00, 220.00),
(218, 18, 2, 20.00, 40.00),
(218, 22, 3, 50.00, 150.00),
(220, 18, 2, 20.00, 40.00),
(220, 24, 5, 100.00, 500.00),
(225, 24, 1, 100.00, 100.00),
(225, 26, 1, 10.00, 10.00),
(227, 24, 3, 100.00, 300.00),
(227, 26, 3, 10.00, 30.00),
(228, 24, 2, 100.00, 200.00),
(230, 23, 3, 80.00, 240.00),
(231, 18, 5, 20.00, 100.00),
(231, 19, 1, 30.00, 30.00),
(231, 20, 1, 110.00, 110.00),
(231, 21, 3, 40.00, 120.00),
(232, 19, 4, 30.00, 120.00),
(232, 20, 4, 110.00, 440.00),
(233, 18, 10, 20.00, 200.00),
(233, 19, 10, 30.00, 300.00),
(233, 20, 10, 110.00, 1100.00),
(234, 25, 2, 120.00, 240.00),
(234, 26, 1, 10.00, 10.00),
(235, 18, 2, 20.00, 40.00),
(236, 19, 5, 30.00, 150.00),
(236, 20, 5, 110.00, 550.00),
(237, 18, 3, 20.00, 60.00),
(237, 21, 2, 40.00, 80.00),
(237, 24, 1, 100.00, 100.00),
(237, 25, 1, 120.00, 120.00),
(238, 24, 4, 100.00, 400.00),
(238, 25, 4, 120.00, 480.00),
(239, 22, 1, 50.00, 50.00),
(239, 23, 1, 80.00, 80.00),
(240, 23, 1, 80.00, 80.00),
(241, 18, 3, 20.00, 60.00),
(242, 18, 1, 20.00, 20.00),
(242, 25, 5, 120.00, 600.00),
(243, 18, 1, 20.00, 20.00),
(243, 22, 1, 50.00, 50.00),
(244, 20, 1, 110.00, 110.00),
(244, 21, 1, 40.00, 40.00),
(244, 29, 2, 50.00, 100.00),
(245, 18, 1, 20.00, 20.00);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vendaregistro`
--

CREATE TABLE IF NOT EXISTS `vendaregistro` (
  `id` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL COMMENT 'codigo do cliente - auto-incremento',
  `idFuncionario` int(11) NOT NULL,
  `idTipoPagamento` int(11) DEFAULT NULL,
  `dataVenda` date DEFAULT NULL,
  `vlrSugerido` double(11,2) DEFAULT NULL,
  `desconto` double(11,2) DEFAULT NULL,
  `totalVenda` double(11,2) DEFAULT NULL,
  `parcela` varchar(10) DEFAULT NULL,
  `1vencimento` date DEFAULT NULL,
  `ativo` varchar(10) DEFAULT NULL,
  `recebeu` double(11,2) NOT NULL,
  `juro` double(11,2) NOT NULL,
  `restante` double(11,2) NOT NULL,
  `valorfinal` double(11,2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=246 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vendaregistro`
--

INSERT INTO `vendaregistro` (`id`, `idCliente`, `idFuncionario`, `idTipoPagamento`, `dataVenda`, `vlrSugerido`, `desconto`, `totalVenda`, `parcela`, `1vencimento`, `ativo`, `recebeu`, `juro`, `restante`, `valorfinal`) VALUES
(162, 27, 31, 6, '2015-09-30', 70.00, NULL, 66.50, '1', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(163, 28, 32, 8, '2015-09-30', 80.00, NULL, 80.00, '4', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(164, 29, 31, 9, '2015-10-01', 270.00, NULL, 270.00, '6', '2015-10-29', 'Pago', 0.00, 0.00, 0.00, 0.00),
(165, 27, 31, 6, '2015-10-01', 430.00, NULL, 408.50, '1', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(166, 27, 31, 9, '2015-10-01', 370.00, 0.00, 370.00, '5', '2015-10-29', 'Pago', 0.00, 0.00, -50.00, 0.00),
(167, 27, 32, NULL, '2015-10-01', 40.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(168, 29, 31, NULL, '2015-10-01', 40.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(169, 27, 31, 8, '2015-10-01', 50.00, 0.00, 50.00, '4', NULL, 'Pago', 5.00, 0.00, 0.00, 0.00),
(170, 29, 32, NULL, '2015-10-01', 40.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(171, 28, 31, NULL, '2015-10-01', 40.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(172, 29, 32, 7, '2015-10-02', 70.00, 0.00, 66.50, '1', NULL, 'Pago', 66.50, 0.00, 0.00, 0.00),
(173, 30, 31, 9, '2015-10-02', 200.00, 0.00, 200.00, '4', '2015-10-30', 'Pago', 0.00, 0.00, 95.00, 0.00),
(174, 30, 32, 7, '2015-10-02', 100.00, 0.00, 95.00, '1', NULL, 'Pago', 0.00, 0.00, 75.00, 0.00),
(175, 29, 32, 8, '2015-10-02', 550.00, 0.00, 550.00, '4', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(176, 30, 31, 8, '2015-10-05', 60.00, 0.00, 60.00, '4', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(177, 29, 31, 7, '2015-10-05', 30.00, 0.00, 28.50, '1', NULL, 'Pago', 0.00, 0.00, 28.50, 0.00),
(178, 27, 31, 7, '2015-10-05', 60.00, 0.00, 57.00, '1', NULL, 'Pago', 0.00, 0.00, 57.00, 0.00),
(179, 28, 32, 8, '2015-10-05', 100.00, 0.00, 100.00, '4', NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(180, 31, 31, 9, '2015-10-05', 460.00, 0.00, 460.00, '5', '2015-11-02', 'Pago', 0.00, 0.00, 0.00, 0.00),
(181, 31, 31, NULL, '2015-10-07', 50.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(182, 31, 32, NULL, '2015-10-07', 50.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(183, 31, 32, NULL, '2015-10-07', 50.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(184, 31, 31, 8, '2014-09-16', 390.00, 0.00, 390.00, '4', '2015-11-04', 'Pago', 0.00, 0.00, 390.00, 0.00),
(185, 27, 32, 6, '2015-10-07', 150.00, 0.00, 142.50, '1', NULL, 'Pago', 0.00, 0.00, 142.50, 0.00),
(186, 28, 31, 8, '2015-10-07', 20.00, 0.00, 20.00, '3', '2015-11-04', 'Pago', 0.00, 0.00, 20.00, 0.00),
(187, 29, 31, 8, '2015-10-07', 20.00, 0.00, 20.00, '3', '2015-11-04', 'Pago', 0.00, 0.00, 0.00, 0.00),
(188, 28, 32, NULL, '2015-10-07', 20.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(189, 30, 32, NULL, '2015-10-07', 20.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(190, 27, 32, 8, '2015-10-07', 20.00, 0.00, 20.00, '3', '2015-11-04', 'Pendente', 15.00, 0.00, 20.00, 0.00),
(191, 31, 32, 7, '2015-10-07', 50.00, 0.00, 47.50, '1', NULL, 'Pago', 0.00, 0.00, 47.50, 0.00),
(192, 29, 32, NULL, '2015-10-07', 50.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(193, 31, 32, 9, '2015-10-07', 50.00, 0.00, 50.00, '3', '2015-11-04', 'Pendente', 0.00, 0.00, 50.00, 0.00),
(194, 29, 31, 6, '2015-10-08', 100.00, 0.00, 95.00, '1', NULL, 'Pago', 0.00, 0.00, 95.00, 0.00),
(195, 27, 31, NULL, '2015-10-08', 200.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(196, 28, 32, NULL, '2015-10-08', 200.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(197, 29, 32, NULL, '2015-10-08', 30.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(198, 27, 31, NULL, '2015-10-08', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(199, 27, 31, NULL, '2015-10-08', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(200, 27, 31, NULL, '2015-10-08', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(201, 27, 31, NULL, '2015-10-08', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(202, 27, 31, NULL, '2015-10-08', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(203, 27, 31, NULL, '2015-10-08', 30.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(204, 27, 31, NULL, '2015-10-08', 140.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(205, 31, 31, 8, '2015-10-09', 250.00, 0.00, 250.00, '3', '2015-11-06', 'Pago', 0.00, 0.00, 0.00, 0.00),
(206, 27, 31, 9, '2015-10-14', 60.00, 0.00, 60.00, '5', '2015-11-11', 'Pendente', 0.00, 0.00, 62.40, 0.00),
(207, 27, 31, 7, '2015-10-14', 90.00, 0.00, 85.50, '1', NULL, 'Pago', 0.00, 0.00, 85.50, 0.00),
(208, 27, 31, 7, '2015-10-14', 650.00, 0.00, 617.50, '1', NULL, 'Pago', 0.00, 0.00, 617.50, 0.00),
(209, 27, 32, 7, '2015-10-14', 100.00, 0.00, 95.00, '1', NULL, 'Pago', 0.00, 0.00, 95.00, 0.00),
(210, 28, 31, 7, '2015-10-14', 250.00, 0.00, 237.50, '1', NULL, 'Pago', 0.00, 0.00, 237.50, 0.00),
(211, 28, 32, 7, '2015-10-14', 400.00, 0.00, 380.00, '1', NULL, 'Pago', 0.00, 0.00, 380.00, 0.00),
(212, 27, 32, NULL, '2015-10-14', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(213, 27, 31, NULL, '2015-10-14', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(214, 28, 31, 6, '2015-10-26', 100.00, 0.00, 95.00, '1', NULL, 'Pago', 0.00, 0.00, 95.00, 0.00),
(215, 28, 32, 8, '2015-10-26', 80.00, 0.00, 80.00, '4', '2015-11-23', 'Pago', 0.00, 0.00, 0.00, 0.00),
(216, 27, 31, 8, '2015-10-29', 150.00, 0.00, 150.00, '5', '2015-11-26', 'Pago', 0.00, 0.00, 0.00, 0.00),
(217, 27, 31, 8, '2015-10-30', 240.00, 0.00, 240.00, '3', '2015-11-27', 'Pago', 0.00, 0.00, 0.00, 0.00),
(218, 28, 31, 8, '2015-10-30', 190.00, 0.00, 190.00, '2', '2015-11-27', 'Pago', 0.00, 0.00, 0.00, 0.00),
(219, 29, 32, NULL, '2015-10-30', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(220, 29, 31, 6, '2015-10-31', 540.00, 0.00, 513.00, '1', NULL, 'Pago', 0.00, 0.00, 513.00, 0.00),
(221, 27, 32, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(222, 28, 32, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(223, 30, 31, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(224, 29, 32, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(225, 27, 31, NULL, '2015-11-05', 110.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(226, 27, 31, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(227, 27, 32, 6, '2015-11-05', 330.00, 0.00, 313.50, '1', NULL, 'Pago', 0.00, 0.00, 313.50, 0.00),
(228, 27, 31, 8, '2015-11-05', 200.00, 0.00, 200.00, '4', '2015-12-03', 'Pendente', 0.00, 0.00, 200.00, 0.00),
(229, 28, 32, NULL, '2015-11-05', NULL, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(230, 27, 31, 7, '2015-11-06', 240.00, 0.00, 228.00, '1', NULL, 'Pago', 0.00, 0.00, 228.00, 0.00),
(231, 28, 31, 6, '2015-11-06', 360.00, 0.00, 342.00, '1', NULL, 'Pago', 0.00, 0.00, 342.00, 0.00),
(232, 27, 31, NULL, '2015-11-06', 560.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(233, 31, 31, 6, '2014-10-10', 1600.00, 0.00, 1520.00, '1', NULL, 'Pago', 0.00, 0.00, 1520.00, 0.00),
(234, 31, 31, 8, '2015-11-06', 250.00, 0.00, 250.00, '5', '2015-12-04', 'Pendente', 0.00, 0.00, 250.00, 0.00),
(235, 31, 31, NULL, '2015-11-06', 40.00, NULL, NULL, NULL, NULL, 'Pago', 0.00, 0.00, 0.00, 0.00),
(236, 30, 31, 6, '2014-10-10', 700.00, 0.00, 665.00, '1', NULL, 'Pago', 0.00, 0.00, 665.00, 0.00),
(237, 29, 32, 8, '2015-11-07', 360.00, 0.00, 360.00, '4', '2015-12-05', 'Pendente', 0.00, 0.00, 360.00, 0.00),
(238, 27, 31, 6, '2015-11-07', 880.00, 0.00, 836.00, '1', NULL, 'Pago', 0.00, 0.00, 836.00, 0.00),
(239, 30, 32, 9, '2015-11-08', 210.00, 0.00, 210.00, '5', '2015-12-06', 'Pendente', 0.00, 0.00, 210.00, 0.00),
(240, 27, 31, 6, '2015-11-08', 160.00, 0.00, 152.00, '1', NULL, 'Pago', 0.00, 0.00, 152.00, 0.00),
(241, 27, 31, 6, '2015-11-09', 60.00, 0.00, 57.00, '1', NULL, 'Pago', 0.00, 0.00, 57.00, 0.00),
(242, 27, 31, 9, '2015-11-10', 620.00, 0.00, 620.00, '2', '2015-12-08', 'Pago', 0.00, 0.00, 0.00, 0.00),
(243, 28, 31, 6, '2015-11-24', 70.00, 0.00, 66.50, '1', NULL, 'Pago', 0.00, 0.00, 66.50, 0.00),
(244, 27, 31, 6, '2015-11-24', 250.00, 0.00, 237.50, '1', NULL, 'Pago', 0.00, 0.00, 237.50, 0.00),
(245, 27, 32, 6, '2015-11-26', 20.00, 0.00, 19.00, '1', NULL, 'Pago', 0.00, 0.00, 19.00, 0.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acesso`
--
ALTER TABLE `acesso`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `bairro`
--
ALTER TABLE `bairro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_bairro_cidade1_idx` (`idCidade`);

--
-- Indexes for table `cidade`
--
ALTER TABLE `cidade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cliente_bairro1_idx` (`idBairro`);

--
-- Indexes for table `entradaprodutodetalhe`
--
ALTER TABLE `entradaprodutodetalhe`
  ADD PRIMARY KEY (`idEntradaRegistro`,`idProduto`),
  ADD KEY `FK_NFE_CAB_NFE_DET` (`idEntradaRegistro`),
  ADD KEY `FK_PRODUTO_NFE_DET` (`idProduto`);

--
-- Indexes for table `entradaprodutoregistro`
--
ALTER TABLE `entradaprodutoregistro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_FORNECEDOR_NFE_CAB` (`idFornecedor`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_fornecedor_tipoFornecedor1_idx` (`idTipoFornecedor`),
  ADD KEY `fk_fornecedor_bairro1_idx` (`idBairro`);

--
-- Indexes for table `funcao`
--
ALTER TABLE `funcao`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_DEPARTAMENTO_FUNCIONARIO` (`idFuncao`),
  ADD KEY `fk_funcionario_bairro1_idx` (`idBairro`);

--
-- Indexes for table `orcamentodetalhe`
--
ALTER TABLE `orcamentodetalhe`
  ADD PRIMARY KEY (`idOrcamentoRegistro`,`idProduto`),
  ADD KEY `FK_PRODUTO_ORC_DET` (`idProduto`);

--
-- Indexes for table `orcamentoregistro`
--
ALTER TABLE `orcamentoregistro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENTE_ORC_CAB` (`idCliente`),
  ADD KEY `FK_FUNCIONARIO_ORC_CAB` (`idFuncionario`);

--
-- Indexes for table `pagamentocliente`
--
ALTER TABLE `pagamentocliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENTE_RECEBIMENTO` (`idCliente`),
  ADD KEY `FK_TIPO_PGTO_RECEBIMENTO` (`idTipoPagamento`);

--
-- Indexes for table `pagamentoparafornecedor`
--
ALTER TABLE `pagamentoparafornecedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_FORNECEDOR_PAGAMENTO` (`idFornecedor`),
  ADD KEY `FK_TIPO_PGTO_PAGAMENTO` (`idTipoPagamento`);

--
-- Indexes for table `pedidodetalhe`
--
ALTER TABLE `pedidodetalhe`
  ADD PRIMARY KEY (`idPedidoRegistro`,`idProduto`),
  ADD KEY `fk_pedidodetalhe_produto1_idx` (`idProduto`);

--
-- Indexes for table `pedidoregistro`
--
ALTER TABLE `pedidoregistro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_FORNECEDOR_PEDIDO_CAB` (`idFornecedor`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_FORNECEDOR_PRODUTO` (`idFornecedor`),
  ADD KEY `FK_UNIDADE_PRODUTO` (`idUnidade`);

--
-- Indexes for table `tipofornecedor`
--
ALTER TABLE `tipofornecedor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipopagamento`
--
ALTER TABLE `tipopagamento`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `unidade`
--
ALTER TABLE `unidade`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vendadetalhe`
--
ALTER TABLE `vendadetalhe`
  ADD PRIMARY KEY (`idVendaRegistro`,`idProduto`),
  ADD KEY `FK_PRODUTO_VENDA_DET` (`idProduto`);

--
-- Indexes for table `vendaregistro`
--
ALTER TABLE `vendaregistro`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_CLIENTE_VENDA_CAB` (`idCliente`),
  ADD KEY `FK_FUNCIONARIO_VENDA_CAB` (`idFuncionario`),
  ADD KEY `FK_TIPO_PGTO_VENDA_CAB` (`idTipoPagamento`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `acesso`
--
ALTER TABLE `acesso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=43;
--
-- AUTO_INCREMENT for table `bairro`
--
ALTER TABLE `bairro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `cidade`
--
ALTER TABLE `cidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'codigo do cliente - auto-incremento',AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `entradaprodutoregistro`
--
ALTER TABLE `entradaprodutoregistro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=44;
--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `funcao`
--
ALTER TABLE `funcao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `orcamentoregistro`
--
ALTER TABLE `orcamentoregistro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `pagamentocliente`
--
ALTER TABLE `pagamentocliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pagamentoparafornecedor`
--
ALTER TABLE `pagamentoparafornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pedidoregistro`
--
ALTER TABLE `pedidoregistro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `tipofornecedor`
--
ALTER TABLE `tipofornecedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `tipopagamento`
--
ALTER TABLE `tipopagamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `unidade`
--
ALTER TABLE `unidade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `vendaregistro`
--
ALTER TABLE `vendaregistro`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=246;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `bairro`
--
ALTER TABLE `bairro`
  ADD CONSTRAINT `fk_bairro_cidade1` FOREIGN KEY (`idCidade`) REFERENCES `cidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `fk_cliente_bairro1` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `entradaprodutodetalhe`
--
ALTER TABLE `entradaprodutodetalhe`
  ADD CONSTRAINT `FK_NFE_CAB_NFE_DET` FOREIGN KEY (`idEntradaRegistro`) REFERENCES `entradaprodutoregistro` (`id`),
  ADD CONSTRAINT `FK_PRODUTO_NFE_DET` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`ID`);

--
-- Limitadores para a tabela `entradaprodutoregistro`
--
ALTER TABLE `entradaprodutoregistro`
  ADD CONSTRAINT `FK_FORNECEDOR_NFE_CAB` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`id`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `fk_fornecedor_bairro1` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_fornecedor_tipoFornecedor1` FOREIGN KEY (`idTipoFornecedor`) REFERENCES `tipofornecedor` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `FK_DEPARTAMENTO_FUNCIONARIO` FOREIGN KEY (`idFuncao`) REFERENCES `funcao` (`id`),
  ADD CONSTRAINT `fk_funcionario_bairro1` FOREIGN KEY (`idBairro`) REFERENCES `bairro` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `orcamentodetalhe`
--
ALTER TABLE `orcamentodetalhe`
  ADD CONSTRAINT `FK_ORC_CAB_ORC_DET` FOREIGN KEY (`idOrcamentoRegistro`) REFERENCES `orcamentoregistro` (`id`),
  ADD CONSTRAINT `FK_PRODUTO_ORC_DET` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`ID`);

--
-- Limitadores para a tabela `orcamentoregistro`
--
ALTER TABLE `orcamentoregistro`
  ADD CONSTRAINT `FK_CLIENTE_ORC_CAB` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK_FUNCIONARIO_ORC_CAB` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`);

--
-- Limitadores para a tabela `pagamentocliente`
--
ALTER TABLE `pagamentocliente`
  ADD CONSTRAINT `FK_CLIENTE_RECEBIMENTO` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK_TIPO_PGTO_RECEBIMENTO` FOREIGN KEY (`idTipoPagamento`) REFERENCES `tipopagamento` (`id`);

--
-- Limitadores para a tabela `pagamentoparafornecedor`
--
ALTER TABLE `pagamentoparafornecedor`
  ADD CONSTRAINT `FK_FORNECEDOR_PAGAMENTO` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`id`),
  ADD CONSTRAINT `FK_TIPO_PGTO_PAGAMENTO` FOREIGN KEY (`idTipoPagamento`) REFERENCES `tipopagamento` (`id`);

--
-- Limitadores para a tabela `pedidodetalhe`
--
ALTER TABLE `pedidodetalhe`
  ADD CONSTRAINT `FK_PEDIDO_CAB_PEDIDO_DET` FOREIGN KEY (`idPedidoRegistro`) REFERENCES `pedidoregistro` (`id`),
  ADD CONSTRAINT `fk_pedidodetalhe_produto1` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `pedidoregistro`
--
ALTER TABLE `pedidoregistro`
  ADD CONSTRAINT `FK_FORNECEDOR_PEDIDO_CAB` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`id`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK_FORNECEDOR_PRODUTO` FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`id`),
  ADD CONSTRAINT `FK_UNIDADE_PRODUTO` FOREIGN KEY (`idUnidade`) REFERENCES `unidade` (`id`);

--
-- Limitadores para a tabela `vendadetalhe`
--
ALTER TABLE `vendadetalhe`
  ADD CONSTRAINT `FK_PRODUTO_VENDA_DET` FOREIGN KEY (`idProduto`) REFERENCES `produto` (`ID`),
  ADD CONSTRAINT `FK_VENDA_CAB_VENDA_DET` FOREIGN KEY (`idVendaRegistro`) REFERENCES `vendaregistro` (`id`);

--
-- Limitadores para a tabela `vendaregistro`
--
ALTER TABLE `vendaregistro`
  ADD CONSTRAINT `FK_CLIENTE_VENDA_CAB` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`),
  ADD CONSTRAINT `FK_FUNCIONARIO_VENDA_CAB` FOREIGN KEY (`idFuncionario`) REFERENCES `funcionario` (`id`),
  ADD CONSTRAINT `FK_TIPO_PGTO_VENDA_CAB` FOREIGN KEY (`idTipoPagamento`) REFERENCES `tipopagamento` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
