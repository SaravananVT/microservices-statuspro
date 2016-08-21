package demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class MilestoneServiceApplication {

	@Bean
	public CommandLineRunner init(MilestoneRepository milestoneRepository) {
		return args -> {
			milestoneRepository.deleteAll();

			Arrays.asList("project1", "project2").forEach(n ->
				milestoneRepository.save(new Milestone(n,
						String.format("01 May 2016", n),
						String.format("Build and Testing", n), "In Progress")));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(MilestoneServiceApplication.class, args);
	}

}
