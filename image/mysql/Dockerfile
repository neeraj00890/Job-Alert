FROM docker:latest
RUN docker run --name=mysql-docker -p 3306:3306 -e MYSQL_ROOT_HOST='%' -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker_db -d mysql/mysql-server:8.0