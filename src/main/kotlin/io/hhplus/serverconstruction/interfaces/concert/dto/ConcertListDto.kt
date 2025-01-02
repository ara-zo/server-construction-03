package io.hhplus.serverconstruction.interfaces.concert.dto

import java.time.LocalDateTime

class ConcertListDto(
    val concertId: Long,
    val name: String,
    val singer: String,
    val location: String,
    val reservationStartDate: LocalDateTime,
    val reservationEndDate: LocalDateTime,
    val concertStartDate: LocalDateTime,
    val concertEndDate: LocalDateTime,
)