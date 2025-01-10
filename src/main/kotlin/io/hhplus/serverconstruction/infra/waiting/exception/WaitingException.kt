package io.hhplus.serverconstruction.infra.waiting.exception

import io.hhplus.serverconstruction.support.exception.BaseException

class WaitingException(
    waitingExceptionEnums: WaitingExceptionEnums
) : BaseException(waitingExceptionEnums)