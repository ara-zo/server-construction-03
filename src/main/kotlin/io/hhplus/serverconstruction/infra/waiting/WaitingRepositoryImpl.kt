package io.hhplus.serverconstruction.infra.waiting

import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.domain.waiting.repository.WaitingRepository
import io.hhplus.serverconstruction.infra.waiting.mapper.WaitingMapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
@RequiredArgsConstructor
class WaitingRepositoryImpl(
    private val waitingJpaRepository: WaitingJpaRepository
) : WaitingRepository {
    override fun save(waiting: Waiting): Waiting {
        return WaitingMapper.toDomain(waitingJpaRepository.save(WaitingMapper.toEntity(waiting)))
    }

    override fun findWaitingByToken(waitingToken: String): Waiting {
        return WaitingMapper.toDomain(waitingJpaRepository.findByToken(waitingToken))
    }

    override fun findFirstByStatusOrderByIdDesc(status: WaitingType): Waiting? {
        return WaitingMapper.toDomain(waitingJpaRepository.findFirstByStatusOrderByIdDesc(status))
    }

    override fun findWaitingByStatusAndExpireDateTimeIsBefore(waitingStatus: WaitingType, targetDatetime: LocalDateTime): List<Waiting> {
        return waitingJpaRepository.findAllByStatusAndExpiredDateIsBefore(waitingStatus, targetDatetime).map(WaitingMapper::toDomain)
    }

    override fun saveAll(waitingList: List<Waiting>) {
        waitingJpaRepository.saveAll(
            waitingList.map { WaitingMapper.toEntity(it) }
        )
    }

    override fun findTopByStatus(status: WaitingType): List<Waiting> {
        return waitingJpaRepository.findTopByStatus(status).map(WaitingMapper::toDomain)
    }
}