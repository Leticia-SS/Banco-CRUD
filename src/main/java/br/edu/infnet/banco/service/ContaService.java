package br.edu.infnet.banco.service;

import br.edu.infnet.banco.exceptions.ContaNaoEncontradaException;
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
        return contaRepository.findById(id).orElseThrow(() -> new ContaNaoEncontradaException(id));
    }

    public Conta criarConta(Conta conta) {
        return contaRepository.save(conta);
    }

    public void excluirConta(Long id) {
        Conta conta = consultarConta(id);
        contaRepository.delete(conta);
    }

    public void alterarConta(Long id, double saldo) {
        Conta conta = consultarConta(id);
        conta.setSaldo(saldo);
        contaRepository.save(conta);
    }
}
