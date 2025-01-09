package io.hhplus.serverconstruction.application.waiting.facade

import io.hhplus.serverconstruction.application.waiting.dto.CheckTokenResult
import io.hhplus.serverconstruction.domain.waiting.Waiting
import io.hhplus.serverconstruction.domain.waiting.service.WaitingService
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Component
@RequiredArgsConstructor
@Transactional(readOnly = false, rollbackFor = [Exception::class])
class WaitingFacade(
    private val waitingService: WaitingService
) {
    fun tokenIssue(): Waiting {
        return waitingService.tokenIssue()
    }

    @Transactional(rollbackFor = [java.lang.Exception::class])
    fun checkToken(token: String): CheckTokenResult {
        val waiting = waitingService.findToken(token)

        val waitingNumber = waitingService.getWaitingNumber(token)

        return CheckTokenResult.create(
            waiting.token,
            waitingNumber,
            waiting.status,
            waiting.expiredDate
        )
    }

    @Transactional(rollbackFor = [java.lang.Exception::class])
    fun tokenScheduler() {
        val now = LocalDateTime.now()
        // 만료 일시가 5분이 넘은 토큰 만료 처리
        waitingService.findExpiredToken(now)

        // 대기열 진입 가능한 토큰 상태 변경
//        waitingService.findActiveToken()
    }
}