-- Insert into publishers
insert into publishers (created_date, edited_date, address, contact_details, name)
values (now(), now(), 'www.bmg.com', 'This is a great service both for recording and music publishing', 'BMG'),
       (now(), now(), 'https://concord.com/',
        'They have incredible connections and know many influential people in the music industry', 'Concord');

-- Insert into genres
insert into genres (created_date, edited_date, name, description)
values (now(), now(), 'Soul', 'It is good for your soul'),
       (now(), now(), 'Jazz', 'Jazz hands and careless whispers'),
       (now(), now(), 'Rock', 'Everything louder than everything else'),
       (now(), now(), 'Metal', 'Witte wa ok kei-erg is...'),
       (now(), now(), 'Grunge', 'Sad Metal');

--Insert into artists
insert into artists (created_date, edited_date, name, biography)
values (now(), now(), 'The Beatles', 'The first boyband'),
       (now(), now(), 'Alice In Chains', 'De Acda en de Munnik van de Grunge'),
       (now(), now(), 'Black Sabbath', 'Metal Pioneers'),
       (now(), now(), 'Marvin Gaye', 'Whats going on'),
       (now(), now(), 'Miles Davis', 'The most influential trumpet player');

--Insert into albums
insert into albums (created_date, edited_date, title, release_year)
values (now(), now(), 'Help', 1965),
       (now(), now(), 'Dirt', 1992),
       (now(), now(), 'Paranoid', 1970),
       (now(), now(), 'Whats Going On', 1971),
       (now(), now(), 'So What', 1959);

--Insert into stock
insert into stock (created_date, edited_date, condition, price)
values (now(), now(), 'Near Mint', 49.95),
       (now(), now(), 'Lightly Played', 39.95),
       (now(), now(), 'New', 59.95),
       (now(), now(), 'For Decorative Use', 19.95),
       (now(), now(), 'Vintage', 99.95);