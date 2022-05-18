package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.cat.model.CatEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CatRepository : JpaRepository<CatEntity, Long>
