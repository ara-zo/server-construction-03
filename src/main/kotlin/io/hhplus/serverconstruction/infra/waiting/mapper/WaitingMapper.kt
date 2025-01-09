package io.hhplus.serverconstruction.infra.waiting.mapper

import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.infra.waiting.entity.WaitingEntity

object WaitingMapper {
    fun toDomain(waitingEntity: WaitingEntity): Waiting {
        return Waiting(
            id = waitingEntity.id,
            token = waitingEntity.token,
            status = waitingEntity.status,
            expiredDate = waitingEntity.expiredDate,
        )
    }

    fun toEntity(waiting: Waiting): WaitingEntity {
        return WaitingEntity(
            id = waiting.id,
            token = waiting.token,
            status = waiting.status,
            expiredDate = waiting.expiredDate,
        )
    }
}