INSERT INTO categoria (nome) values('Camisas');
INSERT INTO categoria (nome) values('Canecas');
INSERT INTO categoria (nome) values('Tenis');
INSERT INTO categoria (nome) values('Chaveiros');

INSERT INTO marca (nome) values('Nike');
INSERT INTO marca (nome) values('Adidas');
INSERT INTO marca (nome) values('Asics');

INSERT INTO produto (produto, descricao, valor, categoria_id, marca_id) values('Camisa Nike', 'Camisa Regata Nike vermelha', 77.80, 1, 1);
INSERT INTO produto (produto, descricao, valor, categoria_id, marca_id) values('Tenis Asics Kayano 21', 'Asics Kayano 21, cores preto e laranja, amorcetimento em gel', 459.89, 3, 3);
INSERT INTO produto (produto, descricao, valor, categoria_id, marca_id) values('Tenis Nike Runner', 'Nike Runner branco', 892.49, 3, 1);

INSERT INTO fornecedor (empresa, razao_social, cnpj, responsavel, telefone) values('TeniShop', 'Nike LTDA', '55849523000187', 'André Soares', '46999526487');

INSERT INTO permissao (nome) values('ROLE_ADMIN');
INSERT INTO permissao (nome) values('ROLE_USER');

INSERT INTO usuario(nome, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO usuario(nome, username, password) VALUES ('Teste', 'teste','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (1, 1);
INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (1, 2);
INSERT INTO usuario_permissoes(usuario_id, permissoes_id) VALUES (2, 2);