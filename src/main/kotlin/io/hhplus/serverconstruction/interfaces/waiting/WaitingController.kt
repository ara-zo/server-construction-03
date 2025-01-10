package io.hhplus.serverconstruction.interfaces.waiting

import io.hhplus.serverconstruction.application.waiting.dto.CheckTokenResult
import io.hhplus.serverconstruction.application.waiting.facade.WaitingFacade
import io.hhplus.serverconstruction.interfaces.waiting.dto.IssueTokenDto
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
    ): ResponseEntity<CheckTokenResult> {

        return ResponseEntity.ok(
            waitingFacade.checkToken(token)
        )
    }
}