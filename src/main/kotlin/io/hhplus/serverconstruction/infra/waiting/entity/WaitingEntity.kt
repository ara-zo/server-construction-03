package io.hhplus.serverconstruction.infra.waiting.entity

import io.hhplus.serverconstruction.domain.waiting.WaitingType
import io.hhplus.serverconstruction.infra.BaseCreateDateEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment
import java.time.LocalDateTime

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "waiting")
class WaitingEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("대기열 id")
    var id: Long,

    @Comment("대기열 토큰")
    var token: String,

    @Enumerated(EnumType.STRING)
    @Comment("대기열 상태")
    var status: WaitingType,

    @Comment("토큰 만료 일시")
    var expiredDate: LocalDateTime
) : BaseCreateDateEntity()