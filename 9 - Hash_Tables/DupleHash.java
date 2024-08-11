public class DupleHash extends Hash {

    public DupleHash(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Object o) {
        int index1 = o.hashCode() % table.length;
        int index2 = 1 + (o.hashCode() % (table.length - 1)); // Para garantir que index2 não seja zero
        int i = 0;
        int index = (index1 + i * index2) % table.length;
        while (table[index] != null) {
            i++;
            index = (index1 + i * index2) % table.length;
        }
        table[index] = o;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        int index1 = o.hashCode() % table.length;
        int index2 = 1 + (o.hashCode() % (table.length - 1));
        int i = 0;
        int index = (index1 + i * index2) % table.length;
        while (table[index] != null) {
            if (table[index].equals(o)) {
                return true;
            }
            i++;
            index = (index1 + i * index2) % table.length;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index1 = o.hashCode() % table.length;
        int index2 = 1 + (o.hashCode() % (table.length - 1));
        int i = 0;
        int index = (index1 + i * index2) % table.length;
        while (table[index] != null) {
            if (table[index].equals(o)) {
                table[index] = null;
                size--;
                return true;
            }
            i++;
            index = (index1 + i * index2) % table.length;
        }
        return false;
    }
}
