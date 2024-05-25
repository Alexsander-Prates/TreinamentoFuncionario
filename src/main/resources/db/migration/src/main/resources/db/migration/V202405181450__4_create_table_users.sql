-- V4__Create_Tabela_Users.sql

CREATE TABLE IF NOT EXISTS USUARIO (
    id SERIAL PRIMARY KEY,
    login TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    tipo TEXT
    );