INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '558471', 'ricardo123', 'Lucas Rainha');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '554944', 'futebol', 'Nicolas Barutti');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '557887', 'paodequeijo', 'Kleber da Silva');

INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'ENTRENCE', 'A1', 'ABC1D23', 1, 'ELECTRIC');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'MAINTENANCE', 'B2', 'XYZ9K87', 1, 'COMBUSTION');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'WASHING', 'C3', 'JHK4T56', 1, 'ELECTRIC');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'STORAGE1', 'D4', 'LMN7R88', 1, 'COMBUSTION');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'STORAGE2', 'E5', 'QWE2Z45', 1, 'ELECTRIC');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'ENTRENCE', 'F6', 'ASD3F76', 1, 'COMBUSTION');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'MAINTENANCE', 'G7', 'POI8L65', 1, 'ELECTRIC');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'WASHING', 'H8', 'ZXC6V54', 1, 'COMBUSTION');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'STORAGE1', 'I9', 'BNM5T43', 1, 'ELECTRIC');
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES (SYS_GUID(), 'STORAGE2', 'J10', 'RTY1G12', 1, 'COMBUSTION');


--Inserts para Updates

-- 1. Inserir usuários adicionais (se necessário)
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '558472', 'senha123', 'Ana Silva');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '554945', 'outrasenha', 'Carlos Oliveira');

-- 2. Inserir motocicletas adicionais
INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES
(SYS_GUID(), 'ENTRENCE', 'P16', 'PLA1TE1', 1, 'ELECTRIC');

INSERT INTO MOTORCYCLE (id, sector, position, plate, PLATE_READABLE, type) VALUES
(SYS_GUID(), 'MAINTENANCE', 'Q17', 'PLA2TE2', 1, 'COMBUSTION');

-- 3. Inserir updates diretamente (usando subconsultas para obter os IDs)
-- Update 1
INSERT INTO USER_UPDATE (id, user_id, motorcycle_id, update_date, update_message)
SELECT
    SYS_GUID(),
    (SELECT id FROM USERS WHERE rm = '558471' AND ROWNUM = 1),
    (SELECT id FROM MOTORCYCLE WHERE plate = 'ABC1D23' AND ROWNUM = 1),
    SYSDATE - 1,
    'Revisão completa do sistema elétrico'
FROM DUAL;

-- Update 2
INSERT INTO USER_UPDATE (id, user_id, motorcycle_id, update_date, update_message)
SELECT
    SYS_GUID(),
    (SELECT id FROM USERS WHERE rm = '554944' AND ROWNUM = 1),
    (SELECT id FROM MOTORCYCLE WHERE plate = 'XYZ9K87' AND ROWNUM = 1),
    SYSDATE - 2,
    'Troca de óleo e filtros realizada'
FROM DUAL;

-- Update 3
INSERT INTO USER_UPDATE (id, user_id, motorcycle_id, update_date, update_message)
SELECT
    SYS_GUID(),
    (SELECT id FROM USERS WHERE rm = '557887' AND ROWNUM = 1),
    (SELECT id FROM MOTORCYCLE WHERE plate = 'JHK4T56' AND ROWNUM = 1),
    SYSDATE - 3,
    'Lavagem completa e polimento'
FROM DUAL;

-- Update 4
INSERT INTO USER_UPDATE (id, user_id, motorcycle_id, update_date, update_message)
SELECT
    SYS_GUID(),
    (SELECT id FROM USERS WHERE rm = '558471' AND ROWNUM = 1),
    (SELECT id FROM MOTORCYCLE WHERE plate = 'LMN7R88' AND ROWNUM = 1),
    SYSDATE - 4,
    'Transferência para área de armazenamento'
FROM DUAL;

-- Update 5
INSERT INTO USER_UPDATE (id, user_id, motorcycle_id, update_date, update_message)
SELECT
    SYS_GUID(),
    (SELECT id FROM USERS WHERE rm = '554944' AND ROWNUM = 1),
    (SELECT id FROM MOTORCYCLE WHERE plate = 'QWE2Z45' AND ROWNUM = 1),
    SYSDATE,
    'Inspeção de rotina - sem problemas encontrados'
FROM DUAL;

COMMIT;