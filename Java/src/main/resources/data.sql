INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '558471', 'ricardo123', 'Lucas Rainha');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '554944', 'futebol', 'Nicolas Barutti');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '557887', 'paodequeijo', 'Kleber da Silva');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '558472', 'senha123', 'Ana Silva');
INSERT INTO USERS (id, rm, password, name) VALUES (SYS_GUID(), '554945', 'outrasenha', 'Carlos Oliveira');


INSERT INTO SECTOR (id, name) VALUES (SYS_GUID(), 'ENTRANCE');
INSERT INTO SECTOR (id, name) VALUES (SYS_GUID(), 'MAINTENANCE');
INSERT INTO SECTOR (id, name) VALUES (SYS_GUID(), 'WASHING');
INSERT INTO SECTOR (id, name) VALUES (SYS_GUID(), 'STORAGE1');
INSERT INTO SECTOR (id, name) VALUES (SYS_GUID(), 'STORAGE2');


INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A1', 0, (SELECT id FROM SECTOR WHERE name = 'ENTRANCE') FROM dual;
INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A2', 1, (SELECT id FROM SECTOR WHERE name = 'ENTRANCE') FROM dual;

INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A1', 0, (SELECT id FROM SECTOR WHERE name = 'MAINTENANCE') FROM dual;
INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A2', 0, (SELECT id FROM SECTOR WHERE name = 'MAINTENANCE') FROM dual;

INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A1', 1, (SELECT id FROM SECTOR WHERE name = 'WASHING') FROM dual;
INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A2', 1, (SELECT id FROM SECTOR WHERE name = 'WASHING') FROM dual;

INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A1', 1, (SELECT id FROM SECTOR WHERE name = 'STORAGE1') FROM dual;
INSERT INTO SPOT (id, code, occupied, sector_id)
SELECT SYS_GUID(), 'A2', 0, (SELECT id FROM SECTOR WHERE name = 'STORAGE2') FROM dual;



INSERT INTO MOTORCYCLE (id, sector_id, plate, plate_readable, type)
SELECT SYS_GUID(), (SELECT id FROM SECTOR WHERE name = 'ENTRANCE'), 'ABC1D23', 1, 'ELECTRIC' FROM dual;

INSERT INTO MOTORCYCLE (id, sector_id, plate, plate_readable, type)
SELECT SYS_GUID(), (SELECT id FROM SECTOR WHERE name = 'MAINTENANCE'), 'XYZ9K87', 1, 'COMBUSTION' FROM dual;

INSERT INTO MOTORCYCLE (id, sector_id, plate, plate_readable, type)
SELECT SYS_GUID(), (SELECT id FROM SECTOR WHERE name = 'WASHING'), 'JHK4T56', 1, 'ELECTRIC' FROM dual;

INSERT INTO MOTORCYCLE (id, sector_id, plate, plate_readable, type)
SELECT SYS_GUID(), (SELECT id FROM SECTOR WHERE name = 'STORAGE1'), 'LMN7R88', 1, 'COMBUSTION' FROM dual;

INSERT INTO MOTORCYCLE (id, sector_id, plate, plate_readable, type)
SELECT SYS_GUID(), (SELECT id FROM SECTOR WHERE name = 'STORAGE2'), 'QWE2Z45', 1, 'ELECTRIC' FROM dual;


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