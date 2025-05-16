package org.LojaVirtual;


import org.LojaVirtual.Modelos.Cliente;
import org.LojaVirtual.Modelos.Pagamento;
import org.LojaVirtual.Modelos.Produto;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;


public class App
{
    public static void main( String[] args ) throws InterruptedException {
      Produto p1 = new Produto("mouse" , null , new BigDecimal("99.00"));
        Produto p2 = new Produto("teclado" , null , new BigDecimal("199.00"));
        Produto p3 = new Produto("monitor" , null , new BigDecimal("299.00"));

      Cliente Cliente = new Cliente("Lucas");

    Pagamento pagamentoHoje = new Pagamento(
            Arrays.asList(p1),
            LocalDate.now(),
            Cliente
    );

    Pagamento pagamentoOntem = new Pagamento(
                Arrays.asList(p2),
                LocalDate.now().minusDays(1),
                Cliente
    );

    Pagamento pagamentoMesPassado = new Pagamento(
            Arrays.asList(p3) ,
            LocalDate.now().minusMonths(1),
            Cliente
    );

        System.out.println("Data do pagamento de Hoje: "  + pagamentoHoje.getDataCompra());
        System.out.println("Data do pagamento de ontem: " + pagamentoOntem.getDataCompra());
        System.out.println("Data do pagamento de semana passada: " + pagamentoMesPassado.getDataCompra());



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("/============================================================================/");



        Optional<BigDecimal> soma = Optional.ofNullable(
                p1.getPRECO().add(p2.getPRECO())
        );

        double Adicional = soma.map(BigDecimal::doubleValue).orElse(0.0);

        BigDecimal total = p1.getPRECO().add(p2.getPRECO().add(p3.getPRECO()));


        System.out.println("primeiro valor do pagamento: " + p1.getPRECO());
        System.out.println("segundo valor do pagamento: " + p2.getPRECO());
        System.out.println("terceiro valor do pagamento: " + p3.getPRECO());


        System.out.println("Valor do 1 produto e 2 produto com optional " + Adicional);
        System.out.println("Valor total do pagamento: " + total);




        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===================================================================================");



        List<Produto> todosProdutos = Arrays.asList(p1, p2, p3);

        Map<String, Integer> contadorProdutos = new HashMap<>();

        for (Produto produto : todosProdutos) {
            String nome = produto.getNOME();
            contadorProdutos.put(nome, contadorProdutos.getOrDefault(nome, 0) + 1);
        }

        System.out.println("Quantidade de cada produto vendido:");
        contadorProdutos.forEach((nome, qtd) ->
                System.out.println("Produto: " + nome + " | Quantidade: " + qtd)
        );



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===================================================================================");



        List<Pagamento> pagamentos = Arrays.asList(pagamentoHoje, pagamentoOntem, pagamentoMesPassado);

        Map<String, List<Produto>> produtosPorCliente = new HashMap<>();

        for (Pagamento pagamento : pagamentos) {
            String nomeCliente = pagamento.getCliente().getNOME();
            List<Produto> produtos = pagamento.getProdutos();


            produtosPorCliente
                    .computeIfAbsent(nomeCliente, k -> new ArrayList<>())
                    .addAll(produtos);
        }


        System.out.println("Produtos comprados por cada cliente:");
        produtosPorCliente.forEach((cliente, produtos) -> {
            System.out.println("Cliente: " + cliente);
            for (Produto produto : produtos) {
                System.out.println(" - Produto: " + produto.getNOME());
            }
        });





        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("===================================================================================");



        Map<String, BigDecimal> totalGastoPorProduto = new HashMap<>();

        for (Pagamento pagamento : pagamentos) {
            for (Produto produto : pagamento.getProdutos()) {
                String nomeProduto = produto.getNOME();
                BigDecimal preco = produto.getPRECO();

                totalGastoPorProduto.merge(nomeProduto, preco, BigDecimal::add);
            }
        }

        System.out.println("Produto mais gasto: " +
                totalGastoPorProduto.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .map(entry -> entry.getKey() + " - R$" + entry.getValue())
                        .orElse("Nenhum produto encontrado"));



    }

}
