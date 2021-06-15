-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 14-Jun-2021 às 21:55
-- Versão do servidor: 8.0.25-0ubuntu0.20.04.1
-- versão do PHP: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `oscarrinho`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cor`
--

CREATE TABLE `cor` (
  `id` int NOT NULL,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `cor`
--

INSERT INTO `cor` (`id`, `nome`, `status`) VALUES
(1, 'Branco', 1),
(2, 'Prata', 1),
(3, 'Preto', 1),
(4, 'Cinza', 1),
(5, 'Vermelho', 1),
(6, 'Bege', 1),
(7, 'Azul', 1),
(8, 'Amarelo', 1),
(9, 'Verde', 1),
(10, 'Laranja', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `id` int NOT NULL,
  `nome` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`id`, `nome`, `status`) VALUES
(1, 'Audi', 1),
(2, 'Bmw', 1),
(3, 'Citroen', 1),
(4, 'Ferrari', 1),
(5, 'Fiat', 1),
(6, 'Ford', 1),
(7, 'Honda', 1),
(8, 'Hyundai', 1),
(9, 'Jeep', 1),
(10, 'Lamborghini', 1),
(11, 'Land Rover', 1),
(12, 'Mitsubishi', 1),
(13, 'Nissan', 1),
(14, 'Peugeot', 1),
(15, 'Porche', 1),
(16, 'Renault', 1),
(17, 'Toyota', 1),
(18, 'Volkswagen', 1),
(19, 'Chevrolet', 1),
(23, 'Tesla', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int NOT NULL,
  `nome` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `login` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `senha` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `login`, `senha`, `status`) VALUES
(1, 'administrador', 'admin', '$2a$10$adFg3jAZL/VcqFqw8FA7/eyWbnf9r5yabt/2gb.ZpewrMCV8SPs3C', 1),
(7, 'test', 'teste', '$2a$10$6nn.YMGQ5aAV0GxxfqBKMuoyx0MqGHAF.2Y4Y2AJVwNH7oRAy7KZq', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculo`
--

