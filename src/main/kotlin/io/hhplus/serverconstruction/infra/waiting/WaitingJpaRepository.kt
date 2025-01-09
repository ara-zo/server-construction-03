package io.hhplus.serverconstruction.infra.waiting

import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.infra.waiting.entity.WaitingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDateTime


interface WaitingJpaRepository : JpaRepository<WaitingEntity, Long> {
    fun findByToken(token: String): WaitingEntity?

    fun findFirstByStatusOrderByIdDesc(status: WaitingType): WaitingEntity

    @Query("SELECT w FROM WaitingEntity w WHERE w.status = :status AND w.expiredDate <= :targetDatetime")
    fun findAllByStatusAndExpiredDateIsBefore(status: WaitingType, targetDatetime: LocalDateTime): List<WaitingEntity>

    @Query("SELECT w FROM WaitingEntity w WHERE w.status = :status ORDER BY w.id ASC limit 10")
    fun findTopByStatus(status: WaitingType): List<WaitingEntity>
}
