package io.hhplus.serverconstruction.interfaces.waiting

import io.hhplus.serverconstruction.application.waiting.facade.WaitingFacade
import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.interfaces.error.dto.ErrorDto
import io.hhplus.serverconstruction.interfaces.waiting.dto.CheckWaitingDto
import io.hhplus.serverconstruction.interfaces.waiting.dto.IssueTokenDto
import io.swagger.v3.oas.annotations.headers.Header
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequiredArgsConstructor
@RequestMapping("/waiting")
class WaitingController(
    private val waitingFacade: WaitingFacade
) {

    /**
     * 토큰 발급
     */
    @PostMapping
    fun tokenIssue(): ResponseEntity<IssueTokenDto> {
        val token = waitingFacade.tokenIssue()
        return ResponseEntity.ok(
            IssueTokenDto(
                token = token.token,
                status = token.status
            )
        )
    }

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