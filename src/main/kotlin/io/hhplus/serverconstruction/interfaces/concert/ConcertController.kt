package io.hhplus.serverconstruction.interfaces.concert

import io.hhplus.serverconstruction.domain.concert.ConcertGradeType
import io.hhplus.serverconstruction.domain.concert.ConcertSeatStatusType
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertListDto
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertScheduleDto
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertSeatListDto
import io.hhplus.serverconstruction.interfaces.error.dto.ErrorDto
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.time.LocalDateTime

@RestController
@RequiredArgsConstructor
@RequestMapping("/concerts")
class ConcertController {

    @GetMapping
    fun findConcertList(
        @RequestHeader("token") token: String,
    ): ResponseEntity<Any> {
        val list = listOf(
            ConcertListDto(
                concertId = 1L,
                name = "홍길동의 TDD 콘서트",
                singer = "홍길동",
                location = "코엑스",
                reservationStartDate = LocalDateTime.of(2024, 12, 28, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 12, 29, 13, 0, 0),
                concertStartDate = LocalDateTime.of(2025, 1, 2,  13, 0, 0),
                concertEndDate = LocalDateTime.of(2025, 1, 2, 14, 0, 0)
            ),
            ConcertListDto(
                concertId = 2L,
                name = "홍길동의 클린아키텍쳐 콘서트",
                singer = "홍길동",
                location = "코엑스",
                reservationStartDate = LocalDateTime.of(2024, 12, 28, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 12, 29, 13, 0, 0),
                concertStartDate = LocalDateTime.of(2025, 1, 2,  13, 0, 0),
                concertEndDate = LocalDateTime.of(2025, 1, 2, 14, 0, 0)
            )
        )

        return when(token) {
            "valid_token" -> ResponseEntity.ok(list)

            "invalid_token" -> {
                ResponseEntity.badRequest().body(
                    ErrorDto(
                        "INVALID_TOKEN",
                        "유효하지 않은 토큰"
                    )
                )
            }

            else -> {
                ResponseEntity.internalServerError().body(
                    ErrorDto(
                        "INTERNAL_SERVER_ERROR",
                        "토큰 체크 실패"
                    )
                )
            }
        }
    }

    @GetMapping("/{concertId}/schedules")
    fun findConcertSchedulesList(
        @RequestHeader("token") token: String,
        @PathVariable("concertId") concertId: Long
    ): ResponseEntity<Any> {
        val list = listOf(
            ConcertScheduleDto(
                concertScheduleId = 1L,
                concertId = 1L,
                reservationStartDate = LocalDateTime.of(2024, 12, 28, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 12, 29, 13, 0, 0),
                concertStartTime = LocalDateTime.of(2025, 1, 2, 13, 0, 0),
                concertEndTime = LocalDateTime.of(2025, 1, 2, 14, 0, 0),
            )
        )
        return when (token) {
            "valid_token" -> {
                if(concertId == 1L) {
                    ResponseEntity.ok(list)
                } else {
                    ResponseEntity.ok(null)
                }
            }
            "invalid_token" -> {
                ResponseEntity.badRequest().body(
                    ErrorDto(
                        "INVALID_TOKEN",
                        "유효하지 않은 토큰"
                    )
                )
            }

            else -> {
                ResponseEntity.internalServerError().body(
                    ErrorDto(
                        "INTERNAL_SERVER_ERROR",
                        "토큰 체크 실패"
                    )
                )
            }
        }
    }

    @GetMapping("/{concertId}/schedules/{concertScheduleId}/seats")
    fun findConcertSeatList(
        @RequestHeader("token") token: String,
        @PathVariable("concertId") concertId: Long,
        @PathVariable("concertScheduleId") concertScheduleId: Long,
    ): ResponseEntity<Any> {
        val list = listOf(
            ConcertSeatListDto(
                concertSeatId = 1L,
                seatNum = "1번",
                grade = ConcertGradeType.GOLD,
                price = BigDecimal("10000"),
                status = ConcertSeatStatusType.AVAILABLE
            ),
            ConcertSeatListDto(
                concertSeatId = 2L,
                seatNum = "2번",
                grade = ConcertGradeType.GOLD,
                price = BigDecimal("10000"),
                status = ConcertSeatStatusType.AVAILABLE
            )
        )
        return when(token) {
            "valid_token" -> {
                if(concertId != 1L) {
                    ResponseEntity.ok(null)
                } else {
                    if(concertScheduleId == 1L) {
                        ResponseEntity.ok(list)
                    } else {
                        ResponseEntity.ok(null)
                    }
                }
            }
            "invalid_token" -> {
                ResponseEntity.badRequest().body(
                    ErrorDto(
                        "INVALID_TOKEN",
                        "유효하지 않은 토큰"
                    )
                )
            }

            else -> {
                ResponseEntity.internalServerError().body(
                    ErrorDto(
                        "INTERNAL_SERVER_ERROR",
                        "토큰 체크 실패"
                    )
                )
            }
        }
    }
}