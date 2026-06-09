-- Insert into genres
insert into genres (created_date, edited_date, name, description)
values (now(), now(), 'Soul', 'It is good for your soul'),
       (now(), now(), 'Jazz', 'Jazz hands and careless whispers'),
       (now(), now(), 'Rock', 'Everything louder than everything else'),
       (now(), now(), 'Metal', 'Witte wa ok kei-erg is...'),
       (now(), now(), 'Grunge', 'Sad Metal');

-- Insert into publishers
insert into publishers (created_date, edited_date, address, contact_details, name)
values (now(), now(), 'www.bmg.com', 'This is a great service both for recording and music publishing', 'BMG'),
       (now(), now(), 'https://concord.com/',
        'They have incredible connections and know many influential people in the music industry', 'Concord'),
       (now(), now(), 'https://www.parlophonerecords.com/', 'Home of The Beatles', 'Parlophone'),
       (now(), now(), 'https://www.columbiarecords.com/', 'Part of Sony Entertainment', 'Columbia'),
       (now(), now(), 'http://www.vertigorecords.com', 'Classic rock record label', 'Vertigo'),
       (now(), now(), 'https://motownrecords.com/', 'Home of soul', 'Motown');

--Insert into albums
insert into albums (created_date, edited_date, title, release_year, genre_id, publisher_id)
values (now(), now(), 'Help', 1965, 3, 3),
       (now(), now(), 'Dirt', 1992, 5, 4),
       (now(), now(), 'Paranoid', 1970, 4, 5),
       (now(), now(), 'Whats Going On', 1971, 1, 6),
       (now(), now(), 'So What', 1959, 2, 4);

--Insert into artists
insert into artists (created_date, edited_date, name, biography)
values (now(), now(), 'The Beatles', 'The first boyband'),
       (now(), now(), 'Alice In Chains', 'De Acda en de Munnik van de Grunge'),
       (now(), now(), 'Black Sabbath', 'Metal Pioneers'),
       (now(), now(), 'Marvin Gaye', 'Whats going on'),
       (now(), now(), 'Miles Davis', 'The most influential trumpet player');

--Insert into stock
insert into stock (created_date, edited_date, condition, price, album_id)
values (now(), now(), 'Near Mint', 49.95, 1),
       (now(), now(), 'Lightly Played', 39.95, 4),
       (now(), now(), 'New', 59.95, 2),
       (now(), now(), 'For Decorative Use', 19.95, 3),
       (now(), now(), 'Vintage', 99.95, 5);

--Insert into album_artist
insert into album_artist (artist_id, album_id)
values (1, 1),
       (2, 2),
       (3, 3),
       (4, 4),
       (5, 5);