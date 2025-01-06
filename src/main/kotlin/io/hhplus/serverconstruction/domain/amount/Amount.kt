package io.hhplus.serverconstruction.domain.amount

import io.hhplus.serverconstruction.domain.user.User
import java.math.BigDecimal

class Amount(
    val id: Long,
    val user: User,
    var amount: BigDecimal
)