package io.hhplus.serverconstruction.domain.reservation

import io.hhplus.serverconstruction.domain.concert.ConcertSeat
import io.hhplus.serverconstruction.domain.user.User
import java.math.BigDecimal
import java.time.LocalDateTime

class Reservation (
    val id: Long,
    val user: User,
    val status: ReservationStatusType,
    val concertSeat: ConcertSeat,
    val price: BigDecimal,
    val expiredAt: LocalDateTime,
)