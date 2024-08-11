public abstract class Hash {
    protected Object[] table;
    protected int size;

    // Construtor
    public Hash(int capacity) {
        table = new Object[capacity];
        size = 0;
    }

    // Adiciona um elemento na tabela de hash
    public abstract void add(Object o);

    // Verifica se a tabela contém um elemento
    public abstract boolean contains(Object o);

    // Remove um elemento da tabela de hash
    public abstract boolean remove(Object o);
}
