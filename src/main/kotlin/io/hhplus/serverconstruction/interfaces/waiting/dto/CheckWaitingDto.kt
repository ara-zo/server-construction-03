package io.hhplus.serverconstruction.interfaces.waiting.dto

import io.hhplus.serverconstruction.domain.waiting.WaitingType

class CheckWaitingDto(
    val token: String,
    val status: WaitingType
)