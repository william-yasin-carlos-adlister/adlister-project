USE wax_lister;

# This is IMPORTANT! Allows rollback  before committing any CRUD action
START TRANSACTION;

# mysql --local-infile=1 -u wbald -p
SET GLOBAL local_infile = 1;

DELETE FROM albums;
DELETE FROM artists;
DELETE FROM genres;

ALTER TABLE albums
ADD COLUMN artist_name_dum varchar(250) NOT NULL;

LOAD DATA LOCAL INFILE '/Users/williambaldridge/IdeaProjects/adlister-project/data/Artists.csv'
    INTO TABLE artists
    FIELDS TERMINATED BY ',' (name);

LOAD DATA LOCAL INFILE '/Users/williambaldridge/IdeaProjects/adlister-project/data/genre.csv'
    INTO TABLE genres
    FIELDS TERMINATED BY ',' (name);

LOAD DATA LOCAL INFILE '/Users/williambaldridge/IdeaProjects/adlister-project/data/albums.csv'
    INTO TABLE albums
    FIELDS TERMINATED BY ',' (title, artist_name_dum);


# Both Replace functions used to remove all double quotes from values
UPDATE albums
SET artist_name_dum = REPLACE(artist_name_dum, '"', '');

# ROLLBACK;

UPDATE albums
SET title = REPLACE(title, '"', '');

# ROLLBACK;

# Sets artist_id (foreign) on albums table to artist id (primary) from artists table
UPDATE albums
SET artist_id = (
    SELECT a.id FROM artists a
    WHERE albums.artist_name_dum = a.name
);

# ROLLBACK;

# Removes null artist_id values

DELETE FROM albums
WHERE artist_id is null;

# ROLLBACK;

# Removes artist name dummy column from import

ALTER TABLE albums
    DROP COLUMN artist_name_dum;

# ROLLBACK;


# Was in case foreign key was not set, was not needed
# START TRANSACTION;
#
# ALTER TABLE albums
# ADD CONSTRAINT FOREIGN KEY albums_artistId (artist_id)
# REFERENCES artists (id);

# Checks data import and clean is correct
SELECT a.artist_id, a.title, ar.id, ar.name
FROM artists ar
         JOIN albums a on ar.id = a.artist_id
WHERE ar.id = a.artist_id
ORDER BY artist_id;

# ROLLBACK;
# COMMIT;