-- V4__Create_Tabela_Users.sql

CREATE TABLE users (
    id INT PRIMARY KEY NOT NULL,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    role TEXTE NOT NULL
);