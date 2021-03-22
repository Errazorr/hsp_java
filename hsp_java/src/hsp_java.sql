-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 22 mars 2021 à 20:29
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hsp_java`
--
CREATE DATABASE IF NOT EXISTS `hsp_java` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `hsp_java`;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_medicament` varchar(50) NOT NULL,
  `fabricant` varchar(50) NOT NULL,
  `qte` int(11) NOT NULL,
  `date` date NOT NULL,
  `prix` decimal(10,0) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_fabricant` (`fabricant`),
  KEY `nom_medicament` (`nom_medicament`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `mdp` varchar(32) NOT NULL,
  `acces_rdv` tinyint(1) NOT NULL,
  `acces_stock` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`id`, `nom`, `prenom`, `mail`, `mdp`, `acces_rdv`, `acces_stock`) VALUES
(1, 'test', 'test', 'test@test.fr', 'test', 1, 1),
(2, 'stock', 'stock', 'acces@stock.fr', 'stock', 0, 1),
(3, 'rdv', 'rdv', 'acces@rdv.fr', 'rdv', 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `specialite` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_medecin` (`nom`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `medecin`
--

INSERT INTO `medecin` (`id`, `nom`, `prenom`, `specialite`) VALUES
(1, 'Guo', 'Loic', 'Tabacologie'),
(2, 'Kebiche', 'Killian', 'Neurologue'),
(3, 't', 't', 't'),
(4, 'ah', 'ah', 'ah'),
(5, 'Fontaine', 'Ryan', 'Bg'),
(6, 'Trafalgar', 'Law', 'Chirurgien');

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `mail` varchar(50) NOT NULL,
  `tel` varchar(10) NOT NULL,
  `mutuelle` varchar(50) NOT NULL,
  `secu` int(15) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_patient` (`nom`) USING BTREE,
  KEY `prenom_patient` (`prenom`) USING BTREE,
  KEY `mail_patient` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id`, `nom`, `prenom`, `mail`, `tel`, `mutuelle`, `secu`) VALUES
(1, 'Shaco', 'Shaco', 'Shaco', '789789', 'Shaco', 789789789);

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

DROP TABLE IF EXISTS `rdv`;
CREATE TABLE IF NOT EXISTS `rdv` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom_patient` varchar(30) NOT NULL,
  `prenom_patient` varchar(30) NOT NULL,
  `mail_patient` varchar(50) NOT NULL,
  `nom_medecin` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_patient` (`nom_patient`),
  KEY `prenom_patient` (`prenom_patient`),
  KEY `nom_medecin` (`nom_medecin`),
  KEY `mail_patient` (`mail_patient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`id`, `nom_patient`, `prenom_patient`, `mail_patient`, `nom_medecin`, `date`, `heure`) VALUES
(1, 'Shaco', 'Shaco', 'Shaco', 'Guo', '2021-02-10', '15:48:19'),
(2, 'Shaco', 'Shaco', 'Shaco', 'Kebiche', '2021-02-01', '05:02:14');

-- --------------------------------------------------------

--
-- Structure de la table `stock`
--

DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `fabricant` varchar(50) NOT NULL,
  `qte` int(11) NOT NULL,
  `danger` text NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nom_medicament` (`nom`),
  KEY `fabriquant` (`fabricant`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `stock`
--

INSERT INTO `stock` (`id`, `nom`, `fabricant`, `qte`, `danger`) VALUES
(5, 'Loicium', 'M. Guo', 3000, 'Saccisme très important'),
(6, 'Doliprane', 'Robert Schuman', 20, 'Danger 2');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `nom_fabricant` FOREIGN KEY (`fabricant`) REFERENCES `stock` (`fabricant`),
  ADD CONSTRAINT `nom_medicament` FOREIGN KEY (`nom_medicament`) REFERENCES `stock` (`nom`);

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `mail_patient` FOREIGN KEY (`mail_patient`) REFERENCES `patient` (`mail`),
  ADD CONSTRAINT `nom_medecin` FOREIGN KEY (`nom_medecin`) REFERENCES `medecin` (`nom`),
  ADD CONSTRAINT `nom_patient` FOREIGN KEY (`nom_patient`) REFERENCES `patient` (`nom`),
  ADD CONSTRAINT `prenom_patient` FOREIGN KEY (`prenom_patient`) REFERENCES `patient` (`prenom`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
