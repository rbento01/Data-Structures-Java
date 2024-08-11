package ficha2;

public class LimitedStack implements Stack{
    
    private int topo;
    private Object array[];
    
    public LimitedStack(int maxSize){
        topo = -1;
        array = new Object[maxSize];
    }
    
    @Override
    public boolean isEmpty() {

        if(topo == -1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void push(Object item) {
        topo = topo + 1;
        array[topo] = item;
    }

    @Override
    public Object pop() {
        if(isEmpty()){
            return null;
        }else{
            return array[topo--];//esta linha vai devolver o array[topo] e depois de returnar o topo fica menos uma unidade
        }
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }else {
            return array[topo];
        }
    }
}