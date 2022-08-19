BEGIN TRANSACTION;
DROP TABLE IF EXISTS activeBaseballTeams CASCADE;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
        user_id serial not Null, 
        username varchar(50) Not Null, 
        password_hash varchar(200) not null,
        role varchar(50)not null
);

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

ALTER SEQUENCE activeBaseballTeams_team_id_seq
        OWNED BY activeBaseballTeams.team_id;

COMMIT TRANSACTION;
