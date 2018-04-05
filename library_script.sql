-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               5.7.21-log - MySQL Community Server (GPL)
-- Операционная система:         Win64
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Дамп структуры базы данных library
CREATE DATABASE IF NOT EXISTS `library` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `library`;

-- Дамп структуры для таблица library.authors
CREATE TABLE IF NOT EXISTS `authors` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.authors: ~13 rows (приблизительно)
DELETE FROM `authors`;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` (`id`, `name`, `surname`, `birthday`) VALUES
	(1, 'Fedor', 'Dostoevsky', '1821-11-11'),
	(2, 'Lev', 'Tolstoy', '1828-09-09'),
	(3, 'Misha', 'Bulgakov', '1891-05-15'),
	(4, 'Aleksander', 'Pushkin', '1789-08-12'),
	(5, 'Somerset', 'Maugham', '1875-02-12'),
	(6, '1', '1', '1111-11-10'),
	(7, 'man', 'hipster', '1995-06-21'),
	(8, 'Eyes', 'Blue', '1942-12-29'),
	(9, '123', '123', '1237-05-11'),
	(10, '123', 'sdf', '2132-12-01'),
	(11, 'too', 'dono', '1805-09-18'),
	(12, 'aName', 'aSurname', '1125-01-11'),
	(13, 'Daniel', 'Kiz', '1993-12-20'),
	(14, 'Cheetos', 'Chester', '1975-12-11'),
	(15, 'das', 'rere', '1964-10-25');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;

-- Дамп структуры для таблица library.books
CREATE TABLE IF NOT EXISTS `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `published_year` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `available` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.books: ~9 rows (приблизительно)
DELETE FROM `books`;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` (`id`, `title`, `published_year`, `author_id`, `available`) VALUES
	(3, 'Crime and punishment', 1859, 1, 1),
	(4, 'Mu-mu', 2018, 11, 1),
	(5, 'Heroes of Never', 1421, 5, 1),
	(6, 'Dubrovskiy', 1818, 4, 1),
	(8, 'Kapitanskaya Dochka', 1799, 4, 1),
	(9, 'Bremya strastey chelovecheskih', 4512, 1, 1),
	(11, 'Bratiya Karamazovi', 1842, 1, 1),
	(12, 'O chem mechtat\'', 1992, 13, 1),
	(13, 'Heroes', 1989, 13, 1),
	(14, 'Jack sparrow', 1995, 15, 1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;

-- Дамп структуры для таблица library.read_books
CREATE TABLE IF NOT EXISTS `read_books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.read_books: ~9 rows (приблизительно)
DELETE FROM `read_books`;
/*!40000 ALTER TABLE `read_books` DISABLE KEYS */;
INSERT INTO `read_books` (`id`, `user_id`, `book_id`) VALUES
	(85, 1, 3),
	(86, 1, 6),
	(87, 1, 12),
	(88, 2, 5),
	(89, 2, 6),
	(90, 2, 3),
	(91, 1, 11),
	(92, 1, 5),
	(93, 2, 11),
	(94, 49, 4),
	(95, 50, 5);
/*!40000 ALTER TABLE `read_books` ENABLE KEYS */;

-- Дамп структуры для таблица library.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) DEFAULT '0',
  `password` varchar(50) DEFAULT '0',
  `role` tinyint(4) DEFAULT '0',
  `current_book_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

-- Дамп данных таблицы library.users: ~10 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `password`, `role`, `current_book_id`) VALUES
	(1, 'Dima', '8a30ec6807f71bc69d096d8e4d501ade', 1, 0),
	(2, 'user', '6ad14ba9986e3615423dfca256d04e3f', 0, 0),
	(3, '123512', '57fa5ea89590104de19eaafb913ac22c', 0, 0),
	(4, 'Pavluntiy', '40d0778ecc0a2f947d69445d3bcc120b', 0, 0),
	(5, 'irachka', '01a8d61ddc888e38015aeb1b34269ce6', 0, 0),
	(6, 'Dimasta1', 'c79d4a89087dc6cb7d8c67ddf4accdc8', 0, 0),
	(7, 'Solmir', 'd2850200078f10fc0bc1e0df5ed1b829', 0, 0),
	(48, '111', '96e79218965eb72c92a549dd5a330112', 0, 0),
	(49, 'Anna', '98901e3aad679934aa88cfe34bdebefd', 0, 0),
	(50, 'Nikita', 'd8578edf8458ce06fbc5bb76a58c5ca4', 0, 0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
