package br.com.ecommerce.api.bd_ecommerce.service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecommerce.api.bd_ecommerce.model.Pedido;
import br.com.ecommerce.api.bd_ecommerce.model.Produto;
import br.com.ecommerce.api.bd_ecommerce.repository.PedidoRepository;
import br.com.ecommerce.api.bd_ecommerce.repository.ProdutoRepository;

@Service
public class PedidoService {
  @Autowired
  private PedidoRepository pedidoRepository;
  private ProdutoRepository produtoRepository;

  public Pedido criarPedido(Pedido pedido) {
  double valorTotal=0;
  List<Long> produtoIds = pedido.getProdutos().stream().map(Produto::getId).collect(Collectors.toList());//extraio os ids que foram passados
  List<Produto> produtos = produtoRepository.findAllById(produtoIds); // caço os produtos de cada id da lista

  for(Produto p : pedido.getProdutos()){
    valorTotal+=p.getPreco(); 
  }

  if (valorTotal>200){
    valorTotal=valorTotal*0.9;
    pedido.setValor_total(valorTotal);
    pedido.setProdutos(produtos);
    return pedidoRepository.save(pedido);
  }

  pedido.setProdutos(produtos); //seto os produtos que eu achei da lista no pedido
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