package MochilaBinaria;

import java.util.List;

public class Mochila {
    List<Item> itens;
    Double capacidade;

    public Mochila(List<Item> itens, Double capacidade) {
        this.itens = itens;
        this.capacidade = capacidade;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
