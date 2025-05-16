package org.LojaVirtual.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Pagamento {
   private List<Produto> Produtos;
   private  LocalDate DataCompra;
   private Cliente Cliente = new Cliente("Lucas");

    public Pagamento(List<Produto> produtos, LocalDate dataCompra, Cliente cliente) {
        Produtos = produtos;
        DataCompra = dataCompra;
        Cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return Produtos;
    }

    public LocalDate getDataCompra() {
        return DataCompra;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setProdutos(List<Produto> produtos) {
        Produtos = produtos;
    }

    public void setDataCompra(LocalDate dataCompra) {
        DataCompra = dataCompra;
    }

    public void setCliente(Cliente cliente) {
        Cliente = cliente;
    }
}
