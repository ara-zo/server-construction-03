package io.hhplus.serverconstruction.domain.waiting

import java.time.LocalDateTime
import java.util.UUID

class Waiting(
    val id: Long = 0,
    val token: String,
    var status: WaitingType,
    var expiredDate: LocalDateTime
) {
    companion object {
        fun create(): Waiting {
            return Waiting(
                token = UUID.randomUUID().toString(),
                status = WaitingType.WAITING,
                expiredDate = LocalDateTime.now().plusMinutes(5)
            )
        }
    }

    fun expireToken(): Waiting {
        this.status = WaitingType.EXPIRE
        return this
    }

    fun remainingToken(): Waiting {
        this.status = WaitingType.PROCESS
        return this
    }

    fun isAvailableToken(): Boolean {
        return WaitingType.PROCESS.equals(this.status)
    }
}