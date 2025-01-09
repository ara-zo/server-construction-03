package io.hhplus.serverconstruction.infra.concert

import io.hhplus.serverconstruction.infra.concert.entity.ConcertEntity
import org.springframework.data.jpa.repository.JpaRepository


interface ConcertJpaRepository: JpaRepository<ConcertEntity, Long> {
}