package br.edu.infnet.banco;

import br.edu.infnet.banco.model.Conta;
import br.edu.infnet.banco.service.ContaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class BancoCrudApplication implements CommandLineRunner {

	private final ContaService contaService;

	public BancoCrudApplication(ContaService contaService) {
		this.contaService = contaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BancoCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		consultarTodas();
	}

	public void consultarTodas() {
		List<Conta> contas = contaService.consultarContas();
		contas.forEach(conta -> System.out.println(conta));
	}
}
