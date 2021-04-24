USE wax_lister;

DROP TABLE IF EXISTS wax_genre;
DROP TABLE IF EXISTS wax_ads;
DROP TABLE IF EXISTS albums;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS genres;
DROP TABLE IF EXISTS users;


CREATE TABLE users
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(240) NOT NULL,
    email    VARCHAR(240) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_admin BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (id)
);

CREATE TABLE genres
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(240) NOT NULL DEFAULT 'Yeezy',
    PRIMARY KEY (id)
);

CREATE TABLE artists
(
    id   INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name varchar(200) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE albums
(
    id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title     varchar(240) NOT NULL,
    artist_id INT UNSIGNED,
    price DECIMAL (6, 2) NOT NULL DEFAULT 15.99,
    FOREIGN KEY (artist_id) REFERENCES artists (id),
    PRIMARY KEY (id)
);

CREATE TABLE wax_ads
(
    id          INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id     INT UNSIGNED NOT NULL,
    artist_id   INT UNSIGNED NOT NULL,
    album_id    INT UNSIGNED NOT NULL,
    ad_title    VARCHAR(240) NOT NULL,
    description TEXT         NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (artist_id) REFERENCES artists (id),
    FOREIGN KEY (album_id) REFERENCES albums (id)
        ON DELETE CASCADE

);

CREATE TABLE wax_genre
(
    wax_ad_id INT UNSIGNED NOT NULL,
    genre_id  INT UNSIGNED NOT NULL,
    FOREIGN KEY (wax_ad_id) REFERENCES wax_ads (id),
    FOREIGN KEY (genre_id) REFERENCES genres (id)
);