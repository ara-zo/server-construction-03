package io.hhplus.serverconstruction.domain.concert.service

import io.hhplus.serverconstruction.domain.concert.Concert
import io.hhplus.serverconstruction.domain.concert.repository.ConcertRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ConcertService(
    private val concertRepository: ConcertRepository,
) {

    /**
     * 콘서트 조회
     */
    fun findAllConcert(): List<Concert> {
        return concertRepository.findAll()
    }

    /**
     * 콘서트 스케쥴 조회(예약 가능 날짜)
     */


    /**
     * 콘서트 좌석 조회 (좌석 정보 1~50)
     */
}