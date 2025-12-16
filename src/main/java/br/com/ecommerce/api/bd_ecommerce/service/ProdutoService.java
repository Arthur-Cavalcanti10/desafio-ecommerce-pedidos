package br.com.ecommerce.api.bd_ecommerce.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.api.bd_ecommerce.model.Produto;
import br.com.ecommerce.api.bd_ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {
  @Autowired
  private ProdutoRepository produtoRepository;

  public Produto salvarProduto(Produto produto){
    return produtoRepository.save(produto);
  }

  public List<Produto> listarProdutos(){
    return produtoRepository.findAll();
  }

  public Optional<Produto> obterProduto(Long id){
    return produtoRepository.findById(id);
  }

  public void deletarProduto(Long id){
     produtoRepository.deleteById(id);
  }
}
