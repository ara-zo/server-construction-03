package io.hhplus.serverconstruction.infra.concert.mapper

import io.hhplus.serverconstruction.domain.concert.Concert
import io.hhplus.serverconstruction.infra.concert.entity.ConcertEntity

object ConcertMapper {
    fun toDomain(concertEntity: ConcertEntity): Concert {
        return Concert(
            id = concertEntity.id,
            name = concertEntity.name,
            singer = concertEntity.singer,
            location = concertEntity.location,
            reservationStartDate = concertEntity.reservationStartTime,
            reservationEndDate = concertEntity.reservationEndTime,
            concertStartDate = concertEntity.concertStartDate,
            concertEndDate = concertEntity.concertEndDate
        )
    }

    fun toEntity(concert: Concert): ConcertEntity {
        return ConcertEntity(
            id = concert.id,
            name = concert.name,
            singer = concert.singer,
            location = concert.location,
            reservationStartTime = concert.reservationStartDate,
            reservationEndTime = concert.reservationEndDate,
            concertStartDate = concert.concertStartDate,
            concertEndDate = concert.concertEndDate
        )
    }
}