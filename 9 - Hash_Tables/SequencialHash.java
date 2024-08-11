public class SequencialHash extends Hash {

    public SequencialHash(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Object o) {
        int index = o.hashCode() % table.length;
        while (table[index] != null) {
            index = (index + 1) % table.length;
        }
        table[index] = o;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % table.length;
        while (table[index] != null) {
            if (table[index].equals(o)) {
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = o.hashCode() % table.length;
        while (table[index] != null) {
            if (table[index].equals(o)) {
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1) % table.length;
        }
        return false;
    }
}
