package org.LojaVirtual.Modelos;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Produto {
   private String NOME;
    private Path FILE;
    private BigDecimal PRECO;

    public Produto(String NOME, Path FILE, BigDecimal PRECO) {
        this.NOME = NOME;
        this.FILE = FILE;
        this.PRECO = PRECO;
    }

    public String getNOME() {
        return NOME;
    }

    public Path getFILE() {
        return FILE;
    }

    public BigDecimal getPRECO() {
        return PRECO;
    }


    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public void setFILE(Path FILE) {
        this.FILE = FILE;
    }

    public void setPRECO(BigDecimal PRECO) {
        this.PRECO = PRECO;
    }
}
