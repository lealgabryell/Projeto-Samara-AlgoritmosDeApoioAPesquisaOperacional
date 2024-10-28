public interface FilaBancoInterface {
    public boolean isEmpty();
    public void print();
    public void add(int index, Cliente cliente);
    public void addFirst(Cliente cliente);
    public void addLast(Cliente cliente);
    public void remove(Cliente cliente);
    public String getNoDoMeio();
    public void removeDuplicates();
    public void printReverse();
}
