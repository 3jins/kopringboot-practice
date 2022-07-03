package com.sejin.kopringbootpractice.cat.batch

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.test.JobLauncherTestUtils
import org.springframework.batch.test.context.SpringBatchTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import
import java.util.*

@SpringBootTest
@EnableBatchProcessing
class CatBatchJobConfigurationTest(@Autowired var jobLauncherTestUtils: JobLauncherTestUtils) : BehaviorSpec({
    Given("CatBatchConfiguration") {
        When("Batch job is started") {
            Then("All cats should be printed") {
                val params = JobParametersBuilder().addDate("date", Date()).toJobParameters()
                jobLauncherTestUtils.launchJob(params)
            }
        }
    }
})
