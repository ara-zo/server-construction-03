package io.hhplus.serverconstruction.interfaces.waiting

import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.interfaces.waiting.dto.CheckWaitingDto
import lombok.RequiredArgsConstructor
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
@RequestMapping("/waiting")
class WaitingController {

    @GetMapping("/check")
    fun check(): ResponseEntity<CheckWaitingDto> {
        return ResponseEntity.ok(
            CheckWaitingDto(
                token = "test1234",
                status = WaitingType.PROCESS
            )
        )
    }
}