package io.hhplus.serverconstruction.infra.concert

import io.hhplus.serverconstruction.domain.concert.Concert
import io.hhplus.serverconstruction.domain.concert.repository.ConcertRepository
import io.hhplus.serverconstruction.infra.concert.mapper.ConcertMapper
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class ConcertRepositoryImpl(
    private val concertJpaRepository: ConcertJpaRepository
): ConcertRepository {
    override fun findAll(): List<Concert> {
        return concertJpaRepository.findAll().map { ConcertMapper.toDomain(it) }
    }

}