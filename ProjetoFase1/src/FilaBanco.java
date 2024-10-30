import java.util.HashSet;

public class FilaBanco implements FilaBancoInterface {
    Node head;
    Node tail;
    int size;

    //Construtor
    public FilaBanco(Node head, Node tail, int size) {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // checa se tá vazia
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    // imprime a lista.
    // O(n)
    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
            return;
        }

        Node aux = this.head;

        while (aux != null) {
            System.out.println("Nome: " + aux.cliente.getNome() + " CPF: " + aux.cliente.getCpf());
            aux = aux.next;
        }
    }

    // adc no início da lista
    // O(1)
    @Override
    public void addFirst(Cliente cliente) {
        Node novo = new Node(cliente);
        if (isEmpty()) {
            this.head = novo;
            this.tail = novo;
        } else {
            novo.next = this.head;
            this.head = novo;
        }
        this.size += 1;
    }

    // adc no fim da lista
    // O(1)
    @Override
    public void addLast(Cliente cliente) {
        Node novo = new Node(cliente);

        if (isEmpty()) {
            this.head = novo;
        } else {
            this.tail.next = novo;
        }
        this.tail = novo;
        this.size += 1;
    }

    // adiciona um cliente em uma posicao espicifica
    // O(n)
    @Override
    public void add(int index, Cliente cliente) {
        Node novo = new Node(cliente);
        // checa se o índice é válido
        if (index < 0 || index > this.size) {
            return;
        }
        // checa se a lista tá vazia
        if (isEmpty()) {
            this.head = novo;
            this.tail = novo;
        }
        // começa checando se o indice é zero, pq se for é só chamar o addFirst
        if (index == 0) {
            addFirst(cliente);
        }
        // checa se o índice representa o último da lista, se for, chama addLast
        else if (index == this.size) {
            addLast(cliente);
        }
        // se não for nenhuma das condições anteriores, entra no else que vai adicionar em algum
        // lugar específico do encadeiamento
        else {
            Node aux = this.head;
            for (int i = 0; i < index - 1; i++) {
                aux = aux.next;
            }
            novo.next = aux.next;
            aux.next = novo;
            this.size += 1;
        }
    }

    @Override
    public void removeFirst() {
        if (isEmpty()) {
            return;
        }
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }
        size -= 1;
    }

    // remove um cliente baseado no objeto que sera passado como parametro
    // O(n)
    @Override
    public void remove(Cliente cliente) {
        if (isEmpty()) {
            return;
        }
        Node aux = this.head;

        for (int i = 0; i < this.size - 1; i++) {
            if(this.head.cliente.equals(cliente)) {
                removeFirst();
            }else if (aux.next.cliente.equals(cliente)) {
                aux.next = aux.next.next;
                this.size -= 1;
                break;
            }
            aux = aux.next;
        }
    }

    // retorna uma String com o nome do cliente que divide a lista no meio. Se size for par
    // ele pega o cliente com indice maior dentre os dois do meio
    // O(n)
    @Override
    public String getNoDoMeio() {
        if (isEmpty()) {
            return "Lista vazia";
        }

        Node aux = this.head;

        if (this.size % 2 == 0) {
            for (int i = 0; i < (this.size / 2); i++) {
                aux = aux.next;
            }
        } else {
            for (int i = 0; i < (this.size - 1) / 2; i++) {
                aux = aux.next;
            }
        }
        return aux.cliente.getNome();
    }

    // le todas a cadeia de clientes e remove aqueles que tiverem o atributo Cliente do Node igual
    // O(n)
    @Override
    public void removeDuplicates() {
        if (isEmpty()) {
            return;
        }
        Node aux = this.head;
        HashSet<Cliente> hash = new HashSet<>();
        while (aux != null) {
            if (hash.contains(aux.cliente)) {
                remove(aux.cliente);
            } else {
                hash.add(aux.cliente);
            }
            aux = aux.next;
        }
    }


    //nao ta funcionando, ta invertendo apenas o head com o tail mas nao os demais elementos
    // O(n)
    @Override
    public void printReverse() {
        if (isEmpty()) {
            return;
        }

        // francinaldo -> pablo -> talles -> gabryell -> ademario -> dudu
        // pablo -> francinaldo
        // dudu -> ademario -> gabryell -> talles -> pablo -> francinaldo

        Node atual = this.head;
        Node prev = null;
        Node next = null;
        while (atual != null) {
            next = atual.next;
            atual.next = prev;
            prev = atual;
            atual = next;
        }
        this.head = prev;
        this.tail = this.head;

        print();
    }

}
