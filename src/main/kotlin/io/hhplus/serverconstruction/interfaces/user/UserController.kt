package io.hhplus.serverconstruction.interfaces.user

import io.hhplus.serverconstruction.interfaces.error.dto.ErrorDto
import io.hhplus.serverconstruction.interfaces.user.dto.AmountDto
import io.hhplus.serverconstruction.interfaces.user.dto.ChargeDto
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
class UserController {

    @GetMapping("{userId}/amount")
    fun amount(
        @PathVariable("userId") userId: Long
    ): ResponseEntity<Any> {
        return when (userId) {
            1L -> ResponseEntity.ok(
                AmountDto(
                    amount = BigDecimal("10000")
                )
            )

            2L -> ResponseEntity.badRequest().body(
                ErrorDto(
                    "INVALID_TOKEN",
                    "유효하지 않은 유저"
                )
            )

            else -> ResponseEntity.internalServerError().body(
                ErrorDto(
                    "INTERNAL_SERVER_ERROR",
                    "유저 잔액 체크 실패"
                )
            )
        }
    }

    @PatchMapping("{userId}/charge")
    fun charge(
        @PathVariable("userId") userId: Long
    ): ResponseEntity<Any> {
        return when (userId) {
            1L -> ResponseEntity.ok(
                ChargeDto(
                    amount = BigDecimal("500")
                )
            )

            2L -> ResponseEntity.badRequest().body(
                ErrorDto(
                    "INVALID_TOKEN",
                    "유효하지 않은 유저"
                )
            )

            else -> ResponseEntity.internalServerError().body(
                ErrorDto(
                    "INTERNAL_SERVER_ERROR",
                    "유저 잔액 체크 실패"
                )
            )
        }
    }
}