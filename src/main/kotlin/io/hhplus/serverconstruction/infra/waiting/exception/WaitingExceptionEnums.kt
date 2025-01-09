package io.hhplus.serverconstruction.infra.waiting.exception

import io.hhplus.serverconstruction.support.exception.ExceptionInterface
import org.springframework.http.HttpStatus

enum class WaitingExceptionEnums(
    override val httpStatus: HttpStatus,
    override val code: String,
    override val message: String
) : ExceptionInterface {

    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "TOKEN_EXPIRED", "만료된 토큰"),
    EMPTY_TOKEN(HttpStatus.BAD_REQUEST, "EMPTY_TOKEN", "유효하지 않는 토큰");

}
