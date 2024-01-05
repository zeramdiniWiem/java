-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 05 jan. 2024 à 12:46
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `4gl_tp1`
--

-- --------------------------------------------------------

--
-- Structure de la table `aeroport`
--

CREATE TABLE `aeroport` (
  `id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `pays` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `aeroport`
--

INSERT INTO `aeroport` (`id`, `nom`, `pays`) VALUES
(1, 'paris', 'france'),
(828, 'Carthage', 'Tunisia');

-- --------------------------------------------------------

--
-- Structure de la table `escales`
--

CREATE TABLE `escales` (
  `id` int(11) NOT NULL,
  `heure_dep` int(10) NOT NULL,
  `heure_arr` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `escales`
--

INSERT INTO `escales` (`id`, `heure_dep`, `heure_arr`) VALUES
(269, 10, 20),
(733, 100, 200);

-- --------------------------------------------------------

--
-- Structure de la table `escale_vols`
--

CREATE TABLE `escale_vols` (
  `id` int(11) NOT NULL,
  `vol` int(11) NOT NULL,
  `escale` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `login` varchar(11) NOT NULL,
  `password` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `login`, `password`) VALUES
(2, 'GL4', 'GL41023'),
(4, 'GL4', 'GL41023');

-- --------------------------------------------------------

--
-- Structure de la table `vols`
--

CREATE TABLE `vols` (
  `id` int(10) NOT NULL,
  `aeroport_dep` int(10) NOT NULL,
  `aeroport_arr` int(10) NOT NULL,
  `heure_dep` int(10) NOT NULL,
  `heure_arr` int(10) NOT NULL,
  `date_dep` varchar(255) NOT NULL,
  `date_arr` varchar(255) NOT NULL,
  `num_vol` int(10) NOT NULL,
  `reservation` tinyint(1) NOT NULL,
  `nombre_escales` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `escales`
--
ALTER TABLE `escales`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `escale_vols`
--
ALTER TABLE `escale_vols`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vol` (`vol`,`escale`),
  ADD KEY `escale` (`escale`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vols`
--
ALTER TABLE `vols`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aeroport_dep` (`aeroport_dep`,`aeroport_arr`),
  ADD KEY `aeroport_arr` (`aeroport_arr`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `escale_vols`
--
ALTER TABLE `escale_vols`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `vols`
--
ALTER TABLE `vols`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1009;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `escale_vols`
--
ALTER TABLE `escale_vols`
  ADD CONSTRAINT `escale_vols_ibfk_1` FOREIGN KEY (`escale`) REFERENCES `escales` (`id`),
  ADD CONSTRAINT `escale_vols_ibfk_2` FOREIGN KEY (`vol`) REFERENCES `vols` (`id`);

--
-- Contraintes pour la table `vols`
--
ALTER TABLE `vols`
  ADD CONSTRAINT `vols_ibfk_1` FOREIGN KEY (`aeroport_dep`) REFERENCES `aeroport` (`id`),
  ADD CONSTRAINT `vols_ibfk_2` FOREIGN KEY (`aeroport_arr`) REFERENCES `aeroport` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