CREATE TABLE `veiculo` (
  `id` int NOT NULL,
  `modelo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `anomodelo` year NOT NULL,
  `anofabricacao` year NOT NULL,
  `valor` double NOT NULL,
  `tipo` enum('cupe','crossover','esportivo','hatch','jipe','picape','sedan','suv','van') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fotoDestaque` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `marca_id` int NOT NULL,
  `cor_id` int NOT NULL,
  `usuario_id` int NOT NULL,
  `opcionais` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Extraindo dados da tabela `veiculo`
--

INSERT INTO `veiculo` (`id`, `modelo`, `anomodelo`, `anofabricacao`, `valor`, `tipo`, `fotoDestaque`, `marca_id`, `cor_id`, `usuario_id`, `opcionais`) VALUES
(1, 'A3', 2022, 2021, 264990, 'hatch', 'audiA3-2022.jpeg', 1, 5, 1, 'Múltimídia.Ar-Condicionado.Piloto automático.Volante com regulagem de altura.Bancos de couro.Vidro elétrico.Teto Solar.Computador de bordo'),
(5, 'R8', 2021, 2021, 1310900, 'cupe', 'audiR8-2021.jpg', 1, 7, 1, 'Alarme.Piloto Automático. Ar-Condicionado.Vidros Elétricos.Multimídia'),
(6, 'A3', 2016, 2015, 82900, 'sedan', 'audiA3-2016.jpg', 1, 7, 1, 'Airbag.Alarme.Ar quente.Computador de bordo.Ar-Condicionado.Feio ABS.Vidros elétricos.Direção Hidráulica'),
(7, '320i', 2020, 2019, 224900, 'sedan', 'bmw320i-2020.jpg', 2, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de chuva.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro.\r\nDireção hidráulica.\r\nGPS.'),
(8, '235i', 2021, 2020, 339900, 'sedan', 'bmw235i.jpg', 2, 4, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de chuva.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro.\r\nDireção hidráulica.\r\nGPS.'),
(9, 'Celta', 2015, 2015, 27900, 'hatch', 'Chevcelta-2015.jpg', 19, 3, 1, 'Airbag.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nTravas elétricas.\r\nVidros elétricos.\r\nDireção hidráulica'),
(10, 'Cruze', 2018, 2017, 91900, 'sedan', 'chevCruze-2018.jpg', 19, 1, 1, 'Airbag.\r\nAlarme.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nRetrovisor fotocrômico.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro'),
(11, 'S10', 2019, 2018, 136900, 'picape', 'chevS10-2019.jpg', 19, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nVidros elétricos'),
(12, 'Onix', 2019, 2019, 54900, 'hatch', 'chevOnix-2019.jpg', 19, 2, 1, 'Alarme\r\nAr quente\r\nComputador de bordo\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica'),
(13, 'Montana', 2019, 2018, 53900, 'picape', 'chevMontana-2019.jpg', 19, 1, 1, 'Airbag.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nAr condicionado.\r\nFreio ABS.\r\nProtetor de caçamba.\r\nCapota marítima.'),
(14, 'C4', 2013, 2012, 20000, 'hatch', 'citroenC4-2013.jpg', 3, 2, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nCD Player.\r\nComputador de bordo.\r\nControle de tração.\r\nAr condicionado.\r\nControle automático de velocidade'),
(15, 'Strada', 2016, 2015, 58900, 'picape', 'fiatStrada-2015.jpg', 5, 1, 1, 'Ar quente.\r\nCD Player.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nRodas de liga leve.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica.\r\n'),
(16, 'Mobi', 2018, 2018, 43900, 'hatch', 'fiatMobi2018.jpg', 5, 2, 1, 'Alarme.\r\nAr quente.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nRádio.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica'),
(17, 'Fiorino', 2021, 2020, 78900, 'van', 'fiatFIorino-2020.jpg', 5, 1, 1, 'Airbag.\r\nComputador de bordo.\r\nAr condicionado.\r\nFreio ABS.\r\nTravas elétricas.\r\nVidros elétricos.\r\nDireção hidráulica'),
(18, 'Palio', 2014, 2014, 22900, 'hatch', 'fiatPalio-2013.jpg', 5, 3, 1, 'Não possui'),
(19, 'Ka', 2019, 2019, 46900, 'hatch', 'fordKa-2019.jpg', 6, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nLimpador traseiro.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica.\r\nCD e MP3 Player'),
(20, 'Fiesta', 2014, 2013, 42900, 'hatch', 'fordFiesta-2014.jpg', 6, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nRetrovisores elétricos.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura'),
(21, 'Civic', 2014, 2013, 64900, 'sedan', 'hondaCivic-2014.jpg', 7, 4, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nRádio.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro.\r\nDireção hidráulica\r\n'),
(22, 'City', 2019, 2019, 79900, 'sedan', 'hondaCity-2019.jpg', 7, 1, 1, 'Airbag.\r\nAr quente.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento\r\nTravas elétricas.\r\nVidros elétricos'),
(23, 'HB20', 2020, 2020, 52900, 'hatch', 'hyunHb20-2020.jpg', 8, 1, 1, 'Airbag.\r\nAr quente.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nTravas elétricas.\r\nVidros elétricos.\r\nDireção hidráulica.\r\nGPS.'),
(24, 'Evoque', 2014, 2014, 127900, 'suv', 'landEvoque-2014.jpg', 11, 3, 1, 'Blindado'),
(25, 'Discovery', 2017, 2017, 367800, 'suv', 'landDiscovery-2017.jpg', 11, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBancos dianteiros com aquecimento.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nControle automático de velocidade\r\nRádio\r\nRetrovisores elétricos\r\nRodas de liga leve\r\nSensor de estacionamento\r\nTeto solar\r\nRetrovisor fotocrômico\r\nTravas elétricas\r\nVidros elétricos\r\nVolante com regulagem de altura\r\nBancos em couro\r\nTração 4x4\r\nGPS'),
(26, 'Pajero TR4', 2015, 2014, 59900, 'suv', 'mitPajero-2014.jpg', 12, 1, 1, 'Airbag\r\nAlarme\r\nControle de tração.\r\nDesembaçador traseiro\r\nFreio ABS.\r\nTravas elétricas\r\n'),
(27, 'Frontier', 2012, 2011, 84900, 'picape', 'nissanFrontier-2012.jpg', 13, 3, 1, 'Airbag.\r\nAr quente\r\nBanco com regulagem de altura.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nProtetor de caçamba.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nCapota marítima.\r\nBancos em couro.\r\nTração 4x4.\r\nDireção hidráulica'),
(28, 'March', 2016, 2015, 35900, 'hatch', 'nissanMarch-2015.jpg', 13, 7, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRodas de liga leve.\r\nTravas elétricas.\r\nVidros elétricos\r\nDireção hidráulica'),
(29, '208', 2020, 2019, 52900, 'hatch', 'pe208-2019.jpg', 14, 3, 1, 'Alarme.\r\nAr quente.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nRádio.\r\nRodas de liga leve.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica'),
(30, '307', 2007, 2007, 20900, 'hatch', 'peu307-2007.jpg', 14, 2, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nCD Player.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de chuva.\r\nRetrovisor fotocrômico.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro.\r\nDireção hidráulica.\r\nDVD Player'),
(31, 'Logan', 2017, 2016, 38900, 'sedan', 'renaultLogan-2017.jpg', 16, 2, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nCD Player.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de chuva.\r\nRetrovisor fotocrômico.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nBancos em couro.\r\nDireção hidráulica.\r\nDVD Player'),
(32, 'Sandero', 2019, 2018, 45900, 'hatch', 'renSandero-2019.jpg', 16, 1, 1, 'Airbag.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nLimpador traseiro.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nVolante com regulagem de altura\r\nDireção hidráulica'),
(33, 'Duster', 2014, 2013, 44900, 'suv', 'renDuster-2014.jpg', 16, 2, 1, 'Airbag.\r\nAlarme.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nTravas elétricas.\r\nVidros elétricos.\r\nDireção hidráulica'),
(34, 'Corolla', 2011, 2010, 52900, 'sedan', 'toyoCorolla-2012.jpg', 17, 3, 1, 'Ar quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nTravas elétricas.\r\nVidros elétricos.\r\nBancos em couro.\r\nDireção hidráulica'),
(35, 'Hilux SW4', 2011, 2011, 139990, 'suv', 'toyoHilux-2011.jpg', 17, 1, 1, 'Alarme.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nVidros elétricos.\r\nBancos em couro.\r\nTração 4x4.\r\nDireção hidráulica'),
(36, 'Etios', 2020, 2019, 63900, 'hatch', 'toyoEtios-2019.jpg', 17, 4, 1, 'Airbag.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nFreio ABS.\r\nRodas de liga leve.\r\nTravas elétricas.\r\nVidros elétricos.\r\nBancos em couro'),
(37, 'Amarok', 2020, 2019, 219900, 'picape', 'volksAmarol-2019.jpg', 18, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nControle de tração.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nControle automático de velocidade.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nRetrovisor fotocrômico.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nCapota marítima.\r\nBancos em couro.\r\nTração 4x4.'),
(38, 'Golf', 2016, 2015, 65900, 'hatch', 'volksGolf-2016.jpg', 18, 3, 1, 'Airbag.\r\nAr quente.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nLimpador traseiro.\r\nRádio.\r\nRetrovisores elétricos.\r\nRodas de liga leve.\r\nSensor de estacionamento.\r\nTravas elétricas.\r\nDireção hidráulica'),
(39, 'Gol', 2021, 2020, 77900, 'hatch', 'volksGol-2022.jpg', 18, 1, 1, 'Airbag.\r\nBanco com regulagem de altura.\r\nComputador de bordo.\r\nEncosto de cabeça traseiro.\r\nFreio ABS\r\nRodas de liga leve\r\nVolante com regulagem de altura'),
(40, 'Fox', 2012, 2011, 31900, 'hatch', 'volksFox-2014.jpg', 18, 1, 1, 'Airbag.\r\nAlarme.\r\nAr quente.\r\nCD Player.\r\nDesembaçador traseiro.\r\nAr condicionado.\r\nEncosto de cabeça traseiro.\r\nFreio ABS.\r\nLimpador traseiro.\r\nTravas elétricas.\r\nVidros elétricos.\r\nVolante com regulagem de altura.\r\nDireção hidráulica'),
(79, 'Golf', 2020, 2019, 199990, 'hatch', 'golf2019.jpg', 18, 1, 1, 'Completo');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cor`
--
ALTER TABLE `cor`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `marca_id` (`marca_id`) USING BTREE,
  ADD KEY `usuario_id` (`usuario_id`) USING BTREE,
  ADD KEY `cor_id` (`cor_id`) USING BTREE;

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cor`
--
ALTER TABLE `cor`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de tabela `marca`
--
ALTER TABLE `marca`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `veiculo`
--
ALTER TABLE `veiculo`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=80;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `veiculo`
--
ALTER TABLE `veiculo`
  ADD CONSTRAINT `veiculo_ibfk_2` FOREIGN KEY (`cor_id`) REFERENCES `cor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `veiculo_ibfk_3` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `veiculo_ibfk_4` FOREIGN KEY (`marca_id`) REFERENCES `marca` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
