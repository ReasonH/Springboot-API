insert into ALBUM (id, title) values
    (1, 'album1'),
    (2, 'album2'),
    (3, 'album3'),
    (4, 'album4'),
    (5, 'album5'),
    (6, 'album6'),
    (7, 'album7'),
    (8, 'album8'),
    (9, 'album9'),
    (10, 'album10'),
    (11, 'album11'),
    (12, 'album12'),
    (13, 'album13');

insert into LOCALE_CODE (locale_id, locale, album_id) values
    (1, 'kr', 1),
    (2, 'jp', 1),
    (3, 'kr', 2),
    (4, 'all', 3),
    (5, 'all', 4),
    (6, 'all', 5),
    (7, 'all', 6),
    (8, 'all', 7),
    (9, 'all', 8),
    (10, 'all', 9),
    (11, 'all', 10),
    (12, 'all', 11),
    (13, 'ml', 12),
    (14, 'ek', 12),
    (15, 'us', 12),
    (16, 'haha', 13);

insert into SONG (id, title, track, length, album_id) values
    (1, 'hi1', 120, 130, 1),
    (2, 'hi2', 130, 140, 1),
    (3, 'hi3', 140, 160, 1),
    (4, 'hi4', 150, 170, 1),
    (5, 'albumid', 160, 170, 2),
    (6, 'all_song', 170, 180, 3),
    (7, 'albumid2', 160, 170, 4),
    (8, 'all_song2', 170, 180, 5),
    (9, 'albumid3', 160, 170, 6),
    (10, 'all_song4', 170, 180, 7),
    (11, 'albumid5', 160, 170, 8),
    (12, 'all_song6', 170, 180, 9),
    (13, 'albumid7', 160, 170, 10),
    (14, 'all_song8', 170, 180, 11),
    (15, 'albumid9', 160, 170, 12);

insert into PLAY_LIST (id, user_id, name) values
    (1, 'lyh1', 'test1'),
    (2, 'lyh1', 'test2'),
    (3, 'lyh1', 'test3');
