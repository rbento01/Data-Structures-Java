public class QuadraticHash extends Hash {

    public QuadraticHash(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Object o) {
        int index = o.hashCode() % table.length;
        int i = 0;
        while (table[(index + i * i) % table.length] != null) {
            i++;
        }
        table[(index + i * i) % table.length] = o;
        size++;
    }

    @Override
    public boolean contains(Object o) {
        int index = o.hashCode() % table.length;
        int i = 0;
        while (table[(index + i * i) % table.length] != null) {
            if (table[(index + i * i) % table.length].equals(o)) {
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = o.hashCode() % table.length;
        int i = 0;
        while (table[(index + i * i) % table.length] != null) {
            if (table[(index + i * i) % table.length].equals(o)) {
                table[(index + i * i) % table.length] = null;
                size--;
                return true;
            }
            i++;
        }
        return false;
    }
}
