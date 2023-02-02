# 원티드 프리온보딩 Android 코스 사전과제

[News API](https://newsapi.org/) 를 활용하여 뉴스를 조회 및  저장, 삭제가 가능 한 뉴스 앱입니다.

# 🛠 Tech Stack

---

- Tool: Android Studio
- Language : Kotlin
- Navigation Conponent
- coroutine
- Android Architecture Components(AAC)
- Hilt
- Retrofit2
- Room
- GSON
- Serialization
- glide

# Package ****Structure****

---

```bash
.
├── data
│   ├── di
│   ├── local
│   │   ├── dao
│   │   ├── database
│   │   ├── entity
│   │   └── source
│   │
│   ├── repository
│   ├── source
│   └── remote
│       ├── api
│       ├── model
│       └── repository
│ 
├── domain
│   ├── model
│   ├── usecase
│   └── repository
│ 
│       
└── app
    ├── adapter
    │	├── diffutil
    │   └── viewholder
    ├── base
    ├── model
    ├── util
    └── ui
        ├── category
        ├── detail
        ├── main
        ├── top_news
        └── saved

```

### App

- app 모듈
- Android 플랫폼에 의존
- Activity, Context

### **Data**

- 데이터를 가져오고 저장하는 역할
- Repository implementation, DataSource

### **Domain**

- 핵심 비즈니스 로직
- Repository interface, UseCase

형식으로 최대한 ****Clean architecture****에 가깝도록 구현을 시도 해보았습니다.

# 구현

---

Top News Tab

<img width="412" alt="TopNews" src="https://user-images.githubusercontent.com/46774431/190103543-204d848b-ff79-4896-90bb-43f18a147009.png">

Category Tab

<img width="418" alt="Category" src="https://user-images.githubusercontent.com/46774431/190104004-31d75545-9ba7-438f-8173-697465a70b9f.png">

Saved Tab

<img width="399" alt="Saved1" src="https://user-images.githubusercontent.com/46774431/190104057-e1fa9bd7-65f1-4f61-8f1f-88c8d910b5bc.png">

- 바텀 네비게이션을 통하여 각 해당하는 메뉴를 이동 할수 있습니다.

## 카테고리 선택

<img width="410" alt="Category2" src="https://user-images.githubusercontent.com/46774431/190104536-ebb6e579-a4d6-47a3-b171-1a761d81ff31.png">

- 카테고리 탭에서 원하는 카테고리를 누르면 해당하는 테마의 기사들이 나옵니다.

## 저장

- 별모양 즐겨찾기 버튼을 눌렸을때 로컬에 저장하여 saved 탭에서도 나오는걸 확인 할 수 있습니다.

<img width="412" alt="Detail1" src="https://user-images.githubusercontent.com/46774431/190104747-02e7f3e8-db2c-4dc9-bd0e-e2fabe643d62.png">

<img width="399" alt="Saved1" src="https://user-images.githubusercontent.com/46774431/190104057-e1fa9bd7-65f1-4f61-8f1f-88c8d910b5bc.png">

- 즐겨찾기 버튼을 해제 했을 경우 로컬에 저장 되어 있는것이 삭제 되어 saved 탭에서 사라진것을 확인 할수 있습니다.

<img width="413" alt="Saved2" src="https://user-images.githubusercontent.com/46774431/190104753-bb570afe-e121-4a69-a5ad-ab5826952967.png">

<img width="415" alt="Detail2" src="https://user-images.githubusercontent.com/46774431/190104758-c10aa314-c4c7-4d26-b1e0-34b7fa3a6dd9.png">
