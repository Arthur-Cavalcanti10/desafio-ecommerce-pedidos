package br.com.ecommerce.api.bd_ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ecommerce.api.bd_ecommerce.model.Produto;
import br.com.ecommerce.api.bd_ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> obterProduto(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.obterProduto(id));
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto produto, @PathVariable Long id) {
        Optional<Produto> produtoExiste = produtoService.obterProduto(id);

        if (produtoExiste.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produto.setId(id);
        return ResponseEntity.ok(produtoService.salvarProduto(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        Optional<Produto> produtoExiste = produtoService.obterProduto(id);

        if (produtoExiste.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}