# API 명세

---

## GET /waiting/check - 대기열 체크

- Description
    - 헤더에 토큰이 없다면 신규 토큰 발급
- Header
    - token: 대기열 토큰
- Response

```
  {
    "token": "String - 토큰",
    "status": "enum - 대기열 상태"
  }
```

## GET /concerts - 콘서트 조회

- Description
    - 콘서트 목록 조회
- Header
    - token: 대기열 토큰
- Response
  ```
  [
    {
      "concertId": "long - 콘서트 아이디",
      "name": "String - 콘서트 이름",
      "singer": "String - 가수",
      "location": "String - 장소",
      "reservationStartDate": "LocalDateTime - 예약 가능 시작 일시",
      "reservationEndDate": "LocalDateTime - 예약 가능 종료 일시",
      "concertStartDate": "LocalDateTime - 콘서트 시작 날짜",
      "concertEndDate": "LocalDateTime - 콘서트 종료 날짜"
    }
  ]
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |

## GET /concerts/{concertId}/schedules - 콘서트 예약가능 날짜 조회 API

- Description
    - 콘서트 예약가능 날짜 조회
- Header
    - token: 대기열 토큰
- PathVariable
    - concertId : 콘서트 Id
- Response
  ```
    [
      {
        "concertScheduleId": "long - 콘서트 스케쥴 Id",
        "concertId": "long - 콘서트 아이디",
        "reservationStartDate": "LocalDateTime - 예약 가능 시작 일시",
        "reservationEndDate": "LocalDateTime - 예약 가능 종료 일시",
        "concertStartTime": "LocalDateTime - 콘서트 시작 시간",
        "concertEndTime": "LocalDateTime - 콘서트 종료 시간"
      }
    ]
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |

## GET /concerts/{concertId}/schedules/{concertScheduleId}/seats - 예약 가능 좌석 조회

- Description
    - 콘서트의 좌석 조회
- Header
    - token: 대기열 토큰
- PathVariable
    - concertId: 콘서트 Id
    - concertScheduleId: 콘서트 스케쥴 Id
- Response
  ```
    [
      {
        "concertSeatId": "long - 콘서트 좌석 Id",
        "seatNum": "String - 좌석 번호"
        "grade": "enum - 좌석 등급",
        "price": "decimal - 가격",
        "status": "enum - 좌석 상태 (임시배정, 예약, 예약가능)"
      }
    ]
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |

## POST /reservations - 좌석 예약

- Description
    - 콘서트 좌석 예약
- Header
    - token: 대기열 토큰
- Request Body
  ```
  {
      "concertId":  "long - 콘서트 Id",
      "concertScheduleId": "long - 콘서트 스케쥴 Id",
      "concertSeatId": "long - 콘서트 좌석 Id",
      "userId": "long - 사용자 Id"
  }
  ``` 
- Response
  ```
      {
        "reservationId": "long - 예약 Id",
        "concertSeatId": "long - 콘서트 좌석 Id",
        "seatNum": "String - 좌석 번호",
        "price": "decimal - 결제금액"
      }
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |
| INVALID_SEAT  | 유효하지 않은 좌석 |

## GET /users/{userId}/amount - 잔액 조회

- Description
    - 잔액 조회
- Header
    - token: 대기열 토큰
- PathVariable
    - userId: 사용자 Id
- Response
  ```
      {
        "amount": "decimal - 잔액"
      }
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |

## PATCH /users/{userId}/charge - 잔액 충전

- Description
    - 잔액 충전
- Header
    - token: 대기열 토큰
- PathVariable
    - userId: 사용자 Id
- Request Body
  ```
  {
      "amount": "decimal - 충전 금액"
  }
  ```
- Response Body
  ```
      {
        "amount": "decimal - 잔액"
      }
  ```
- Error

| Code          | Message    |
|---------------|------------|
| INVALID_TOKEN | 유효하지 않은 토큰 |

## POST /reservation/payment - 결제

- Description
    - 결제
- Header
    - token: 대기열 토큰
- Request Body
  ```
  {
      "userId": "long - 사용자 Id",
      "reservationPaymentId": "long - 결제 Id"
  }
  ```
- Response Body
  ```
  {
    "reservationPaymentId": "long - 결제 Id",
    "status": "enum - 결제 상태",
    "price": "decimal - 결제 금액",
    "amount": "decimal - 잔액"
  }
  ```
- Error

| Code              | Message    |
|-------------------|------------|
| INVALID_TOKEN     | 유효하지 않은 토큰 |
| INVALID_SEAT      | 유효하지 않은 좌석 |
| NOT_ENOUGH_AMOUNT | 잔액 부족      |