package io.hhplus.serverconstruction.domain.concert

import java.time.LocalDateTime

class ConcertSchedule (
    val id: Long,
    val concert: Concert,
    concertStartTime: LocalDateTime,
    concertEndTime: LocalDateTime,
)
