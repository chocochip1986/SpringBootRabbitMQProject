package rabbitmq.batchconfig;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBatchProcessing
@Configuration
public class SpringBatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step stepOne() {
        return stepBuilderFactory.get("stepOne").tasklet(new Tasklet() {
            public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
                return RepeatStatus.FINISHED;
            }
        }).build();
    }

    @Bean
    public Job testJob1() {
        return jobBuilderFactory
                .get("testJob1")
                .start(stepOne())
                .on("FAIL")
                .fail().on("*")
                .end()
                .end()
                .build();
    }
}
