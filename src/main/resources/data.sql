-- Inserir eventos
INSERT INTO tb_evento (evento, data_hora_evento, descricao) VALUES('Chuva', '2024-11-08 10:00:00', 'Descrição do Evento 1');

-- Inserir sensores
INSERT INTO tb_sensor (tipo_sensor, localizacao) VALUES('Nível de água', 'São Paulo');

-- Inserir leituras para os sensores
INSERT INTO tb_leitura (sensor_id, valor, data_hora) VALUES(1, 23.5, '2024-11-08');

INSERT INTO tb_evento_sensor (evento_id, sensor_id) VALUES (1, 1);

-- Inserir alertas para as leituras
INSERT INTO tb_alerta (leitura_sensor_id, data_hora_alerta, status, tipo_alerta)
VALUES (1, '2024-11-08 10:15:00', 'Ativo', 'Alerta de Nível');

-- Inserir manutenções associadas aos alertas
INSERT INTO tb_manutencao (data_hora_manutencao, descricao, tipo_manutencao, alerta_id)
VALUES('2024-11-08 12:00:00', 'Evacuar água para previnir possíveis enchentes.', 'Prevensão de enchentes', 1);

-- Insert para tb_user
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Maria Brown', 'maria@gmail.com', '988888888', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '2001-07-25');
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Alex Green', 'alex@gmail.com', '977777777', '$2a$10$N7SkKCa3r17ga.i.dF9iy.BFUBL2n3b6Z1CWSZWi/qy7ABq/E6VpO', '1987-12-13');

-- Insert para tb_role
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

-- Insert para tb_user_role
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
