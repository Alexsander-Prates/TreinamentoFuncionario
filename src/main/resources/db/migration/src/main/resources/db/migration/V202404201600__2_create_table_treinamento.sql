-- V2__Create_Tabela_Treinamentos.sql

CREATE TABLE IF NOT EXISTS TREINAMENTO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao VARCHAR(255),
    inicio VARCHAR(255),
    fim VARCHAR(255),
    classificacao VARCHAR(255)
);