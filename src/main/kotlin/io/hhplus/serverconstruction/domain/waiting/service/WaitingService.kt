package io.hhplus.serverconstruction.domain.waiting.service

import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.domain.waiting.repository.WaitingRepository
import io.hhplus.serverconstruction.infra.waiting.exception.WaitingException
import io.hhplus.serverconstruction.infra.waiting.exception.WaitingExceptionEnums
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
@RequiredArgsConstructor
class WaitingService (
    private val waitingRepository: WaitingRepository
) {
    /**
     * 토큰 발급 (토큰 쌓는 용)
     */
    fun tokenIssue(): Waiting {
        return waitingRepository.save(Waiting.create())
    }

    /**
     * 토큰 조회
     */
    fun findToken(token: String): Waiting {
        val waiting = waitingRepository.findWaitingByToken(token)

        // 만료시
        if (WaitingType.EXPIRE == waiting.status) {
            throw WaitingException(WaitingExceptionEnums.TOKEN_EXPIRED)
        }

        return waiting
    }

    /**
     * 대기열 번호
     */
    fun getWaitingNumber(token: String): Long {
        // 자기자신의 정보 가져오기
        val waiting = findToken(token)

        // 마지막 PROCESS 토큰의 정보 가져오기
        val lastWaiting = waitingRepository.findFirstByStatusOrderByIdDesc(WaitingType.PROCESS)

        // 자기자신의 id - lastWaiting id = 순번구하기
        return waiting.id.minus((lastWaiting?.id ?: 0))
    }

    /**
     * 토큰 대기열 통과
     */
    fun updateWaitingTypeProcess(token: String) {
        val waiting = waitingRepository.findWaitingByToken(token)

        // 만료시
        if (WaitingType.EXPIRE == waiting.status) {
            throw WaitingException(WaitingExceptionEnums.TOKEN_EXPIRED)
        }

        waitingRepository.save(waiting.remainingToken())
    }

    /**
     * 토큰 만료
     */
    fun updateWaitingType(token: String) {
        val waiting = waitingRepository.findWaitingByToken(token)

        if (LocalDateTime.now() < waiting.expiredDate) {
            waitingRepository.save(waiting.expireToken())
        }
    }

    fun findExpiredToken(now: LocalDateTime) {
        // 만료 지난 대기열 조회
        val expireWaitingList: List<Waiting> = waitingRepository.findWaitingByStatusAndExpireDateTimeIsBefore(WaitingType.WAITING, now)

        // 대기열 만료 처리
        waitingRepository.saveAll(expireWaitingList.map { it.expireToken() })
    }

    fun findActiveToken() {
        // 대기열 조회
        val activeWaitingList: List<Waiting> = waitingRepository.findTopByStatus(WaitingType.WAITING)

        waitingRepository.saveAll(activeWaitingList.map { it.remainingToken() })
    }
}