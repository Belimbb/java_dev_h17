-- add default user --
insert into users (username, password, email, last_updated_date, created_date)
values ('user', 'jdbcDefault', 'some_user_email@gmail.com', CURRENT_DATE, CURRENT_DATE);