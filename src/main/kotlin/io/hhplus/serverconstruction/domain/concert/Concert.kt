package io.hhplus.serverconstruction.domain.concert

import java.time.LocalDateTime

class Concert(
    val id: Long?,
    val name: String,
    val singer: String,
    val location: String,
    val reservationStartDate: LocalDateTime,
    val reservationEndDate: LocalDateTime,
    val concertStartDate: LocalDateTime,
    val concertEndDate: LocalDateTime,
)