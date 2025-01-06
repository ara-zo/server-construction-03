package io.hhplus.serverconstruction.infra.concert.entity

import io.hhplus.serverconstruction.infra.BaseEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "concert_schedule")
class ConcertScheduleEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("콘서트 스케쥴 Id")
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id")
    var concert: ConcertEntity,

    @Comment("콘서트 시작 시간")
    var concertStartTime: LocalDateTime,

    @Comment("콘서트 종료 시간")
    var concertEndTime: LocalDateTime

) : BaseEntity()