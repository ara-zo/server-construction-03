package io.hhplus.serverconstruction.interfaces.reservation.dto

import io.hhplus.serverconstruction.domain.payment.PaymentStatusType
import java.math.BigDecimal

class ResponsePaymentDto(
    val reservationPaymentId: Long,
    val status: PaymentStatusType,
    val paymentPrice: BigDecimal,
    val amount: BigDecimal
)