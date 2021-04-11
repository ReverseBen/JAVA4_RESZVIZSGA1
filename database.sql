-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2021. Ápr 11. 12:05
-- Kiszolgáló verziója: 10.4.14-MariaDB
-- PHP verzió: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `webforumdb`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `comment`
--

CREATE TABLE `comment` (
  `id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `comment_text` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `comment`
--

INSERT INTO `comment` (`id`, `post_id`, `username`, `comment_text`) VALUES
(1, 1, 'kisserno', 'Szuper! A következő hónapban be is szerzem'),
(2, 1, 'kockajanos', 'Nálam már az duruzsol a PC-ben'),
(3, 3, 'kockajanos', 'Köszönöm, rá is nézek'),
(4, 3, 'vagopista', 'Nekem az új effektek tetszenek a legjobban'),
(5, 4, 'musicgergely', 'Én már hallgatom is'),
(6, 4, 'musicerno', 'Holnap már nálam is szól az autóban');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `post`
--

CREATE TABLE `post` (
  `id` int(11) NOT NULL,
  `topic_id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `post_title` varchar(20) NOT NULL,
  `post_text` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `post`
--

INSERT INTO `post` (`id`, `topic_id`, `username`, `post_title`, `post_text`) VALUES
(1, 1, 'kissistvan', 'Új VGA', 'Megjelentek a legújabb videókártyák a piacon'),
(2, 1, 'beni', 'JAVAvengers', 'Megalakult a JAVAvengers'),
(3, 2, 'beni', 'Filmora X', 'Megjelent a legújabb Filmora'),
(4, 3, 'mrmusic', 'Republic', 'Megjelent a legújabb albuma a Republic zenekarnak');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `topic`
--

CREATE TABLE `topic` (
  `id` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `topic_title` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- A tábla adatainak kiíratása `topic`
--

INSERT INTO `topic` (`id`, `username`, `topic_title`) VALUES
(1, 'wincseszter', 'Hardver'),
(2, 'szoftvererno', 'Szoftver'),
(3, 'kissistvan', 'Zene');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `post_id` (`post_id`);

--
-- A tábla indexei `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`id`),
  ADD KEY `topic_id` (`topic_id`);

--
-- A tábla indexei `topic`
--
ALTER TABLE `topic`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT a táblához `post`
--
ALTER TABLE `post`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT a táblához `topic`
--
ALTER TABLE `topic`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`);

--
-- Megkötések a táblához `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `post_ibfk_1` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
