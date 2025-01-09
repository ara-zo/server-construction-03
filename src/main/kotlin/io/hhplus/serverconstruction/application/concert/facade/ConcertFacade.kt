package io.hhplus.serverconstruction.application.concert.facade

import io.hhplus.serverconstruction.domain.concert.Concert
import io.hhplus.serverconstruction.domain.concert.repository.ConcertRepository
import io.hhplus.serverconstruction.domain.concert.service.ConcertService
import io.hhplus.serverconstruction.domain.waiting.service.WaitingService
import io.hhplus.serverconstruction.interfaces.concert.dto.ConcertListDto
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
@RequiredArgsConstructor
@Transactional(readOnly = false, rollbackFor = [Exception::class])
class ConcertFacade(
    private val concertService: ConcertService,
    private val waitingService: WaitingService
) {
    fun findAllConcerts(token: String): List<ConcertListDto?> {

        // 토큰 유효성 체크
        waitingService.findToken(token)

        // 콘서트 목록 조회
        return concertService.findAllConcert().map {
            it.id?.let { id ->
                ConcertListDto(
                    concertId = id,
                    name = it.name,
                    singer = it.singer,
                    location = it.location,
                    reservationStartDate = it.reservationStartDate,
                    reservationEndDate = it.reservationEndDate,
                    concertStartDate = it.concertStartDate,
                    concertEndDate = it.concertEndDate
                )
            }
        }
    }

}