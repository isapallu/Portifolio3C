CREATE TABLE Clientes(
  nome VARCHAR (50) not null,
  cpf VARCHAR (11) not null,
  cidade VARCHAR (20),
  rua VARCHAR (20) NOT NULL,
  cep int not NULL,
  bairro VARCHAR (25),
  isbn_livro VARCHAR (25) not NULL,
  PRIMARY KEY (cpf),
  FOREIGN KEY (isbn_livro) REFERENCES Livros (isbn)
);
CREATE TABLE Emails(
  email VARCHAR (50) not NULL,
  cpf_clientes VARCHAR (11) not null,
  FOREIGN KEY (cpf_cliente) REFERENCES Clientes (cpf)
);
CREATE TABLE Telefones(
  telefone_fixo VARCHAR (20) not NULL,
  cpf_clientes VARCHAR (11) not null,
  FOREIGN KEY (cpf_cliente) REFERENCES Clientes (cpf)
);

CREATE TABLE Livros(
  nome VARCHAR (100) NOT NULL,
  local_edicao VARCHAR (100) NOT NULL,
  ano_edicao VARCHAR (4) not NULL,
  isbn VARCHAR (25) not NULL,
  PRIMARY KEY (isbn)
); 
CREATE table Generos(
  genero VARCHAR (15) not NULL,
  isbn_livro VARCHAR (25) not NULL,
  FOREIGN KEY (isbn_livro) REFERENCES Livros (isbn)
);
CREATE TABLE Autores(
  autor VARCHAR (50) not NULL,
  isbn_livro VARCHAR (25) not NULL,
  FOREIGN KEY (isbn_livro) REFERENCES Livros (isbn)
);

