DECLARE
    -- Cursor ordenado por data para mostrar a sequência temporal
    CURSOR c_updates IS
        SELECT 
            id,
            update_message,
            update_date,
            LAG(update_message) OVER (ORDER BY update_date) as mensagem_anterior,
            LEAD(update_message) OVER (ORDER BY update_date) as mensagem_posterior,
            ROW_NUMBER() OVER (ORDER BY update_date) as linha
        FROM user_update
        ORDER BY update_date;
    
    v_total_registros NUMBER;
BEGIN
    -- Verificar se há registros suficientes
    SELECT COUNT(*) INTO v_total_registros FROM user_update;
    
    IF v_total_registros < 5 THEN
        DBMS_OUTPUT.PUT_LINE('É necessário ter pelo menos 5 registros na tabela USER_UPDATE.');
        RETURN;
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('=== Comparação de Updates Adjacentes ===');
    DBMS_OUTPUT.PUT_LINE('Data          | Update Atual                     | Update Anterior                  | Próximo Update');
    DBMS_OUTPUT.PUT_LINE('---------------------------------------------------------------------------------------------------');
    
    -- Percorrer os updates
    FOR reg IN c_updates LOOP
        -- Mostrar apenas 5 linhas como solicitado
        EXIT WHEN reg.linha > 5;
        
        DBMS_OUTPUT.PUT_LINE(
            TO_CHAR(reg.update_date, 'DD/MM/YYYY') || ' | ' ||
            RPAD(NVL(reg.update_message, ' '), 30) || ' | ' ||
            RPAD(NVL(reg.mensagem_anterior, 'Vazio'), 30) || ' | ' ||
            NVL(reg.mensagem_posterior, 'Vazio')
        );
    END LOOP;
END;
/