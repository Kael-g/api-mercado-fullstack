package com.catalisa.apimercado.service;

import com.catalisa.apimercado.model.ProdutoModel;
import com.catalisa.apimercado.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoModel> exibirProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> exibirProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }
}
