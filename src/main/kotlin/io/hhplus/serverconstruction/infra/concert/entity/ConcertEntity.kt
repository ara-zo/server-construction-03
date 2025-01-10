package io.hhplus.serverconstruction.infra.concert.entity

import io.hhplus.serverconstruction.infra.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@Entity
@Table(name = "concert")
class ConcertEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Comment("콘서트 Id")
    val id: Long? = 0,

    @Comment("콘서트명")
    val name: String,

    @Comment("가수")
    val singer: String,

    @Comment("장소")
    val location: String,

    @Comment("예약 가능 시작 일시")
    val reservationStartTime: LocalDateTime,

    @Comment("예약 가능 종료 일시")
    val reservationEndTime: LocalDateTime,

    @Comment("콘서트 시작 날짜")
    val concertStartDate: LocalDateTime,

    @Comment("콘서트 종료 날짜")
    val concertEndDate: LocalDateTime

) : BaseEntity()