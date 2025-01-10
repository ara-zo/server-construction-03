package io.hhplus.serverconstruction.interfaces.waiting.dto

import io.hhplus.serverconstruction.domain.waiting.WaitingType

class IssueTokenDto(
    val token: String,
    val status: WaitingType
)