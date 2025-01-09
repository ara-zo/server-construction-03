package io.hhplus.serverconstruction.application.waiting.dto

import io.hhplus.serverconstruction.domain.waiting.WaitingType
import java.time.LocalDateTime

class CheckTokenResult(
    val token: String,
    val waitingNumber: Long,
    val status: WaitingType,
    val expireDate: LocalDateTime
) {

    companion object {
        fun create(
            token: String,
            waitingNumber: Long,
            status: WaitingType,
            expireDate: LocalDateTime
        ): CheckTokenResult {
            return CheckTokenResult(token, waitingNumber, status, expireDate)
        }
    }
}