SET SERVEROUTPUT ON

DECLARE
    v_total_motos NUMBER;
    v_total_usuarios NUMBER;
    v_total_updates NUMBER;
    
BEGIN
    -- Consulta 1: Usuários mais ativos (com mais atualizações)
    DBMS_OUTPUT.PUT_LINE('=== Top 5 Usuários Mais Ativos ===');
    FOR usuario IN (
        SELECT u.name, COUNT(up.id) as qtd_updates
        FROM users u
        LEFT JOIN user_update up ON u.id = up.user_id
        GROUP BY u.name
        ORDER BY qtd_updates DESC
        FETCH FIRST 5 ROWS ONLY
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(usuario.name, 25) || ': ' || 
            usuario.qtd_updates || ' atualizações'
        );
    END LOOP;
    
    -- Consulta 2: Motos mais atualizadas
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '=== Top 5 Motos Mais Atualizadas ===');
    FOR moto IN (
        SELECT m.plate, m.sector, COUNT(up.id) as qtd_updates
        FROM motorcycle m
        LEFT JOIN user_update up ON m.id = up.motorcycle_id
        GROUP BY m.plate, m.sector
        ORDER BY qtd_updates DESC
        FETCH FIRST 5 ROWS ONLY
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(moto.plate, 10) || ' - ' ||
            RPAD(moto.sector, 15) || ': ' ||
            moto.qtd_updates || ' atualizações'
        );
    END LOOP;
    
    -- Consulta 3: Setores com mais atividade
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '=== Atividade por Setor ===');
    FOR setor IN (
        SELECT m.sector, COUNT(up.id) as qtd_updates
        FROM motorcycle m
        LEFT JOIN user_update up ON m.id = up.motorcycle_id
        GROUP BY m.sector
        ORDER BY qtd_updates DESC
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(setor.sector, 15) || ': ' || 
            setor.qtd_updates || ' atualizações'
        );
    END LOOP;
    
    -- Totais gerais
    SELECT COUNT(*) INTO v_total_motos FROM motorcycle;
    SELECT COUNT(*) INTO v_total_usuarios FROM users;
    SELECT COUNT(*) INTO v_total_updates FROM user_update;
    
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '=== Totais Gerais ===');
    DBMS_OUTPUT.PUT_LINE('Total de motocicletas: ' || v_total_motos);
    DBMS_OUTPUT.PUT_LINE('Total de usuários: ' || v_total_usuarios);
    DBMS_OUTPUT.PUT_LINE('Total de atualizações: ' || v_total_updates);
END;
/