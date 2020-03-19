## Spring-Boot를 활용한 API 구현 <a id="top"></a>

스프링 부트 연습용도로 시작했던 프로그래머스의 FLO Back-End 챌린지 과제입니다. (자세한 사항은 [명세서](https://www.notion.so/a0b87935288d4b809956230b4f8e3874)를 참조)

개발환경은 다음과 같습니다.

- IDE: IntelliJ
- Spring-Boot: 2.2.5
- Gradle: 6.0.1
- JAVA: jdk1.8
- DB: H2
- 기타: JPA 및 Querydsl 사용

### 요구 API

---

    [{
    		"album_title": "Please Please Me (1963.3)",
    		"locales": [
    			"en",
    			"ja"
    		],
    		"songs": [{
    				"length": 224,
    				"title": "Please Please Me (1963.3) song-1",
    				"track": 1
    			},
    			{
    				"length": 454,
    				"title": "Please Please Me (1963.3) song-2",
    				"track": 2
    			}
    		]
    	},
    	{
    		"album_title": "With The Beatles (1963.11)",
    		"locales": [
    			"en",
    			"ja"
    		],
    		"songs": [{
    				"length": 114,
    				"title": "With The Beatles (1963.11) song-1",
    				"track": 1
    			}
    		]
    	}]

[샘플 데이터] : [https://gist.github.com/programmers-gitbot/8a8f20aa4bfcb6d76c58efca7d7c4c53](https://gist.github.com/programmers-gitbot/8a8f20aa4bfcb6d76c58efca7d7c4c53)

위 데이터는 다음 API 들의 기본이 되는 데이터입니다.

1. [앨범/곡 검색](#albumsong)
2. [앨범 리스트 조회](#albumlist)
3. [플레이리스트 생성](#createplaylist)
4. [플레이리스트에 곡/앨범 추가](#updateplaylist)
5. [플레이리스트 목록 조회](#displayplaylist)
6. [플레이리스트 삭제](#deleteplaylist)

### 1. 앨범/곡 검색 `GET /search` <a id="albumsong"></a>

---

`curl --location --request GET '[http://localhost:8080/search?title=album1&locale=kr](http://localhost:8080/search?title=album1&locale=kr)'`

[Params](https://www.notion.so/35ac048f8b674c378b6cd550aef0688a)

    {
        "albums": [
            {
                "id": 1,
                "title": "album1",
                "songs": [
                    {
                        "id": 1,
                        "title": "test1",
                        "track": 120,
                        "length": 130
                    },
                    {
                        "id": 2,
                        "title": "test2",
                        "track": 130,
                        "length": 140
                    },
                    {
                        "id": 3,
                        "title": "test3",
                        "track": 140,
                        "length": 160
                    },
                    {
                        "id": 4,
                        "title": "test4",
                        "track": 150,
                        "length": 170
                    }
                ]
            },
            {
                "id": 10,
                "title": "album10",
                "songs": [
                    {
                        "id": 13,
                        "title": "test13",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 11,
                "title": "album11",
                "songs": [
                    {
                        "id": 14,
                        "title": "test14",
                        "track": 170,
                        "length": 180
                    }
                ]
            }
        ],
        "songs": []
    }

### 2. 앨범 리스트 조회`GET /albums` <a id="albumlist"></a>

---

[`http://localhost:8080/albums?page=1&locale=kr`](http://localhost:8080/albums?page=1&locale=kr)

[Params](https://www.notion.so/002a43f016814bc9a22a4f4b3609e366)

    {
        "pages": {
            "first": null,
            "prev": null,
            "last": null,
            "next": null
        },
        "content": [
            {
                "id": 1,
                "title": "album1",
                "songs": [
                    {
                        "id": 1,
                        "title": "test1",
                        "track": 120,
                        "length": 130
                    },
                    {
                        "id": 2,
                        "title": "test2",
                        "track": 130,
                        "length": 140
                    },
                    {
                        "id": 3,
                        "title": "test3",
                        "track": 140,
                        "length": 160
                    },
                    {
                        "id": 4,
                        "title": "test4",
                        "track": 150,
                        "length": 170
                    }
                ]
            },
            {
                "id": 2,
                "title": "album2",
                "songs": [
                    {
                        "id": 5,
                        "title": "test5",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 3,
                "title": "album3",
                "songs": [
                    {
                        "id": 6,
                        "title": "test6",
                        "track": 170,
                        "length": 180
                    }
                ]
            },
            {
                "id": 4,
                "title": "album4",
                "songs": [
                    {
                        "id": 7,
                        "title": "test7",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 5,
                "title": "album5",
                "songs": [
                    {
                        "id": 8,
                        "title": "test8",
                        "track": 170,
                        "length": 180
                    }
                ]
            },
            {
                "id": 6,
                "title": "album6",
                "songs": [
                    {
                        "id": 9,
                        "title": "test9",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 8,
                "title": "album8",
                "songs": [
                    {
                        "id": 11,
                        "title": "test11",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 9,
                "title": "album9",
                "songs": [
                    {
                        "id": 12,
                        "title": "test12",
                        "track": 170,
                        "length": 180
                    }
                ]
            },
            {
                "id": 10,
                "title": "album10",
                "songs": [
                    {
                        "id": 13,
                        "title": "test13",
                        "track": 160,
                        "length": 170
                    }
                ]
            },
            {
                "id": 11,
                "title": "album11",
                "songs": [
                    {
                        "id": 14,
                        "title": "test14",
                        "track": 170,
                        "length": 180
                    }
                ]
            }
        ]
    }

### 3. 플레이리스트 생성 `POST/playlists` <a id="createplaylist"></a>

---

`curl --location --request PUT 'http://localhost:8080/playlists' \
--data-raw '{	"userId": "reasonH",	"name": "test"
}`

### 4. 플레이리스트에 곡/앨범 추가 `PUT /playlists/{userid}/lists/{name}` <a id="updateplaylist"></a>

---

**곡 추가**

`curl --location --request PUT 'http://localhost:8080/playlists/lyh1/lists/test1?type=SONG' \
--data-raw '{	"title": "hi1",	"locale": "kr"
}'`

    {
        "userId": "lyh1",
        "name": "test1",
        "songs": [
            {
                "id": 1,
                "title": "hi1",
                "track": 120,
                "length": 130
            },
            {
                "id": 1,
                "title": "hi1",
                "track": 120,
                "length": 130
            },
            {
                "id": 2,
                "title": "hi2",
                "track": 130,
                "length": 140
            },
            {
                "id": 3,
                "title": "hi3",
                "track": 140,
                "length": 160
            },
            {
                "id": 4,
                "title": "hi4",
                "track": 150,
                "length": 170
            },
            {
                "id": 1,
                "title": "hi1",
                "track": 120,
                "length": 130
            }
        ]
    }

**앨범 추가**

`curl --location --request PUT 'http://localhost:8080/playlists/lyh1/lists/test1?type=ALBUM' \
--data-raw '{	"title": "album1",	"locale": "kr"
}'`

    {
        "userId": "lyh1",
        "name": "test1",
        "songs": [
            {
                "id": 1,
                "title": "hi1",
                "track": 120,
                "length": 130
            },
            {
                "id": 1,
                "title": "hi1",
                "track": 120,
                "length": 130
            },
            {
                "id": 2,
                "title": "hi2",
                "track": 130,
                "length": 140
            },
            {
                "id": 3,
                "title": "hi3",
                "track": 140,
                "length": 160
            },
            {
                "id": 4,
                "title": "hi4",
                "track": 150,
                "length": 170
            }
        ]
    }

### 5. 플레이리스트 목록 조회 `GET /playlists/{userid}` <a id="displayplaylist"></a>

---

`curl --location --request GET 'http://localhost:8080/playlists/lyh1' \
--data-raw ''`

    [
        {
            "userId": "lyh1",
            "name": "test1",
            "songs": [
                {
                    "id": 1,
                    "title": "hi1",
                    "track": 120,
                    "length": 130
                },
                {
                    "id": 1,
                    "title": "hi1",
                    "track": 120,
                    "length": 130
                },
                {
                    "id": 2,
                    "title": "hi2",
                    "track": 130,
                    "length": 140
                },
                {
                    "id": 3,
                    "title": "hi3",
                    "track": 140,
                    "length": 160
                },
                {
                    "id": 4,
                    "title": "hi4",
                    "track": 150,
                    "length": 170
                },
                {
                    "id": 1,
                    "title": "hi1",
                    "track": 120,
                    "length": 130
                }
            ]
        },
        {
            "userId": "lyh1",
            "name": "test2",
            "songs": []
        },
        {
            "userId": "lyh1",
            "name": "test3",
            "songs": []
        }
    ]

### 6. 플레이리스트 삭제 `DELETE /playlists/{userid}/lists/{name}` <a id="deleteplaylist"></a>

---

`curl --location --request DELETE '[http://localhost:8080/playlists/lyh1/lists/test3](http://localhost:8080/playlists/lyh1/lists/test3)'`

### 개선점

1. DTO 내에서 inner class 사용하여 클래스 갯수를 줄일 수 있다.
2. Album 과 Locale 사이 관계 테이블을 만들어 locale 정보의 중복 저장을 없앨 수 있다.
3. Hateoas를 통해 pagination link를 가져오되 링크를 알맞게 가공할 방법 고안
    - Hateoas url은 0부터 시작하기 때문에 요구사항에 부합하지 않았다.
    - 따라서 현재는 current url을 기준으로 링크를 생성하는 방식이다.
4. **Test code 작성 필요**

##### [맨 위로이동](#top)