package io.hhplus.serverconstruction.support.exception

import org.springframework.http.HttpStatus

interface ExceptionInterface {
    val httpStatus: HttpStatus
    val code: String
    val message: String
}