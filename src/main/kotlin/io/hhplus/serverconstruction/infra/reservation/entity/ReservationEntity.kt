package io.hhplus.serverconstruction.infra.reservation.entity

import io.hhplus.serverconstruction.domain.reservation.ReservationStatusType
import io.hhplus.serverconstruction.infra.BaseEntity
import io.hhplus.serverconstruction.infra.concert.entity.ConcertSeatEntity
import io.hhplus.serverconstruction.infra.user.entity.UserEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.math.BigDecimal
import java.time.LocalDateTime

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "reservation")
class ReservationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("예약 Id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    var user: UserEntity,

    @Enumerated(EnumType.STRING)
    @Comment("예약 상태 (예약, 결제완료, 취소, 결제만료)")
    var status: ReservationStatusType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_seat_id")
    var concertSeat: ConcertSeatEntity,

    @Comment("가격")
    var price: BigDecimal,

    @Comment("만료 시간")
    var expiredAt: LocalDateTime
) : BaseEntity()