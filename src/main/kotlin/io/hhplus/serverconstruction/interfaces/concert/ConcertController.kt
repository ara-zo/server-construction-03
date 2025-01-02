package io.hhplus.serverconstruction.interfaces.concert

import io.hhplus.serverconstruction.domain.concert.ConcertGradeType
import io.hhplus.serverconstruction.domain.concert.ConcertSeatStatusType
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertListDto
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertScheduleDto
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertSeatListDto
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
    ): ResponseEntity<List<ConcertListDto>> {
        val list = listOf(
            ConcertListDto(
                concertId = 1L,
                name = "홍길동의 TDD 콘서트",
                singer = "홍길동",
                location = "코엑스",
                reservationStartDate = LocalDateTime.of(2024, 10, 10, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 10, 11, 13, 0, 0),
                concertStartDate = LocalDateTime.of(2024, 11, 10, 13, 0, 0),
                concertEndDate = LocalDateTime.of(2024, 11, 10, 14, 0, 0)
            ),
            ConcertListDto(
                concertId = 2L,
                name = "홍길동의 클린아키텍쳐 콘서트",
                singer = "홍길동",
                location = "코엑스",
                reservationStartDate = LocalDateTime.of(2024, 10, 10, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 10, 11, 13, 0, 0),
                concertStartDate = LocalDateTime.of(2024, 11, 10, 13, 0, 0),
                concertEndDate = LocalDateTime.of(2024, 11, 10, 14, 0, 0)
            )
        )
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{concertId}/schedules")
    fun findConcertSchedulesList(
        @RequestHeader("token") token: String,
        @PathVariable("concertId") concertId: Long
    ): ResponseEntity<List<ConcertScheduleDto>> {
        val list = listOf(
            ConcertScheduleDto(
                concertScheduleId = 1L,
                concertId = 1L,
                reservationStartDate = LocalDateTime.of(2024, 10, 10, 13, 0, 0),
                reservationEndDate = LocalDateTime.of(2024, 10, 11, 13, 0, 0),
                concertStartTime = LocalDateTime.of(2024, 11, 11, 13, 0, 0),
                concertEndTime = LocalDateTime.of(2024, 11, 11, 14, 0, 0),
            )
        )
        return ResponseEntity.ok(list)
    }

    @GetMapping("/{concertId}/schedules/{concertScheduleId}/seats")
    fun findConcertSeatList(
//        @RequestHeader("token") token: String,
        @PathVariable("concertId") concertId: Long,
        @PathVariable("concertScheduleId") concertScheduleId: Long,
    ): ResponseEntity<List<ConcertSeatListDto>> {
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
        return ResponseEntity.ok(list)
    }
}