package ficha2;

public class IllimitedStack implements Stack{
    private Item topo;
    
    
    public IllimitedStack(){
        topo = null;
    }
    
    @Override
    public boolean isEmpty() {
        if(topo == null){
            return true;
        }
        else{
            return false;
        }  
    }

    @Override
    public void push(Object data) {
        Item item = new Item();
        item.data = data;
        item.next = topo;
        topo = item;
}

    @Override
    public Object pop() {
        if(isEmpty()){
            return null;
        }
        Object data = topo.data;
        topo = topo.next;
        return data;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            return null;
        }
        return topo.data;
    }
    private class Item{
        Object data;
        Item next;
    }
}
