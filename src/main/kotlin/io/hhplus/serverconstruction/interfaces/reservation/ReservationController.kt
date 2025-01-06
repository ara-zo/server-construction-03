package io.hhplus.serverconstruction.interfaces.reservation

import io.hhplus.serverconstruction.domain.payment.PaymentStatusType
import io.hhplus.serverconstruction.interfaces.error.dto.ErrorDto
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
    ): ResponseEntity<Any> {
        return when (token) {
            "valid_token" -> {

                if (requestReservationDto.concertSeatId == 1L) {
                    ResponseEntity.ok(
                        ResponseReservationConcertDto(
                            reservationId = 1L,
                            concertSeatId = 2L,
                            seatNum = "2번",
                            price = BigDecimal("10000")
                        )
                    )
                } else if (requestReservationDto.concertSeatId == 2L) {
                    ResponseEntity.badRequest().body(
                        ErrorDto(
                            "INVALID_SEAT",
                            "유효하지 않은 좌석"
                        )
                    )
                } else {
                    ResponseEntity.badRequest().body(
                        ErrorDto(
                            "FAIL_CHECK_SEAT",
                            "좌석 체크 실패"
                        )
                    )
                }
            }

            "invalid_token" -> {
                ResponseEntity.badRequest().body(
                    ErrorDto(
                        "INVALID_TOKEN",
                        "유효하지 않은 토큰"
                    )
                )
            }

            else -> {
                ResponseEntity.internalServerError().body(
                    ErrorDto(
                        "INTERNAL_SERVER_ERROR",
                        "토큰 체크 실패"
                    )
                )
            }
        }
    }

    @PostMapping("/payment")
    fun payment(
        @RequestHeader("token") token: String,
        @RequestBody paymentDto: RequestPaymentDto
    ): ResponseEntity<Any> {
        return when (token) {
            "valid_token" -> {
                if(paymentDto.reservationPaymentId == 1L) {
                    ResponseEntity.ok(
                        ResponsePaymentDto(
                            reservationPaymentId = 1L,
                            status = PaymentStatusType.COMPLETE,
                            paymentPrice = BigDecimal("10000"),
                            amount = BigDecimal.valueOf(100L),
                        )
                    )
                } else if(paymentDto.reservationPaymentId == 2L) {
                    ResponseEntity.badRequest().body(
                        ErrorDto(
                            "INVALID_SEAT",
                            "유효하지 않은 좌석"
                        )
                    )
                } else {
                    ResponseEntity.badRequest().body(
                        ErrorDto(
                            "FAIL_CHECK_RESERVATION",
                            "예약 체크 실패"
                        )
                    )
                }
            }

            "invalid_token" -> {
                ResponseEntity.badRequest().body(
                    ErrorDto(
                        "INVALID_TOKEN",
                        "유효하지 않은 토큰"
                    )
                )
            }

            else -> {
                ResponseEntity.internalServerError().body(
                    ErrorDto(
                        "INTERNAL_SERVER_ERROR",
                        "토큰 체크 실패"
                    )
                )
            }
        }
    }
}