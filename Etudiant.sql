-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Ven 05 Juin 2015 à 18:13
-- Version du serveur :  5.5.38
-- Version de PHP :  5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Etudiant`
--

-- --------------------------------------------------------

--
-- Structure de la table `baccalaureat`
--

CREATE TABLE `baccalaureat` (
  `n_inscription` int(20) NOT NULL,
  `type_bac` varchar(50) NOT NULL,
  `serie_bac` varchar(50) NOT NULL,
  `mention_bac` varchar(50) NOT NULL,
  `moy_ER` varchar(50) NOT NULL,
  `moy_EN` varchar(50) NOT NULL,
  `math_EN` varchar(50) NOT NULL,
  `phys_EN` varchar(50) NOT NULL,
  `nat_EN` varchar(50) NOT NULL,
  `lycee` varchar(50) NOT NULL,
  `academie` varchar(50) NOT NULL,
  `province` varchar(50) NOT NULL,
  `filiere` varchar(50) NOT NULL,
  `date_inscription` varchar(100) NOT NULL,
  `valide` int(20) NOT NULL DEFAULT '0',
  `supprime` int(20) NOT NULL DEFAULT '0',
  `motif` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `baccalaureat`
--

INSERT INTO `baccalaureat` (`n_inscription`, `type_bac`, `serie_bac`, `mention_bac`, `moy_ER`, `moy_EN`, `math_EN`, `phys_EN`, `nat_EN`, `lycee`, `academie`, `province`, `filiere`, `date_inscription`, `valide`, `supprime`, `motif`) VALUES
(0, 'sadasd', 'asdasd', 'dsadsad', 'sadasd', 'dasasd', 'sdsad', '123', 'adsdas', 'sdasd', 'sdasd', 'dsfsd', 'xzzxcxzczxc', '2015-06-10 05:36:10', 0, 0, NULL),
(17, 'math', 'math', 'dsfsdf', '123', '123', '123', '123', '123', 'sdfsd', 'dfdsfs', 'dsfsd', 'admin', '0000-00-00 00:00:00', 1, 1, NULL),
(18, 'sadasd', 'asdasd', 'sdasd', 'asdas', 'dasasd', 'sdsad', 'asdasd', 'adsdas', 'asdasd', 'dasdas', 'sadsad', 'asdasd', '0000-00-00 00:00:00', 0, 1, NULL),
(23, 'dsadasd', 'sdaas', 'dsadsad', 'sadasd', 'asdsd', 'sadasd', 'sadasd', 'asdsad', 'sdasd', 'sdasd', 'dsdasd', 'asdasd', '0000-00-00 00:00:00', 0, 0, NULL),
(24, 'sdsa', 'sdasd', 'asdasd', 'sdasd', 'sadasd', 'adsadasd', 'sdasd', 'sadsd', 'sdad', 'sdasd', 'sadasd', 'asdasd', '0000-00-00 00:00:00', 0, 0, NULL),
(25, 'math', 'math', 'dsfsdf', '123', '123', '123', '123', '123', 'sdfsd', 'dfdsfs', 'dsfsd', 'xzzxcxzczxc', '0000-00-00 00:00:00', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `personnelle`
--

CREATE TABLE `personnelle` (
`n_inscription` int(20) NOT NULL,
  `cne` varchar(20) CHARACTER SET latin1 NOT NULL,
  `nom` varchar(50) CHARACTER SET latin1 NOT NULL,
  `prenom` varchar(50) CHARACTER SET latin1 NOT NULL,
  `date_naissance` varchar(50) CHARACTER SET latin1 NOT NULL,
  `ville_naissance` varchar(50) CHARACTER SET latin1 NOT NULL,
  `pays_naissance` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nationalite` varchar(50) CHARACTER SET latin1 NOT NULL,
  `sexe` varchar(50) CHARACTER SET latin1 NOT NULL,
  `cin` varchar(50) CHARACTER SET latin1 NOT NULL,
  `datecin` varchar(50) CHARACTER SET latin1 NOT NULL,
  `adresse` varchar(500) CHARACTER SET latin1 NOT NULL,
  `ville` varchar(50) CHARACTER SET latin1 NOT NULL,
  `pays` varchar(50) CHARACTER SET latin1 NOT NULL,
  `tel` varchar(50) CHARACTER SET latin1 NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 NOT NULL,
  `photo` varchar(100) CHARACTER SET latin1 NOT NULL,
  `handicap` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nature_handicap` varchar(500) CHARACTER SET latin1 NOT NULL,
  `num_carte_handicap` varchar(50) CHARACTER SET latin1 NOT NULL,
  `bourse` varchar(50) CHARACTER SET latin1 NOT NULL,
  `activite` varchar(50) CHARACTER SET latin1 NOT NULL,
  `etablissement` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnelle`
