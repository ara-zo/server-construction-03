package io.hhplus.serverconstruction.interfaces.user

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
    ): ResponseEntity<AmountDto> {
        return ResponseEntity.ok(
            AmountDto(
                amount = BigDecimal("10000")
            )
        )
    }

    @PatchMapping("{userId}/charge")
    fun charge(
        @PathVariable("userId") userId: Long
    ): ResponseEntity<ChargeDto> {
        return ResponseEntity.ok(
            ChargeDto(
                amount = BigDecimal("500")
            )
        )
    }
}