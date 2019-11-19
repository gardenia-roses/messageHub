DROP SCHEMA IF EXISTS `tiaMession`;

CREATE SCHEMA `tiaMession`;

use `tiaMession`;

SET FOREIGN_KEY_CHECKS = 0;




DROP TABLE IF EXISTS `topics`;

CREATE TABLE `topics` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_name` varchar(128) DEFAULT NULL,
  
  PRIMARY KEY (`topic_id`),
  UNIQUE KEY `TITLE_UNIQUE` (`topic_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `messages`;

CREATE TABLE `messages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(256) DEFAULT NULL,
  `topic_id` int(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  KEY `FK_topic_ID_idx` (`topic_id`),

  CONSTRAINT `FK_topic` 
  FOREIGN KEY (`topic_id`) 
  REFERENCES `topics` (`topic_id`) 

  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `users_topics`;

CREATE TABLE `users_topics` (
  `topic_key` int(11) NOT NULL,
  `user_key` int(11) NOT NULL,
  
  PRIMARY KEY (`user_key`,`topic_key`),
  
  KEY `FK_user_idx` (`user_key`),
  
  CONSTRAINT `FK_topic_05` FOREIGN KEY (`topic_key`) 
  REFERENCES `topics` (`topic_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION,
  
  CONSTRAINT `FK_user` FOREIGN KEY (`user_key`) 
  REFERENCES `users` (`user_id`) 
  ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
