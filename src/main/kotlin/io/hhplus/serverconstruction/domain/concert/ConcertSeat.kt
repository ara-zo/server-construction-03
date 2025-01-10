package io.hhplus.serverconstruction.domain.concert

import java.math.BigDecimal

class ConcertSeat (
    val id: Long,
    val concertSchedule: ConcertSchedule,
    val seatNum: String,
    val grade: ConcertSeatStatusType,
    val price: BigDecimal,
    val status: String
)
