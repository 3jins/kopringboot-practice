package com.sejin.kopringbootpractice.cat.model

import com.sejin.kopringbootpractice.cat.enumeration.CatKindEnum
import com.sejin.kopringbootpractice.common.BaseEntity
import com.sejin.kopringbootpractice.common.ColorEnum
import javax.persistence.*

@Entity(name = "Cat")
data class CatEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val name: String,

    val kind: CatKindEnum,

    val furColor: ColorEnum,

    val age: Int,
) : BaseEntity()
