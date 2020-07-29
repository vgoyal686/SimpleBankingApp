CREATE TABLE IF NOT EXISTS `banking`.`accounts` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_at DATETIME,
  updated_at DATETIME,
  created_by varchar(100),
  updated_by varchar(100),
  account_number varchar(100) NOT NULL,
  current_balance double(53,2) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY UK_account_number (account_number)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `banking`.`transactions` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  created_at DATETIME,
  updated_at DATETIME,
  created_by varchar(100),
  updated_by varchar(100),
  transaction_type varchar(100) NOT NULL,
  transaction_amount double(53,2) NOT NULL,
  account_number varchar(100) NOT NULL,
  FOREIGN KEY (account_number) REFERENCES accounts(account_number),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;