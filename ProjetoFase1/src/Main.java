public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Francinaldo", "088.144.523-55");
        Cliente cliente2 = new Cliente("Pablo", "088.254.583-51");
        Cliente cliente3 = new Cliente("Talles", "788.266.632-89");
        Cliente cliente4 = new Cliente("Ademario", "199.566.325-89");
        Cliente cliente5 = new Cliente("Dudu", "199.265.632-76");
        Cliente cliente6 = new Cliente("Gabryell", "085.474.195-12");

        FilaBanco fila = new FilaBanco(null, null, 0);

        fila.add(0, cliente1);
        fila.add(1, cliente2);
        fila.add(2, cliente3);
        fila.add(3, cliente4);
        fila.add(4, cliente5);
        fila.add(5, cliente6);
        fila.add(6, cliente6);
        fila.print();
        System.out.println("------------------------\nAgora a lista com os items duplicados removidos:");
        fila.removeDuplicates();
        fila.print();
        System.out.println("------------------------\nAgora a lista com o cliente Talles removido:");
        fila.remove(cliente3);
        fila.print();
        System.out.println("------------------------\nAgora a lista com o cliente Francinaldo removido:");
        fila.remove(cliente1);
        fila.print();
        System.out.println("------------------------\nAgora o cliente que divide a lista (Ademario):");
        System.out.println(fila.getNoDoMeio());
        System.out.println("------------------------\nAgora a lista invertida:");
        fila.printReverse();

    }
}