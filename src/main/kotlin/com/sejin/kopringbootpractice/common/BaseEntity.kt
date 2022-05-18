package com.sejin.kopringbootpractice.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
class BaseEntity {
    @CreatedDate
    @Column(name = "created_datetime", updatable = false)
    lateinit var createdDateTime: LocalDateTime

    @LastModifiedDate
    @Column(name = "updated_datetime")
    lateinit var updatedDateTime: LocalDateTime
}
