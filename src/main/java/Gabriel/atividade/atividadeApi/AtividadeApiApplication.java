package Gabriel.atividade.atividadeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//as anotações alem do springApplication foram fetias pelo gpt acho que não é o motivo do erro
@SpringBootApplication(scanBasePackages = "Gabriel.atividade.atividadeApi")
@EnableJpaRepositories(basePackages = "Gabriel.atividade.atividadeApi.repository")
@EntityScan(basePackages = "Gabriel.atividade.atividadeApi.model")

public class AtividadeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeApiApplication.class, args);
	}

}
