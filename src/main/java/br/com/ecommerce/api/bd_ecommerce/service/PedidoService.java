package br.com.ecommerce.api.bd_ecommerce.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.api.bd_ecommerce.model.Pedido;
import br.com.ecommerce.api.bd_ecommerce.model.Produto;
import br.com.ecommerce.api.bd_ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository pedidoRepository;


  public Pedido criarPedido(Pedido pedido) {
  double valorTotal=0;
  for(Produto p : pedido.getProdutos()){
    valorTotal+=p.getPreco(); 
  }

  if (valorTotal>200){
    valorTotal=valorTotal*0.9;
    pedido.setValor_total(valorTotal);

    return pedidoRepository.save(pedido);
  }

  pedido.setValor_total(valorTotal);
   
  return pedidoRepository.save(pedido);
  }

  public List<Pedido> listarPedidos() {
    return pedidoRepository.findAll();
  }

  public Optional<Pedido> obterPedido(Long id) {
    return pedidoRepository.findById(id);
  }

}