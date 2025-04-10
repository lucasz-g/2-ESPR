--> INIT database
CREATE TABLE MEDICAMENTO(
  ID_MEDICAMENTO NUMBER PRIMARY KEY,
  NOME VARCHAR(100) NOT NULL,
  DESCRICAO CLOB NOT NULL
);

CREATE TABLE PRESCRICAO(
  ID_PRESCRICAO NUMBER PRIMARY KEY,
  ID_ATENDIMENTO NUMBER NOT NULL,
  ID_MEDICAMENTO NUMBER NOT NULL,
  DOSAGEM VARCHAR(200) NOT NULL,
  FREQUENCIA VARCHAR(200) NOT NULL,
  
  CONSTRAINT FK_ATENDIMENTO FOREIGN KEY (ID_ATENDIMENTO) REFERENCES ATENDIMENTO(ID_ATENDIMENTO),
  CONSTRAINT FK_MEDICAMENTO FOREIGN KEY (ID_MEDICAMENTO) REFERENCES MEDICAMENTO(ID_MEDICAMENTO)
);

CREATE TABLE ATENDIMENTO(
  ID_ATENDIMENTO NUMBER PRIMARY KEY,
  ID_PACIENTE NUMBER NOT NULL,
  ID_MEDICO NUMBER NOT NULL,
  DATA_HORA DATE NOT NULL,
  DESCRICAO_ATENDIMENTO CLOB,
  
  CONSTRAINT FK_PACIENTE FOREIGN KEY (ID_PACIENTE) REFERENCES PACIENTE(ID_PACIENTE),
  CONSTRAINT FK_MEDICO FOREIGN KEY (ID_MEDICO) REFERENCES MEDICO(ID_MEDICO)
);

CREATE TABLE PACIENTE(
  ID_PACIENTE NUMBER PRIMARY KEY,
  NOME VARCHAR2(200),
  DATA_NASCIMENTO DATE NOT NULL,
  ENDERECO VARCHAR2(255),
  TELEFONE VARCHAR2(20)
);

CREATE TABLE MEDICO(
  ID_MEDICO NUMBER PRIMARY KEY,
  NOME VARCHAR2(100) NOT NULL,
  ESPECIALIDADE VARCHAR2 NOT NULL,
  CRM VARCHAR2(20) UNIQUE NOT NULL,
  TELEFONE VARCHAR(20)
);

-->ALTER TABLE PARA INCLUIR PK
ALTER TABLE ATENDIMENTO 
ADD CONSTRAINT ATENDIMENTO_PK 
PRIMARY KEY (ID_ATENDIMENTO);


--> ALTER TABLE PARA INCLUIR FK
ALTER TABLE ATENDIMENTO 
ADD CONSTRAINT FK_ATENDIMENTO_MEDICO 
FOREIGN KEY (ID_MEDICO) 
REFERENCES MEDICO (ID_MEDICO);

--> INSERT TABLE
INSERT INTO MEDICAMENTO VALUES (
	'Novalgina',
	'Anti-inflamatório'
)

--> QUERY database
SELECT * FROM MEDICAMENTO;