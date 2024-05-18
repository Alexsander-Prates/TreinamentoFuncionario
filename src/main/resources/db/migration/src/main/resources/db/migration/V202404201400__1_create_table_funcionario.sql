-- V1__Create_Tabela_Funcionario.sql


CREATE TABLE IF NOT EXISTS FUNCIONARIO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    setor VARCHAR(255) NOT NULL,
    cargo VARCHAR(255) NOT NULL,
    inscricao VARCHAR(255)
);