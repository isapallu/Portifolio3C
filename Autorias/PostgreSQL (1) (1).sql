create TABLE Sistema (
  nome VARCHAR (20),
  cpf_usuario serial,
  id_notificacao serial,
  FOREIGN KEY (cpf_usuario)
  REFERENCES Usuario (cpf),
  FOREIGN key (id_notificacao)
  REFERENCES notificacao (id)
  )
  
  create table Usuario (
    nome VARCHAR (20),
    cpf VARCHAR (20),
    senha VARCHAR (5),
    id_feedback serial,
    id_calendario serial,
    id_dados serial,
    PRIMARY key (cpf),
    FOREIGN KEY (id_feedback)
    REFERENCES Feedback (id),
    FOREIGN key (id_calendario)
    REFERENCES calendario (id),
    FOREIGN KEY (id_dados)
    REFERENCES dados (id)
    )
    
    
    CREATE TABLE Responsavel (
      cpf_aluno VARCHAR (20),
      nome VARCHAR (20),
      cpf VARCHAR (20),
      senha VARCHAR (20),
      id_feedback serial,
      id_calendario serial,
      id_dados serial,
      PRIMARY key (cpf),
      FOREIGN KEY (cpf_aluno)
      REFERENCES Aluno (cpf),
      FOREIGN KEY (id_feedback)
      REFERENCES Feedback (id),
      FOREIGN KEY (id_calendario)
      REFERENCES calendario (id),
      FOREIGN KEY (id_dados)
      REFERENCES dados (id)
      )
      
      CREATE table notificacao (
        id_dados serial,
        id_calendario serial,
        id serial,
        Primary key (id),
        FOREIGN KEY (id_dados)
        REFERENCES dados (id),
        FOREIGN key (id_calendario)
        REFERENCES calendario (id)
        )
        
        create table calendario (
          mes VARCHAR (10),
          dias int,
          avaliacao VARCHAR (10),
          atividade VARCHAR (10),
          conteudo VARCHAR (50),
          id serial,
          PRIMARY key (id)
          )
          
          create table Feedback (
            qntEstrela int,
            descricao VARCHAR (50),
            id serial,
            PRIMARY key (id)
            )
            
            CREATE table Professor (
              cfep VARCHAR (10),
              primary key (cfep)
              )
              
             create table dados (
               notas VARCHAR (100),
               frequencia decimal (3,1),
               boletim VARCHAR (100),
               id serial,
               PRIMARY key (id)
               )
               
               create table Aluno (
                 nome VARCHAR (20),
                 cpf VARCHAR (20),
                 senha VARCHAR (20),
                 id_feedback serial,
                 id_calendario serial,
                 id_dados serial,
                 PRIMARY key (cpf),
                 FOREIGN key (id_feedback)
                 REFERENCES feedback (id),
                 FOREIGN key (id_calendario)
                 REFERENCES calendario (id),
                 FOREIGN key (id_dados)
                 REFERENCES dados (id)
                 )
                 
                create table email (
                  cpf_responsavel VARCHAR (20),
                  cpf_professor VARCHAR (20),
                  cpf_aluno VARCHAR (20),
                  FOREIGN key (cpf_responsavel)
                  REFERENCES responsavel (cpf),
                  FOREIGN key (cpf_professor)
                  REFERENCES professor (cpf),
                  FOREIGN key (cpf_aluno)
                  references aluno (cpf)
                  )
            
        
        