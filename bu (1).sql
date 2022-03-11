-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 11 mars 2022 à 13:41
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bu`
--

-- --------------------------------------------------------

--
-- Structure de la table `livres`
--

CREATE TABLE `livres` (
  `Code` int(11) NOT NULL,
  `Titre` varchar(50) NOT NULL,
  `Auteur` varchar(50) NOT NULL,
  `DatePublication` varchar(20) NOT NULL,
  `NombrePage` int(11) NOT NULL,
  `NombreExemplaire` int(11) NOT NULL,
  `Etat` varchar(10) NOT NULL,
  `Emplacement` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `livres`
--

INSERT INTO `livres` (`Code`, `Titre`, `Auteur`, `DatePublication`, `NombrePage`, `NombreExemplaire`, `Etat`, `Emplacement`) VALUES
(1, 'LE matin', 'Moussa', '12-10-2020', 200, 20, 'L', 'C23');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `Code` int(11) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Nom` varchar(15) NOT NULL,
  `Telephone` varchar(12) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Adresse` varchar(20) NOT NULL,
  `Profession` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`Code`, `Prenom`, `Nom`, `Telephone`, `Email`, `Adresse`, `Profession`, `login`, `password`) VALUES
(1, 'mamadou', 'sow', '784014559', 'msow@gmail.com', 'Barkédji', 'Etudiant', 'mama', 'sow'),
(2, 'Lobé', 'niang', '780909778', 'lniang@gmail.com', 'louga', 'Etudiant', 'lobe', 'niang');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `livres`
--
ALTER TABLE `livres`
  ADD PRIMARY KEY (`Code`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `livres`
--
ALTER TABLE `livres`
  MODIFY `Code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `Code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
