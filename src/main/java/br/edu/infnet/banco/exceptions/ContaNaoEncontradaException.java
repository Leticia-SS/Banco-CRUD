package br.edu.infnet.banco.exceptions;

public class ContaNaoEncontradaException extends RuntimeException{

    public ContaNaoEncontradaException(Long id) {
        super("Erro: conta não encontrada " + id);
    }
}
