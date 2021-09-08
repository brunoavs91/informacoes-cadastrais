package com.boaentrega.informacoescadastrais.model.factory;

import com.boaentrega.informacoescadastrais.model.ItemPedido;
import com.boaentrega.informacoescadastrais.model.Pedido;
import com.boaentrega.informacoescadastrais.model.Produto;
import com.boaentrega.informacoescadastrais.model.StatusPedido;
import com.boaentrega.informacoescadastrais.model.dto.ItemPedidoDTO;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;
import com.boaentrega.informacoescadastrais.model.dto.ProdutoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoFactory {


    public static PedidoDTO fromDTO(Pedido pedido) {

        return PedidoDTO.builder().id(pedido.getId())
                .status(pedido.getStatus().name())
                .tempoDePreparo(pedido.getTempoDePreparo())
                .itens(fromListDTO(pedido.getItens())).build();

    }

    public static Pedido fromEntity(PedidoDTO pedidoDTO){
        return Pedido.builder().id(pedidoDTO.getId())
                .status(StatusPedido.valueOf(pedidoDTO.getStatus()))
                .tempoDePreparo(pedidoDTO.getTempoDePreparo())
                .itens(fromListEntity(pedidoDTO.getItens())).build();
    }

    private static List<ItemPedido> fromListEntity(List<ItemPedidoDTO> listaItemDTO) {
        return listaItemDTO.stream().map(i -> {
            return ItemPedido.builder().id(i.getId())
                    .quantidade(i.getQuantidade())
                    .produto(fromProdutoEntity(i.getProduto())).build();
        }).collect(Collectors.toList());
    }

    private static Produto fromProdutoEntity(ProdutoDTO produtoDTO){
        return Produto.builder().nome(produtoDTO.getNome())
                .estado(produtoDTO.getEstado())
                .descricao(produtoDTO.getDescricao()).preco(produtoDTO.getPreco()).build();
    }

    private static List<ItemPedidoDTO> fromListDTO(List<ItemPedido> listaItem) {
        return listaItem.stream().map(i -> {
            return ItemPedidoDTO.builder().id(i.getId())
                    .quantidade(i.getQuantidade())
                    .produto(fromProdutoDTO(i.getProduto())).build();
        }).collect(Collectors.toList());
    }

    private static ProdutoDTO fromProdutoDTO(Produto produto){
        return ProdutoDTO.builder().nome(produto.getNome())
                .estado(produto.getEstado())
                .descricao(produto.getDescricao()).preco(produto.getPreco()).build();
    }
}
