package br.com.ecommerce.api.bd_ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.api.bd_ecommerce.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  
} 