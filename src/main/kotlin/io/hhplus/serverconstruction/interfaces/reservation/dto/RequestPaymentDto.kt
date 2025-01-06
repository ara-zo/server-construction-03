package io.hhplus.serverconstruction.interfaces.reservation.dto

data class RequestPaymentDto(
    val userId: Long,
    val reservationPaymentId: Long
)