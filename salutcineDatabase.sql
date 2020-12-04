-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  mer. 02 déc. 2020 à 21:42
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

create database if not exists salutcine;
use salutcine;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `salutcine`


-- --------------------------------------------------------

--
-- Structure de la table `cinema`
--

DROP TABLE IF EXISTS `cinema`;
CREATE TABLE IF NOT EXISTS `cinema` (
  `IdCinema` int(11) NOT NULL AUTO_INCREMENT,
  `Ville` varchar(50) NOT NULL,
  `H_Ouverture` time NOT NULL,
  `H_Fermeture` time NOT NULL,
  PRIMARY KEY (`IdCinema`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `cinema`
--

INSERT INTO `cinema` (`IdCinema`, `Ville`, `H_Ouverture`, `H_Fermeture`) VALUES
(1, 'Serris', '08:00:00', '23:30:00'),
(2, 'Villejuif', '07:30:00', '00:00:00'),
(3, 'Toulouse', '09:00:00', '22:30:00'),
(4, 'Marseille', '07:15:00', '23:45:00');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `IdFilm` int(11) NOT NULL AUTO_INCREMENT,
  `Titre` varchar(50) NOT NULL,
  `Durée` time NOT NULL,
  `Langue` varchar(50) NOT NULL,
  `SousTitre` varchar(50) DEFAULT NULL,
  `Realisateur` varchar(50) NOT NULL,
  `Acteur1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Acteur2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Acteur3` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `MinAge` int(11) NOT NULL,
  PRIMARY KEY (`IdFilm`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`IdFilm`, `Titre`, `Durée`, `Langue`, `SousTitre`, `Realisateur`, `Acteur1`, `Acteur2`, `Acteur3`, `MinAge`) VALUES
(1, 'Avengers: Endgame', '03:01:00', 'Anglais', 'Francais', 'Anthony John Russo', 'Robert Downey Jr', 'Chris Evans', 'Scarlett Johansson', 10),
(2, 'Titanic', '03:14:00', 'francais', NULL, 'James Cameron', ' Leonardo DiCaprio', 'Kate Winslet', 'Billy Zane', 0),
(3, 'Mulan', '01:55:00', 'francais', NULL, 'Niki Caro', 'Liu Yifei', 'Yoson An', NULL, 0),
(4, 'Forrest Gump', '02:20:00', 'anglais', 'Francais', 'Robert Zemeckis', 'Tom Hanks', 'Gary Sinise', 'Robin Wright', 0),
(5, 'Anabelle', '01:38:00', 'anglais', 'Francais', 'John R. Leonetti', 'Annabelle Wallis', 'Ward Horton', 'Alfre Woodard', 12),
(6, 'Interstellar', '02:49:00', 'anglais', NULL, 'Christopher Nolan', 'Matthew McConaughey', 'Anne Hathaway', 'Michael Caine', 10);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `IdSeance` int(11) NOT NULL AUTO_INCREMENT,
  `IdCinema` int(11) NOT NULL,
  `IdFilm` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure` time NOT NULL,
  `Salle` int(11) NOT NULL,
  PRIMARY KEY (`IdSeance`),
  KEY `IdCinema` (`IdCinema`),
  KEY `IdFilm` (`IdFilm`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`IdSeance`, `IdCinema`, `IdFilm`, `Date`, `Heure`, `Salle`) VALUES
(1, 1, 2, '2020-12-15', '15:15:00', 11),
(2, 1, 3, '2020-12-18', '09:45:00', 5),
(3, 2, 5, '2020-12-12', '11:45:00', 4),
(4, 3, 6, '2020-12-22', '13:00:00', 8),
(5, 3, 2, '2020-12-13', '14:00:00', 2),
(6, 4, 3, '2020-12-07', '14:30:00', 10),
(7, 4, 5, '2020-12-19', '10:30:00', 6);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `IdUser` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(50) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  PRIMARY KEY (`IdUser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
