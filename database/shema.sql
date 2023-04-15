CREATE DATABASE `cinema`;
CREATE TABLE `films` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `sessions` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `film` bigint NOT NULL,
  `start_dt` datetime NOT NULL,
  `price` decimal(17,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `film_id_idx` (`film`),
  CONSTRAINT `film_id` FOREIGN KEY (`film`) REFERENCES `films` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `tickets` (
  `number` bigint NOT NULL AUTO_INCREMENT,
  `session` bigint NOT NULL,
  PRIMARY KEY (`number`),
  KEY `session_id_idx` (`session`),
  CONSTRAINT `session_id` FOREIGN KEY (`session`) REFERENCES `sessions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;