create table customer(
  customer_id varchar(36) primary key not null,
  first_name varchar(64),
  last_name varchar(64),
  street_address varchar(128),
  city varchar(64),
  state varchar(24),
  zip_code varchar(12),
  phone_number varchar(32)
);

-- DROP TABLE activity_Log

create table activity_Log(
  id varchar(36) primary key not null,
  user varchar(36),
  action varchar(256),
  activity_time TIMESTAMP
);

-- alter table activity_Log add activity_time TIMESTAMP
-- ALTER TABLE activity_Log ALTER COLUMN activity_time SET DEFAULT CURRENT_TIMESTAMP
