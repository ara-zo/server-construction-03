package io.hhplus.serverconstruction.infra.user.entity

import io.hhplus.serverconstruction.infra.BaseEntity
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.NoArgsConstructor
import org.hibernate.annotations.Comment

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("사용자 Id")
    var id: Long,

    @Comment("사용자명")
    var name: String
) : BaseEntity()