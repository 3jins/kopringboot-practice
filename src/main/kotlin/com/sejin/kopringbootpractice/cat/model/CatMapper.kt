package com.sejin.kopringbootpractice.cat.model

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper
interface CatMapper {
    companion object {
        private var instance: CatMapper? = null

        fun getInstance(): CatMapper =
            instance ?: Mappers.getMapper(CatMapper::class.java)
                .also { instance = it }
    }

    fun mapEntityListToVoList(req: List<CatEntity>): List<CatVo>
}
