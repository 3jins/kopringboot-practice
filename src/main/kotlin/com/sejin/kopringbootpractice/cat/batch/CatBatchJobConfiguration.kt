package com.sejin.kopringbootpractice.cat.batch

import com.sejin.kopringbootpractice.cat.CatRepository
import com.sejin.kopringbootpractice.cat.model.CatEntity
import com.sejin.kopringbootpractice.cat.model.CatVo
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.JobScope
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.item.ItemWriter
import org.springframework.batch.item.data.RepositoryItemReader
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.Sort

@Configuration
@EnableBatchProcessing
class CatBatchJobConfiguration(
    val jobBuilderFactory: JobBuilderFactory,
    val stepBuilderFactory: StepBuilderFactory,
    val catRepository: CatRepository,
) {

    @Bean
    fun catBatchjob(): Job = jobBuilderFactory
        .get("${BATCH_NAME}Job")
        .preventRestart()
        .start(catBatchStep())
        .build()

    @Bean
    @JobScope
    fun catBatchStep(): Step = stepBuilderFactory
        .get("${BATCH_NAME}Step")
        .chunk<CatEntity, CatVo>(CHUNK_SIZE)
        .reader(catBatchReader())
//        .processor()
        .writer(catBatchWriter())
        .build()

    @Bean
    fun catBatchReader(): RepositoryItemReader<CatEntity> = RepositoryItemReaderBuilder<CatEntity>()
        .repository(catRepository)
        .methodName("findAll")
        .sorts(mapOf("id" to Sort.Direction.ASC))
        .name("웍스조하")
        .build()

    fun catBatchWriter(): ItemWriter<CatVo> = ItemWriter { it.map { catVo -> print(catVo.name) } }

    companion object {
        val BATCH_NAME = "CatBatch"
        val CHUNK_SIZE = 2
    }
}
