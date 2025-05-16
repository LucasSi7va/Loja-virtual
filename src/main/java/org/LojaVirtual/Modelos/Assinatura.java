package org.LojaVirtual.Modelos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Assinatura {
    BigDecimal MENSALIDADE;
    LocalDate Begin;
    LocalDate End;
    Cliente Cliente;

    public Assinatura(BigDecimal MENSALIDADE, LocalDate begin, LocalDate end, Cliente cliente) {
        this.MENSALIDADE = MENSALIDADE;
        Begin = begin;
        End = end;
        Cliente = cliente;
    }

    public Assinatura(BigDecimal MENSALIDADE, LocalDate begin, Cliente cliente) {
        this.MENSALIDADE = MENSALIDADE;
        Begin = begin;
        Cliente = cliente;
    }
}
