-- Atualizando dados na tabela Nutricionista
UPDATE Nutricionista
SET Especialidade = 'Nutrição Geriátrica', Tempo_de_experiencia = 15
WHERE ID_Nutricionista = 1;

-- Deletando dados na tabela Nutricionista
DELETE FROM Nutricionista
WHERE ID_Nutricionista = 3;

-- Atualizando dados na tabela Paciente
UPDATE Paciente
SET Nome = 'Ana Souza', Email = 'ana.souza@email.com'
WHERE ID_Paciente = 1;

-- Deletando dados na tabela Paciente
DELETE FROM Paciente
WHERE ID_Paciente = 3;

-- Atualizando dados na tabela Consulta
UPDATE Consulta
SET ID_Nutricionista = 2, Observacoes = 'Consulta de rotina.'
WHERE ID_Consulta = 1;

-- Deletando dados na tabela Consulta
DELETE FROM Consulta
WHERE ID_Consulta = 3;