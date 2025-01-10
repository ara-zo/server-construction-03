package io.hhplus.serverconstruction.infra.payment.entity

import io.hhplus.serverconstruction.domain.payment.PaymentStatusType
import io.hhplus.serverconstruction.infra.BaseCreateDateEntity
import io.hhplus.serverconstruction.infra.reservation.entity.ReservationEntity
import io.hhplus.serverconstruction.infra.user.entity.UserEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.math.BigDecimal
import java.time.LocalDateTime

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "payment")
class PaymentEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("결제 Id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_id")
    var reservation: ReservationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserEntity,

    @Comment("결제 금액")
    var price: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Comment("결제 상태")
    var status: PaymentStatusType,

    @Comment("결제일시")
    var paymentDate: LocalDateTime
) : BaseCreateDateEntity()