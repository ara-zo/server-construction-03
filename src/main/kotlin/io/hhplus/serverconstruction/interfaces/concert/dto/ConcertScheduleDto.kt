package io.hhplus.serverconstruction.interfaces.concert.dto

import java.time.LocalDateTime

class ConcertScheduleDto(
    val concertScheduleId: Long,
    val concertId: Long,
    val reservationStartDate: LocalDateTime,
    val reservationEndDate: LocalDateTime,
    val concertStartTime: LocalDateTime,
    val concertEndTime: LocalDateTime
)