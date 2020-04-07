
package sam.onetime.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.excel.RowMapper;
import org.springframework.batch.item.excel.poi.PoiItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import sam.onetime.config.in.ResourceRowMapper;
import sam.onetime.model.Resource;

/**
 *
 * Nr.   Name       Date         Release/Description
 *---------------------------------------------------
 * 02
 * 01   Sarat     08 04 2020      New Class
 *
 * @author Sarat
 *
 *
 */
@Configuration
public class ExcelFileJobConfig {
	private static final String PROPERTY_EXCEL_SOURCE_FILE_PATH = "excel.to.database.job.source.file.path";

	@Bean
	public ItemReader<Resource> excelResourceReader(
			@Qualifier("excelResourceRowMapper") final RowMapper<Resource> excelResourceRowMapper) {
		PoiItemReader<Resource> reader = new PoiItemReader<>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource(PROPERTY_EXCEL_SOURCE_FILE_PATH));
		reader.setRowMapper(excelResourceRowMapper);
		return reader;
	}

	@Bean
	public RowMapper<Resource> excelResourceRowMapper() {
		return new ResourceRowMapper();
	}

	@Bean
	public ItemProcessor<Resource, Resource> resourceProcessor() {
//TODO finish implementation of processor
		return null;
	}

	@Bean
	public ItemWriter<Resource> resourceWriter() {
		// TODO finish implementation of writer
		return null;
	}

	@Bean
	public Step excelFileStep(final StepBuilderFactory stepBuilderFactory, final ItemReader<Resource> resourceReader,
			final ItemProcessor<Resource, Resource> resourceProcessor, final ItemWriter<Resource> resourceWriter) {
		return stepBuilderFactory.get("excelJobStep").<Resource, Resource>chunk(10).reader(resourceReader)
				.processor(resourceProcessor).writer(resourceWriter).build();
	}

	@Bean
	public Job excelFileJob(final JobBuilderFactory jobBuilderFactory,
			@Qualifier("excelFileStep") final Step excelJobStep) {
		return jobBuilderFactory.get("excelFileJob").incrementer(new RunIdIncrementer()).flow(excelJobStep).end()
				.build();
	}

}
