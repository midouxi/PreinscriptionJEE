-- phpMyAdmin SQL Dump
-- version 4.2.10
-- http://www.phpmyadmin.net
--
-- Client :  localhost:3306
-- Généré le :  Ven 05 Juin 2015 à 18:11
-- Version du serveur :  5.5.38
-- Version de PHP :  5.6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Admin`
--

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

CREATE TABLE `inscription` (
  `n_inscription` int(20) NOT NULL,
  `cne` int(20) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `date_naissance` varchar(50) NOT NULL,
  `ville_naissance` varchar(50) NOT NULL,
  `pays_naissance` varchar(50) NOT NULL,
  `nationalite` varchar(50) NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `cin` varchar(50) NOT NULL,
  `datecin` varchar(50) NOT NULL,
  `adresse` varchar(500) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `pays` varchar(50) NOT NULL,
  `tel` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `photo` varchar(100) NOT NULL,
  `handicap` varchar(50) NOT NULL,
  `nature_handicap` varchar(500) NOT NULL,
  `num_carte_handicap` varchar(50) NOT NULL,
  `bourse` varchar(50) NOT NULL,
  `activite` varchar(50) NOT NULL,
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
