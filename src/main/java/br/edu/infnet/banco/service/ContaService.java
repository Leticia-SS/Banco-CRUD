package br.edu.infnet.banco.service;

import br.edu.infnet.banco.model.Conta;
import br.edu.infnet.banco.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    public List<Conta> consultarContas() {
        return contaRepository.findAll();
    }

    public Conta consultarConta(Long id) {
        return contaRepository.findById(id).orElseThrow(() -> new RuntimeException("ERRO: Conta não encontrada"));
    }

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }



}
