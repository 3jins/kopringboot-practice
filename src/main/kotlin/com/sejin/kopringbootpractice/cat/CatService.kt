package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.cat.model.CatMapper
import com.sejin.kopringbootpractice.cat.model.CatVo
import org.springframework.stereotype.Service

@Service
class CatService(
    private val catRepository: CatRepository,
) {
    fun getCatList(): List<CatVo> {
        return CatMapper.getInstance()
            .mapEntityListToVoList(catRepository.findAll())
    }
}