--

INSERT INTO `personnelle` (`n_inscription`, `cne`, `nom`, `prenom`, `date_naissance`, `ville_naissance`, `pays_naissance`, `nationalite`, `sexe`, `cin`, `datecin`, `adresse`, `ville`, `pays`, `tel`, `email`, `photo`, `handicap`, `nature_handicap`, `num_carte_handicap`, `bourse`, `activite`, `etablissement`) VALUES
(17, '5555', 'aaaaa', 'bbbbb', '2015-04-29', 'asdasd', 'sdfsd', 'sadasdas', 'masculin', 'ds213123123', '2015-05-06', 'xzcxzcxzc', 'sdfsdf', 'asdasd', '1234', 'ensak@gmail.com', 'dsfsff', '1', 'sadasd', 'sadasd', 'dsfsd', 'asdasa', ''),
(18, '12345', 'asssd', 'sadasd', '2015-05-13', 'sadasd', 'sadas', 'dasas', 'masculin', 'sadas', '2015-05-12', 'asdsada', 'ASDASd', 'dasdas', 'asdsa', 'dsada', 'sadas', '1', 'dsada', 'asdasd', 'sadas', 'asdas', ''),
(19, '11117777', 'zXz', 'ZXZ', '2015-05-06', 'sdasd', 'asdasd', 'sadasdas', 'masculin', 'ssdvcvc', '2015-05-14', 'dfdsfs', 'ASDASd', 'sdfsdf', '12345', 'ensak@gmail.com', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web', '1', 'sadasd', 'asdsad', 'sdasd', 'sadas', ''),
(20, '111112222', 'saDS', 'SDASD', '2015-05-28', 'ADASD', 'sdad', 'sadasd', 'masculin', 'sadasd', '2015-04-30', 'sadasads', 'asdsada', 'dasdas', '1234', 'asdasd', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/webdb_fc.sql', '1', 'asdas', 'sadasd', 'asdas', 'asdasd', ''),
(21, '111dd222', 'dsfsdf', 'dsfds', '2015-05-14', 'dsfds', 'fdsfds', 'dsfsdf', 'masculin', 'sdfsd', '2015-05-20', 'fsdfds', 'sdfsdf', 'dsfsdf', 'fsdfsd', 'sfsdf', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/numérisation0013 (2).jpg', '1', 'fdsf', 'dsfsd', 'sdfsdf', 'sdfsd', ''),
(22, '114455666', 'dfsdf', 'sdfds', '2015-04-28', 'dsfsdf', 'fsdfsdf', 'dfsdf', 'masculin', 'dsfdsf', '2015-05-12', 'fsdfsd', 'dsfdsf', 'sdfsdf', 'dsfsdf', 'dsfsdf', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/INSURANCE2.jpg', '1', 'sdsad', 'asdasd', 'asdas', 'sadasd', ''),
(23, '123456', 'asdas', 'sdasd', '2015-05-05', 'dasdsad', 'sdasd', 'sadasd', 'masculin', 'sdfg', '2015-05-20', 'dsasdasd', 'sadsad', 'dasdsad', 'sadasd', 'sdaasd', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/6086-01.jpg', '1', 'sadas', 'dsasdas', 'sadad', 'sadad', ''),
(24, '11109', 'dsadas', 'sadsad', '2015-05-13', 'sdasds', 'asdasd', 'asdasasd', 'masculin', 'sadsad', '2015-05-06', 'sadsads', 'sdasdas', 'sadasda', '0122333', 'sdadsd', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/University_UHI_logo.jpg', '1', 'asdasd', 'asdasd', 'sadasd', 'sadasdas', ''),
(25, '1212121212', 'Agouzal', 'Mehdi', '2015-05-06', 'sdasd', 'sdfsd', 'sadasd', 'masculin', 'sadasd', '2015-04-30', 'asfsdf', 'sdfsdf', 'asdasd', '1234', 'ensak@gmail.com', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/uh1logo.png', '1', 'asdasd', 'asdasd', 'asdasd', 'sadasd', 'Faculte des sciences juridiques economiques et sociales'),
(26, '1212121212', 'Ø§Ø¹Ø²Ø§Ø¨Ù?', 'Ù?Ø¬Ù?Ù?', '2015-05-01', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'masculin', 'bl108715', '2015-05-19', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', '12345', 'ensak.formations@gmail.com', '/Users/macbookpro/NetBeansProjects/PreInsciption/build/web/uh1logo.png', '1', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', '234', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ø¯Ú¢Ù?Ù?Ú¢Ù?Ú¢Ù?', 'Ecole nationale de commerce et de gestion');

-- --------------------------------------------------------

--
-- Structure de la table `tuteur`
--

CREATE TABLE `tuteur` (
  `n_inscription` int(20) NOT NULL,
  `nom_pere` varchar(50) NOT NULL,
  `prenom_pere` varchar(50) NOT NULL,
  `profession_pere` varchar(50) NOT NULL,
  `nom_mere` varchar(50) NOT NULL,
  `prenom_mere` varchar(50) NOT NULL,
  `profession_mere` varchar(50) NOT NULL,
  `nom_tuteur` varchar(50) NOT NULL,
  `prenom_tuteur` varchar(50) NOT NULL,
  `profession_tuteur` varchar(50) NOT NULL,
  `adresse_tuteur` varchar(50) NOT NULL,
  `tel_tuteur` varchar(50) NOT NULL,
  `mail_tuteur` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tuteur`
--

INSERT INTO `tuteur` (`n_inscription`, `nom_pere`, `prenom_pere`, `profession_pere`, `nom_mere`, `prenom_mere`, `profession_mere`, `nom_tuteur`, `prenom_tuteur`, `profession_tuteur`, `adresse_tuteur`, `tel_tuteur`, `mail_tuteur`) VALUES
(0, 'ninnkn', 'jonninj', 'oo', 'kanit', 'dsadas', 'sadas', 'sadsa', 'sain', 'xzczx', 'sadasd', 'zxczxc', 'sadasd'),
(17, 'agouzal', 'smain', 'retraite', 'kanit', 'aicha', 'retraite', 'agouzal', 'sain', 'retaite', 'lalla yacout', '123456', 'cxc2@gg.com'),
(18, 'sadsad', 'sadas', 'sadasd', 'sdasda', 'asdsa', 'asdsad', 'dasdas', 'dsadasd', 'asdasd', 'sadasd', 'sadsad', 'asdasd'),
(23, 'asdsad', 'sadas', 'asdasd', 'sadad', 'dsadas', 'sadas', 'sadsa', 'sdasda', 'asddasd', 'sdaasd', 'sadasd', 'sadasd'),
(24, 'sadads', 'adad', 'sdad', 'sadad', 'sdadsa', 'sadasd', 'sdasada', 'sdasda', 'sdas', 'sdas', 'dfdsff', 'fsdfsdfsdf'),
(25, 'sadsad', 'sadas', 'sadasd', 'sadad', 'xzczxc', 'sadas', 'agouzal', 'sain', 'retaite', 'sadasd', 'zxczxc', 'cxc2@gg.com');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `baccalaureat`
--
ALTER TABLE `baccalaureat`
 ADD PRIMARY KEY (`n_inscription`);

--
-- Index pour la table `personnelle`
--
ALTER TABLE `personnelle`
 ADD PRIMARY KEY (`n_inscription`);

--
-- Index pour la table `tuteur`
--
ALTER TABLE `tuteur`
 ADD PRIMARY KEY (`n_inscription`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `personnelle`
--
ALTER TABLE `personnelle`
MODIFY `n_inscription` int(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=27;