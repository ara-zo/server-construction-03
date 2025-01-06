package io.hhplus.serverconstruction.interfaces.reservation.dto

import java.math.BigDecimal

class ResponseReservationConcertDto(
    val reservationId: Long,
    val concertSeatId: Long,
    val seatNum: String,
    val price: BigDecimal
)