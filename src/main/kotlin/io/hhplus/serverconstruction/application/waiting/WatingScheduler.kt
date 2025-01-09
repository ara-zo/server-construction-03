package io.hhplus.serverconstruction.application.waiting

import io.hhplus.serverconstruction.application.waiting.facade.WaitingFacade
import lombok.RequiredArgsConstructor
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class WaitingScheduler(
    private val waitingFacade: WaitingFacade
) {

    // 10초
    @Scheduled(fixedRate = 10000)
    fun run() {
        waitingFacade.tokenScheduler()
    }


}