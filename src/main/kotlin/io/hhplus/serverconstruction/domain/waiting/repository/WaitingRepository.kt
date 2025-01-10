package io.hhplus.serverconstruction.domain.waiting.repository

import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.domain.waiting.WaitingType
import java.time.LocalDateTime

interface WaitingRepository {
    fun save(waiting: Waiting): Waiting

    fun findWaitingByToken(waitingToken: String): Waiting?

    fun findFirstByStatusOrderByIdDesc(status: WaitingType): Waiting?

    fun findWaitingByStatusAndExpireDateTimeIsBefore(waitingStatus: WaitingType, targetDatetime: LocalDateTime): List<Waiting>

    fun saveAll(waitingList: List<Waiting>)

    fun findTopByStatus(status: WaitingType): List<Waiting>
}