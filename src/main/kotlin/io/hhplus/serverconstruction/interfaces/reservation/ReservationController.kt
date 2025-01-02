package io.hhplus.serverconstruction.interfaces.reservation

import io.hhplus.serverconstruction.domain.payment.PaymentStatusType
import io.hhplus.serverconstruction.interfaces.reservation.dto.RequestPaymentDto
import io.hhplus.serverconstruction.interfaces.reservation.dto.RequestReservationConcertDto
import io.hhplus.serverconstruction.interfaces.reservation.dto.ResponsePaymentDto
import io.hhplus.serverconstruction.interfaces.reservation.dto.ResponseReservationConcertDto
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservations")
class ReservationController {

    @PostMapping
    fun reservationConcert(
        @RequestHeader("token") token: String?,
        @RequestBody requestReservationDto: RequestReservationConcertDto
    ): ResponseEntity<ResponseReservationConcertDto> {
        return ResponseEntity.ok(
            ResponseReservationConcertDto(
                reservationId = 1L,
                concertSeatId = 2L,
                seatNum = "2번",
                price = BigDecimal("10000")
            )
        )
    }

    @PostMapping("/payment")
    fun payment(
        @RequestHeader("token") token: String,
        @RequestBody PaymentDto: RequestPaymentDto
    ): ResponseEntity<ResponsePaymentDto> {
        return ResponseEntity.ok(
            ResponsePaymentDto(
                reservationPaymentId = 1L,
                status = PaymentStatusType.COMPLETE,
                paymentPrice = BigDecimal("10000"),
                amount = BigDecimal.valueOf(100L),
            )
        )
    }
}