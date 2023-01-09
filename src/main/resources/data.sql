CREATE TABLE IF NOT EXISTS Users (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           nom VARCHAR(250) NOT NULL,
                           prenom VARCHAR(250) NOT NULL,
                           mail VARCHAR(250) NOT NULL,
                           password VARCHAR(250) NOT NULL,
                           banni VARCHAR(250) NOT NULL,
                           dateNaissance VARCHAR(250) NOT NULL
);
