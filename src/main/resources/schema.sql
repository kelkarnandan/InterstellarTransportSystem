create schema INTERSTELLAR_TRANSPORT;

DROP TABLE IF EXISTS PLANET_NAME;

CREATE TABLE PLANET_NAME (
    planet_node varchar(255) NOT NULL,
    planet_name varchar(255) NOT NULL,
    PRIMARY KEY (planet_node)
);

DROP TABLE IF EXISTS ROUTE;

CREATE TABLE ROUTE (
    route_id int NOT NULL AUTO_INCREMENT,
    planet_origin varchar(255) NOT NULL,
    planet_desitnation varchar(255) NOT NULL,
    planet_Distance DOUBLE, 
    PRIMARY KEY (route_id)
);

DROP TABLE IF EXISTS TRAFFIC;

CREATE TABLE TRAFFIC (
    traffic_id int NOT NULL AUTO_INCREMENT,
    planet_origin varchar(255) NOT NULL,
    planet_desitnation varchar(255) NOT NULL,
	traffic DOUBLE,
    PRIMARY KEY (traffic_id)
);