FROM postgres
COPY db.sql /docker-entrypoint-initdb.d/
RUN chown postgres:postgres /docker-entrypoint-initdb.d/*.sql
RUN chmod +x /usr/local/bin/docker-entrypoint.sh

# ENV POSTGRES_USER=dev
ENV POSTGRES_PASSWORD=dev
