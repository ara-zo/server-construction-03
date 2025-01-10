package io.hhplus.serverconstruction.support.exception

import org.springframework.http.HttpStatus

open class BaseException(
    exception: ExceptionInterface
) : RuntimeException(exception.message) {

    val httpStatus: HttpStatus = exception.httpStatus
    val errorCode: String = exception.code
    override val message: String = exception.message
}