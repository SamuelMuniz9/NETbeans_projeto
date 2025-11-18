-- Script completo do banco BCJava
CREATE DATABASE IF NOT EXISTS BCJava;
USE BCJava;

CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    telefone VARCHAR(20),
    funcao VARCHAR(100),
    area_departamento VARCHAR(100),
    nome_organizacao VARCHAR(100),
    pais_regiao VARCHAR(100),
    cep VARCHAR(20),
    interesse_principal VARCHAR(100)
);

CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2),
    data_v DATETIME,
    qtd INT
);

CREATE TABLE sistema_vendas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    produto VARCHAR(100),
    data_vendas DATETIME,
    valor DECIMAL(10,2)
);
