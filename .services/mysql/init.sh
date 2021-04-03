#!/bin/bash

set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL

    CREATE DATABASE sige-erp WITH ENCODING = 'UTF8' CONNECTION LIMIT = -1;
    REVOKE CREATE ON SCHEMA public FROM PUBLIC;
    REVOKE ALL ON DATABASE sige-erp FROM PUBLIC;

    CREATE USER postgres WITH PASSWORD 'Postgres2018';
    GRANT CONNECT ON DATABASE sige-erp TO postgres;

    CREATE USER migrations WITH PASSWORD 'migrations';
    GRANT CONNECT ON DATABASE sige-erp TO migrations;

    ALTER DATABASE sige-erp OWNER TO postgres;
    GRANT postgres TO migrations;

    \c sige-erp;

    CREATE SCHEMA liquibase AUTHORIZATION migrations;
    GRANT USAGE, CREATE ON SCHEMA liquibase TO migrations;
    GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA liquibase TO migrations;
    ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase GRANT SELECT, INSERT, UPDATE, DELETE ON TABLES TO migrations;
    GRANT USAGE ON ALL SEQUENCES IN SCHEMA liquibase TO migrations;
    ALTER DEFAULT PRIVILEGES IN SCHEMA liquibase GRANT USAGE ON SEQUENCES TO migrations;

    CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

EOSQL
