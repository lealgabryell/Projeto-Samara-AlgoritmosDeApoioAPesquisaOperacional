public class Node {
    Node next;
    Cliente cliente;

    public Node(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
