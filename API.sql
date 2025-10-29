INSERT INTO categoria (nome) VALUES 
('Eletrônicos'),
('Roupas'),
('Livros'),
('Alimentos');

select * from public.item_pedido

INSERT INTO endereco (cep, logradouro, complemento, bairro, localidade, uf) VALUES
('22775030', 'Rua das Palmeiras', 'Apto 202', 'Centro', 'Rio de Janeiro', 'RJ'),
('22041001', 'Avenida Atlântica', 'Cobertura', 'Copacabana', 'Rio de Janeiro', 'RJ');

INSERT INTO cliente (nome, cpf, telefone, email, endereco_id) VALUES
('João Menezes', '12345678900', '(21)99999-1111', 'joao.menezes@gmail.com', 1),
('Will Lippi', '98765432100', '(21)98888-2222', 'will.lippi@gmail.com', 2);

INSERT INTO produto (nome, descricao, preco) VALUES
('Smartphone Galaxy S23', 'Celular Android 256GB', 4200.00),
('Camiseta Branca', 'Camiseta 100% algodão tamanho M', 59.90),
('Livro Java para Iniciantes', 'Guia completo sobre Java', 120.00),
('Arroz Tipo 1 5kg', 'Pacote de arroz branco', 25.00);

select * from public.endereco

select * from public.categoria

select * from public.usuario

select * from public.cliente

INSERT INTO usuario (email, nome, senha)
VALUES ('joao@email.com', 'João', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK');

INSERT INTO usuario (email, nome, senha)
VALUES 
('maria@email.com', 'Maria', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'),
('carlos@email.com', 'Carlos', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK'),
('ana@email.com', 'Ana', '$2a$12$sPPV9up/RlaZGUBA1AU7ju66f4o.eNSGhhCaWUdr4rnvDZ.QjaMtK');

DELETE from public.endereco E WHERE E.id_endereco = 8 


ALTER TABLE pedido DROP CONSTRAINT pedido_status_pedido_check;

ALTER TABLE pedido ADD CONSTRAINT pedido_status_pedido_check
CHECK (status_pedido IN ('PENDENTE', 'PROCESSANDO', 'ENVIADO', 'ENTREGUE', 'CANCELADO', 'DEVOLVIDO'));


select * from public.fornecedor
