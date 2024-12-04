package MochilaBinaria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    //Compara se o primeiro item é maior que o segundo item.
    public boolean compare(Item itemA, Item itemB) {
        return itemA.valorPeso < itemB.valorPeso;
    }

    //Metodo para reordenar os itens da lista baseado na relação Valor/Peso
    //Algoritimo de ordenacao utilizado foi o Bubble Sort com custo quadratico (O(n^2))
    public void sort(List<Item> lista) {
        //Item auxiliador: Vai servir para guardar o item a ser substituido
        Item aux;
        //Itera a lista a partir do primeiro item
        for (int i = 0; i <= lista.size() - 1; i++) {
            //Itera a mesma lista, mas a partir do item que esta na frente do inicial
            for (int j = i + 1; j <= lista.size() - 1; j++) {
                //Chama a funcao de comparar e garante qual dos itens tem maior valor/peso
                if (compare(lista.get(i), lista.get(j))) {
                    //guarda o valor do item que vai mudar de lugar no aux
                    aux = lista.get(j);
                    //Modifica o valor do item da frente para o item de tras
                    lista.set(j, lista.get(i));
                    lista.set(i, aux);
                }
            }
        }
        System.out.println("Lista de itens reorganizada:");
        printList(lista);
    }

    public void addMochilaGuloso(Mochila mochila, List<Item> itens) {
        //Ordena os items da lista em ordem decrescente por valorPeso(valoer/peso).
        sort(itens);

        //Lista de itens a ser inserida na mochila
        List<Item> novosItens = new ArrayList<Item>();

        //variaveis de controle.
        Double pesoAdicionado = 0.0;
        Double valorAdicionado = 0.0;

        //verificador de capacidade
        Double capacidadeRestante = mochila.capacidade;

        //iteração na lista de itens (Custo: O(n)).
        for (Item item : itens) {
            //Verificação: Se o peso do item é menor ou igual a disponibilidade da mochila, entra na condição.
            if (item.peso <= capacidadeRestante) {
                //Peso é descontado na disponibilidade da mochila
                capacidadeRestante -= item.peso;
                //Valor dos itens dentro da mochila é incrementado pelo valor do item que entrou.
                valorAdicionado += item.valor;
                //Peso dos itens dentro da mochila é incrementado pelo peso do item que entrou
                pesoAdicionado += item.peso;

            } else if (capacidadeRestante == 0.0) {
                break;

                //Se o item tiver um peso maior do que o disponível.
            } else {
                //Variavel que define qual fração do item cabe na mochila
                Double frac = capacidadeRestante / item.peso;
                //Modifica o valor desse item baseado na fração que cabe dentro da mochila.
                item.setFrac(frac);
                //Valor dos itens dentro da mochila é incrementado pelo valor do item que entrou.
                valorAdicionado += item.valor;
                //Peso dos itens dentro da mochila é incrementado pelo peso do item que entrou
                pesoAdicionado += item.valor;
            }
            novosItens.add(item);
        }
        //Inicialmente, nosso objeto mochila foi criado com uma lita vazia de itens. Nessa linha do codigo,
        //modificamos esse estado para que agora a lista de itens seja a lista que ajustamos anteriormente.
        mochila.setItens(novosItens);
    }

    public void printList(List<Item> itens) {
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(itens.get(i).identificador + "-> valor: " + itens.get(i).valor +
                    " peso: " + itens.get(i).peso + " valor/peso: " + itens.get(i).valorPeso);
        }
    }

    public void printMochila(Mochila mochila) {
        Double somaValor = 0.0;
        System.out.println("Mochila:");
        for (int i = 0; i < mochila.itens.size(); i++) {
            System.out.println(mochila.itens.get(i).identificador + "-> peso: " + mochila.itens.get(i).peso);
            somaValor += mochila.itens.get(i).valor;
        }
        System.out.println("Valor total da mochila: " + somaValor);
    }

}
