package io.hhplus.serverconstruction.domain.payment

import io.hhplus.serverconstruction.domain.reservation.Reservation
import io.hhplus.serverconstruction.domain.user.User
import java.math.BigDecimal
import java.time.LocalDateTime

class Payment (
    val id: Long,
    val reservation: Reservation,
    val user: User,
    val price: BigDecimal,
    val status: PaymentStatusType,
    val paymentDate: LocalDateTime,
)