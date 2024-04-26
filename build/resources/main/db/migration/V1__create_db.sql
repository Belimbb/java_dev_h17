-- create tables --
create table public.note (
    id bigint primary key,
    title varchar not null,
    content varchar
);

-- create sequences --
create sequence note_seq start with 1;

-- set sequences --
alter table public.note alter column id set default nextval('note_seq');
