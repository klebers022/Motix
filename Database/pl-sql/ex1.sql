SET SERVEROUTPUT ON

DECLARE
    -- Cursor para motocicletas por setor
    CURSOR c_motos_por_setor IS
        SELECT m.sector, COUNT(*) as quantidade, 
               ROUND(AVG(CASE WHEN m.is_plate_readable = 1 THEN 1 ELSE 0 END) * 100, 2) as percent_legivel
        FROM motorcycle m
        GROUP BY m.sector
        ORDER BY quantidade DESC;
    
    -- Cursor para atualizações recentes
    CURSOR c_updates_recentes IS
        SELECT u.update_message, u.update_date, us.name as usuario, m.plate as moto_placa
        FROM user_update u
        JOIN users us ON u.user_id = us.id
        JOIN motorcycle m ON u.motorcycle_id = m.id
        WHERE u.update_date >= TRUNC(SYSDATE) - 7
        ORDER BY u.update_date DESC;
    
    -- Cursor para tipos de moto mais comuns
    CURSOR c_tipos_moto IS
        SELECT m.type, COUNT(*) as quantidade
        FROM motorcycle m
        GROUP BY m.type
        ORDER BY quantidade DESC;
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('=== Motocicletas por Setor ===');
    FOR setor IN c_motos_por_setor LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(setor.sector, 15) || ': ' || 
            RPAD(setor.quantidade, 5) || ' motos | ' ||
            setor.percent_legivel || '% placas legíveis'
        );
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '=== Atualizações Recentes (últimos 7 dias) ===');
    FOR upd IN c_updates_recentes LOOP
        DBMS_OUTPUT.PUT_LINE(
            TO_CHAR(upd.update_date, 'DD/MM/YYYY HH24:MI') || ' - ' ||
            RPAD(upd.usuario, 20) || ' - ' ||
            RPAD(upd.moto_placa, 10) || ': ' ||
            upd.update_message
        );
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(CHR(10) || '=== Distribuição por Tipo de Moto ===');
    FOR tipo IN c_tipos_moto LOOP
        DBMS_OUTPUT.PUT_LINE(
            RPAD(tipo.type, 15) || ': ' || 
            tipo.quantidade || ' motos'
        );
    END LOOP;
END;
/