CREATE DATABASE recipes;
\c recipes;

CREATE USER dev WITH PASSWORD 'dev';
ALTER DATABASE recipes OWNER TO dev;
GRANT ALL PRIVILEGES ON DATABASE recipes TO dev;

\c recipes dev;

CREATE SCHEMA IF NOT EXISTS recipes;
GRANT USAGE ON SCHEMA recipes TO dev;
GRANT CREATE ON SCHEMA recipes TO dev;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA recipes TO dev;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA recipes TO dev;