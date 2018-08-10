DROP DATABASE IF EXISTS exercicio_web_01;
CREATE DATABASE IF NOT EXISTS exercicio_web_01;
USE exercicio_web_01;

CREATE TABLE boletim(
id INT AUTO_INCREMENT PRIMARY KEY,
nome VARCHAR(100),
matricula VARCHAR(100),
nota1 FLOAT,
nota2 FLOAT,
nota3 FLOAT,
frequencia TINYINT
);