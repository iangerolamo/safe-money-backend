create table transacao(
    id bigint not null auto_increment,
    title varchar(255),
    category varchar(255),
    amount numeric(19,2),
    data date,
    primary key (id)
);

insert into transacao(title, category, amount, data)
values ('Salario', 'Revenue', 10000, '2023-11-30');

insert into transacao(title, category, amount, data)
values ('Aluguel', 'Bills & Utilities', 1100, '2023-11-30');

insert into transacao(title, category, amount, data)
values ('Seguro Carro', 'Bills & Utilities', 139, '2023-11-25');

insert into transacao(title, category, amount, data)
values ('Internet', 'Bills & Utilities', 69, '2023-11-25');

insert into transacao(title, category, amount, data)
values ('Gás', 'Bills & Utilities', 35, '2023-11-25');

insert into transacao(title, category, amount, data)
values ('Youtube Premium', 'Bills & Utilities', 22, '2023-11-25');

insert into transacao(title, category, amount, data)
values ('Koi Sushi', 'Food & Drinks', 50, '2023-11-25');

insert into transacao(title, category, amount, data)
values ('Conserto Geladeira', 'Others', 20, '2023-12-04');

insert into transacao(title, category, amount, data)
values ('Camiseta Insider', 'Shopping', 139, '2023-12-04');

