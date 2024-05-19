-- V4__Create_Tabela_Users.sql

CREATE TABLE usuario (
    id INT PRIMARY KEY NOT NULL,
    login TEXT NOT NULL UNIQUE,
    senha TEXT NOT NULL,
    tipo TEXTE NOT NULL
);