package io.hhplus.serverconstruction.interfaces.waiting

import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.interfaces.error.dto.ErrorDto
import io.hhplus.serverconstruction.interfaces.waiting.dto.CheckWaitingDto
import io.swagger.v3.oas.annotations.headers.Header
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/waiting")
class WaitingController {

    @GetMapping("/check")
    fun check(
        @RequestHeader("token") token: String,
    ): Any {

        return when (token) {
            "valid_token" -> {
                ResponseEntity.ok(
                    CheckWaitingDto(
                        token = "test1234",
                        status = WaitingType.PROCESS
                    )
                )
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