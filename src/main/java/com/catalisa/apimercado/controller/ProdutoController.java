package com.catalisa.apimercado.controller;

import com.catalisa.apimercado.model.ProdutoModel;
import com.catalisa.apimercado.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> exibirProdutos(){
        return ResponseEntity.ok(produtoService.exibirProdutos());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> exibirProdutoPorId(@PathVariable Long id){
        Optional<ProdutoModel> produto = produtoService.exibirProdutoPorId(id);
        if (produto.isEmpty()){
            return (ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado"));
        }
        return ResponseEntity.ok(produto.get());
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody ProdutoModel produtoModel){
        return new ResponseEntity<>(produtoService.cadastrarProduto(produtoModel), HttpStatus.CREATED);
    }

}
