package io.hhplus.serverconstruction.infra

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.Comment
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseCreateDateEntity(
    @CreatedDate
    @Column(nullable = false, updatable = false)
    @Comment("생성일시")
    var createDate: LocalDateTime? = LocalDateTime.now()
)
