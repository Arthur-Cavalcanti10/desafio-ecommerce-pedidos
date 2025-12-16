package br.com.ecommerce.api.bd_ecommerce.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecommerce.api.bd_ecommerce.model.Pedido;
import br.com.ecommerce.api.bd_ecommerce.service.PedidoService;

@Controller
@RequestMapping(value = "/pedidos")
public class PedidoController {
  @Autowired
  private PedidoService pedidoService;

  @GetMapping
  public ResponseEntity<List<Pedido>> listarPedidos(){
  return ResponseEntity.ok().body(pedidoService.listarPedidos());
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Optional<Pedido>> obterPedido(@PathVariable Long id){
    return ResponseEntity.ok().body(pedidoService.obterPedido(id));
  }

  @PostMapping(value = "/cadastrar")
  public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
    return ResponseEntity.ok().body(pedidoService.criarPedido(pedido));
  }
  
  }
  

