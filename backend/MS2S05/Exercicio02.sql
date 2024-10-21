CREATE TABLE Nutricionista (
    ID_Nutricionista SERIAL PRIMARY KEY,
    CRN VARCHAR(255),
    Especialidade VARCHAR(255),
    Tempo_de_experiencia INT
);

CREATE TABLE Paciente (
    ID_Paciente SERIAL PRIMARY KEY,
    Nome VARCHAR(255),
    Data_Nascimento DATE,
    CPF VARCHAR(255),
    Telefone VARCHAR(255),
    Email VARCHAR(255)
);

CREATE TABLE Consulta (
    ID_Consulta SERIAL PRIMARY KEY,
    Data_Consulta DATE,
	ID_Nutricionista SERIAL,
    ID_Paciente SERIAL,
    Observacoes VARCHAR(255),
    FOREIGN KEY (ID_Nutricionista) REFERENCES Nutricionista(ID_Nutricionista),
    FOREIGN KEY (ID_Paciente) REFERENCES Paciente(ID_Paciente)
);



DROP TABLE Consulta;
DROP TABLE Paciente;
DROP TABLE Nutricionista;