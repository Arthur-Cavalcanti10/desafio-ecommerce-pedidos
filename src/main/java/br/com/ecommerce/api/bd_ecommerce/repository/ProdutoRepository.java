package br.com.ecommerce.api.bd_ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ecommerce.api.bd_ecommerce.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  Optional<Produto> findByNome (String nome);
  void deleteByNome (String nome);
}
