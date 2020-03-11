insert into ALBUM (id, title) values
    (1, 'album1');

insert into LOCALE_CODE (locale_id, locale, album_id) values
    (1, 'kr', 1),
    (2, 'jp', 1);

insert into SONG (id, title, track, length, album_id) values
    (1, 'hi1', 120, 130, 1),
    (2, 'hi2', 130, 140, 1),
    (3, 'hi3', 140, 160, 1),
    (4, 'hi4', 150, 170, 1);