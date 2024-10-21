INSERT INTO Nutricionista (ID_Nutricionista, CRN, Especialidade, Tempo_de_experiencia)
VALUES (1, '12345', 'Nutrição Esportiva', 5),
       (2, '67890', 'Nutrição Clínica', 8),
       (3, '11223', 'Nutrição Pediátrica', 10);

INSERT INTO Paciente (ID_Paciente, Nome, Data_Nascimento, CPF, Telefone, Email)
VALUES (1, 'João Silva', '1980-01-01', '123.456.789-00', '(11) 98765-4321', 'joao.silva@email.com'),
       (2, 'Maria Oliveira', '1990-02-02', '987.654.321-00', '(22) 87654-3210', 'maria.oliveira@email.com'),
       (3, 'Carlos Pereira', '2000-03-03', '456.789.123-00', '(33) 76543-2109', 'carlos.pereira@email.com');

INSERT INTO Consulta (ID_Consulta, ID_Nutricionista, ID_Paciente, Data_Consulta, Observacoes)
VALUES (1, 1, 1, '2022-01-01', 'Primeira consulta, paciente em bom estado de saúde.'),
       (2, 2, 2, '2022-02-02', 'Paciente com necessidade de dieta especial.'),
       (3, 3, 3, '2022-03-03', 'Paciente infantil, necessita de acompanhamento nutricional.');