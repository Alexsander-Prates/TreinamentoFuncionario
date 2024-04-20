-- V3__Create_Tabela_Usuario_Treinamento.sql

CREATE TABLE IF NOT EXISTS USUARIO_TREINAMENTO (
    usuario_id INT,
    treinamento_id INT,
    PRIMARY KEY (usuario_id, treinamento_id),
    FOREIGN KEY (usuario_id) REFERENCES USUARIO(id),
    FOREIGN KEY (treinamento_id) REFERENCES TREINAMENTO(id)
    );
