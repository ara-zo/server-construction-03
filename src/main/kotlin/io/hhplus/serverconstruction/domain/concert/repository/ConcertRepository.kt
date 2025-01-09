package io.hhplus.serverconstruction.domain.concert.repository

import io.hhplus.serverconstruction.domain.concert.Concert

interface ConcertRepository {
    fun findAll(): List<Concert>
}