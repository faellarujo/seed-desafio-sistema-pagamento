-- Password: password
INSERT INTO usuario (email) VALUES ('raphaelaraujo.ti@gmail.com');
INSERT INTO usuario (email) VALUES ('sylvain617@uorak.com');
INSERT INTO usuario (email) VALUES ('benamar1828@uorak.com');
INSERT INTO usuario (email) VALUES ('wael9859@uorak.com');
INSERT INTO usuario (email) VALUES ('tiaodasilva.com');


INSERT INTO restaurante (nome) VALUES ('Restaurante A');
INSERT INTO restaurante (nome) VALUES ('Restaurante B');
INSERT INTO restaurante (nome) VALUES ('Restaurante C');
INSERT INTO restaurante (nome) VALUES ('Restaurante D');
INSERT INTO restaurante (nome) VALUES ('Restaurante E');


-- Forma de Pagamento for User 1
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (1, 1, 'DINHEIRO', false, 'Pagamento em dinheiro');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (1, 2, 'CARTAO', true, 'Pagamento com cartão');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (1, 3, 'PIX', true, 'Pagamento via PIX');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (1, 4, 'MAQUINA', true, 'Pagamento via máquina');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (1, 5, 'CHEQUE', false, 'Pagamento com cheque');

-- Forma de Pagamento for User 2
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (2, 1, 'CARTAO', true, 'Pagamento com cartão');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (2, 2, 'PIX', true, 'Pagamento via PIX');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (2, 3, 'MAQUINA', true, 'Pagamento via máquina');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (2, 4, 'CHEQUE', false, 'Pagamento com cheque');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (2, 5, 'DINHEIRO', false, 'Pagamento em dinheiro');

-- Forma de Pagamento for User 3
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (3, 1, 'PIX', true, 'Pagamento via PIX');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (3, 2, 'MAQUINA', true, 'Pagamento via máquina');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (3, 3, 'CHEQUE', false, 'Pagamento com cheque');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (3, 4, 'DINHEIRO', false, 'Pagamento em dinheiro');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (3, 5, 'CARTAO', true, 'Pagamento com cartão');

-- Forma de Pagamento for User 4
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (4, 1, 'MAQUINA', true, 'Pagamento via máquina');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (4, 2, 'CHEQUE', false, 'Pagamento com cheque');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (4, 3, 'DINHEIRO', false, 'Pagamento em dinheiro');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (4, 4, 'CARTAO', true, 'Pagamento com cartão');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (4, 5, 'PIX', true, 'Pagamento via PIX');

-- Forma de Pagamento for User 5
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (5, 1, 'CHEQUE', false, 'Pagamento com cheque');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (5, 2, 'DINHEIRO', false, 'Pagamento em dinheiro');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (5, 3, 'CARTAO', true, 'Pagamento com cartão');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (5, 4, 'PIX', true, 'Pagamento via PIX');
INSERT INTO forma_de_pagamento (usuario_id, restaurante_id, tipo, pagamento_Online, descricao) VALUES (5, 5, 'MAQUINA', true, 'Pagamento via máquina');