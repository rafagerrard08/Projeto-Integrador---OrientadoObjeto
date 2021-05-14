CREATE TABLE produto (
    id_produto int auto_increment PRIMARY KEY,
FOREIGN KEY(id_loja) REFERENCES id_loja (id_loja)
    nome varchar(45),
    qtd_produto int(10),
    valor decimal(6,2),
    categoria varchar(45),
    cor varchar(45),
    marca varchar(45),
  
);