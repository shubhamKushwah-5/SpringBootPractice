CREATE DATABASE trading_journal_db;
USE trading_journal_db;

SHOW TABLES;
DESCRIBE trades;
select * from trades;
SELECT 
    symbol,
    type,
    entry_price,
    exit_price,
    quantity,
    CASE 
        WHEN type = 'BUY' THEN (exit_price - entry_price) * quantity
        ELSE (entry_price - exit_price) * quantity
    END as pnl
FROM trades;
SELECT SUM(
    CASE 
        WHEN type = 'BUY' THEN (exit_price - entry_price) * quantity
        ELSE (entry_price - exit_price) * quantity
    END
) as total_pnl FROM trades;