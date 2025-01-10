package io.hhplus.serverconstruction.infra.amount

import io.hhplus.serverconstruction.infra.BaseEntity
import io.hhplus.serverconstruction.infra.user.entity.UserEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.math.BigDecimal

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "amount")
class AmountEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEntity,

    @Comment("잔액")
    var amount: BigDecimal,
) : BaseEntity()