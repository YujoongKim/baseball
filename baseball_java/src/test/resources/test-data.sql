ROLLBACK;
BEGIN TRANSACTION;
DROP TABLE IF EXISTS activeBaseballTeams;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE activeBaseballTeams (
	team_id serial Primary Key,
	key varchar(50) Not Null,
	active boolean Not Null,
	city varchar(50) Not Null,
	name varchar(50) Not Null,
	stadium_id int,
	league varchar(50) Not Null,
	division varchar(50) Not Null,
	primary_color varchar(50),
	secondary_color varchar(50),
	tertiary_color varchar(50),
	quaternary_color varchar(50),
	wikipedia_logo_url varchar(200),
	wikipedia_word_mark_url varchar(200),
	global_team_id int

);
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

ALTER SEQUENCE activeBaseballTeams_team_id_seq
        OWNED BY activeBaseballTeams.team_id;

COMMIT TRANSACTION;