package io.hhplus.serverconstruction.domain.waiting

import java.time.LocalDateTime

class Waiting(
    val id: Long = 0,
    val token: String,
    var status: WaitingType,
    var expiredDate: LocalDateTime
)