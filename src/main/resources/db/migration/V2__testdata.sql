use banking;
INSERT accounts(account_number, current_balance, created_at, created_by) SELECT 'AC12345', 25512, NOW(), 'Script' WHERE NOT EXISTS ( SELECT * FROM accounts 
                   WHERE account_number = 'AC12345');
INSERT accounts(account_number, current_balance, created_at, created_by) SELECT 'AC67890', 12250.67, NOW(), 'Script' WHERE NOT EXISTS ( SELECT * FROM accounts 
                   WHERE account_number = 'AC67890');