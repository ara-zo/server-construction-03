package io.hhplus.serverconstruction.interfaces.concert.dto

import io.hhplus.serverconstruction.domain.concert.ConcertGradeType
import io.hhplus.serverconstruction.domain.concert.ConcertSeatStatusType
import java.math.BigDecimal

class ConcertSeatListDto(
    val concertSeatId: Long,
    val seatNum: String,
    val grade: ConcertGradeType,
    val price: BigDecimal,
    val status: ConcertSeatStatusType
)