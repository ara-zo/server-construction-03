# 기술 스택

- 프로그래밍 언어: Kotlin
- 프레임워크: Spring Boot
- 데이터베이스: MySql, H2
- ORM: JPA (Java Persistence API)
- 쿼리 빌더: QueryDSL
- 테스트: JUnit, AssertJ

---

# 패키지 구조

---

```
├── application 
│   │ (도메인 계층의 서비스들을 조합해 애플리케이션의 흐름 관리)
│   ├── concert
│   │   ├── dto
│   │   └── facade
│   ├── amount
│   │   ├── dto
│   │   └── facade
│   ├── payment
│   │   ├── dto
│   │   └── facade
│   ├── reservation
│   │   ├── dto
│   │   └── facade
│   └── user
│   │   └── facade
│   └── waiting
│       ├── dto
│       └── facade
│   
├── domain 
│   │ (애플리케이션의 핵심 비즈니스 로직과 규칙이 위치하는 계층, 비즈니스 도메인에 대한 이해 반영하고, 각 서비스가 도메인 객체를 통해 지브니스 로직 수행)  
│   ├── concert
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   ├── payment
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   ├── reservation
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   ├── user
│   │   ├── exception
│   │   ├── repository
│   │   └── service
│   └── waiting
│       ├── exception
│       ├── repository
│       └── service
│
├── infra
│   │ (실제 데이터베이스와의 상호작용 담당, 도메인 계층과 분리되어 있으며, 영속성 관련 코드를 포함)
│   ├── concert
│   │   ├── entity
│   │   └── mapper
│   ├── payment
│   │   ├── entity
│   │   └── mapper
│   ├── reservation
│   │   ├── entity
│   │   └── mapper
│   ├── waiting
│   │   ├── entity
│   │   └── mapper
│   └── user
│       ├── entity
│       └── mapper
│
├── interfaces
│   │ (외부와의 상호작용을 담당하는 계층, 사용자의 요청을 받아 애플리케이션 계층으로 전달하고, 응답을 생성하여 반환하는 역할함)
│   ├── controller
│   │   ├── concert
│   │   │   └── dto
│   │   ├── payment
│   │   │   └── dto
│   │   ├── reservation
│   │   │   └── dto
│   │   ├── waiting
│   │   │   └── dto
│   │   └── user
│   │       └── dto
│   └── scheduler
│
└── support
    │ (애플리케이션의 전반적인 환경 설정과 공통적으로 처리해야하는 기능을 포함하는 계층)
    ├── config
    ├── exception
    └── handler

```
