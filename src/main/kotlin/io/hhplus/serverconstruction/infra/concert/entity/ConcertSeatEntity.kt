package io.hhplus.serverconstruction.infra.concert.entity

import io.hhplus.serverconstruction.domain.concert.ConcertSeatStatusType
import io.hhplus.serverconstruction.infra.BaseEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.math.BigDecimal

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "concert_seat")
class ConcertSeatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("콘서트 좌석 Id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_schedule_id")
    var concertSchedule: ConcertScheduleEntity,

    @Comment("좌석 번호")
    var seatNum: String,

    @Enumerated(EnumType.STRING)
    @Comment("좌석 등급 (VIP, S, A)")
    var grade: ConcertSeatStatusType,

    @Comment("좌석 가격")
    var price: BigDecimal,

    @Comment("좌석 상태 (예약가능, 임시배정, 예약완료)")
    var status: String
) : BaseEntity()