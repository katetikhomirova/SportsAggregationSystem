CREATE TABLE role (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE users (
  email         VARCHAR(50) PRIMARY KEY,
  name          VARCHAR(150) NOT NULL,
  password_hash VARCHAR(200) NOT NULL,
  role_id       INTEGER REFERENCES role (id)
);

CREATE TABLE type_of_clothing (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE kind_of_clothing (
  id      SERIAL PRIMARY KEY,
  type_id INTEGER REFERENCES type_of_clothing (id),
  name    VARCHAR(100) NOT NULL
);

CREATE TABLE brand (
  id        SERIAL PRIMARY KEY,
  name      VARCHAR(100) NOT NULL
);

CREATE TABLE set (
  id          SERIAL PRIMARY KEY,
  name        VARCHAR(100) NOT NULL,
  description VARCHAR(300) NOT NULL
);

CREATE TABLE season (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(50) NOT NULL
);

CREATE TABLE set_season (
  set_season_id SERIAL PRIMARY KEY,
  set_id        INTEGER REFERENCES set (id),
  season_id     INTEGER REFERENCES season (id)
);

CREATE TABLE event (
  id   SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

CREATE TABLE set_event (
  set_event_id SERIAL PRIMARY KEY,
  set_id       INTEGER REFERENCES set (id),
  event_id     INTEGER REFERENCES event (id)
);

CREATE TABLE thing (
  id                  SERIAL PRIMARY KEY,
  user_email          VARCHAR(50) REFERENCES users (email),
  kind_of_clothing_id INTEGER REFERENCES kind_of_clothing (id),
  brand_id            INTEGER REFERENCES brand (id),
  main_color_hex      VARCHAR(10) NOT NULL,
  note                VARCHAR(100),
  set_id              INTEGER REFERENCES set (id),
  rate                INTEGER
);
