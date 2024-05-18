-- V3__Create_Tabela_Funcionario_Treinamento.sql

CREATE TABLE IF NOT EXISTS FUNCIONARIO_TREINAMENTO (
    funcionario_id INT,
    treinamento_id INT,
    PRIMARY KEY (funcionario_id, treinamento_id),
    FOREIGN KEY (funcionario_id) REFERENCES FUNCIONARIO(id),
    FOREIGN KEY (treinamento_id) REFERENCES TREINAMENTO(id)
    );
