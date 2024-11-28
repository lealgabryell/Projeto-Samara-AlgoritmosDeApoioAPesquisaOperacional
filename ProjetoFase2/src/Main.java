import MochilaBinaria.Item;
import MochilaBinaria.Mochila;
import MochilaBinaria.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Utils utils = new Utils();


        List<Item> itens = new ArrayList<Item>();
        Mochila mochila = new Mochila(itens,50.0);

        //Itens a serem avaliado se podem entrar na mochila
        Item itemA = new Item("A", 10.0, 60.0);
        Item itemB = new Item("B", 20.0, 100.0);
        Item itemC = new Item("C", 30.0, 120.0);

        //Adiciona itens criados a lista de itens
        itens.add(itemB);
        itens.add(itemC);
        itens.add(itemA);

        //adiciona itens a mochila apos verifica-los
        utils.addMochilaGuloso(mochila, itens);

        //imprime o que ha dentro da mochila
        utils.printMochila(mochila);

    }
}