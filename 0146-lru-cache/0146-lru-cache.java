class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value= value;
        }

        
    }

    HashMap<Integer,Node> map;
        int capacity;
        Node head;
        Node tail;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      map=new HashMap<>();

      head=new Node(-1,-1);
      tail = new Node(-1,-1);

      head.next=tail;
      tail.prev=head;

        
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){

            Node curr= map.get(key);
            Node prevnode = curr.prev;
            Node nextnode = curr.next;

            
            prevnode.next=nextnode;
            nextnode.prev = prevnode;


            Node last = tail.prev;
            curr.prev=last;
            last.next=curr;


            curr.next=tail;
            tail.prev=curr;


            return curr.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){

            Node curr = map.get(key);

            Node prevnode = curr.prev;
            Node nextnode = curr.next;

            prevnode.next=nextnode;
            nextnode.prev=prevnode;

            curr.value=value;

            Node last = tail.prev;

            curr.prev=last;
            last.next=curr;


            curr.next=tail;
            tail.prev=curr;

        }

        else{

            Node newNode = new Node(key,value);

            if(map.size()==capacity){

                Node curr=head.next;
                Node nextnode = curr.next;

                nextnode.prev=head;
                head.next=nextnode;

                int data = curr.key;
                map.remove(data);
                
            }

            Node last = tail.prev;

            last.next=newNode;

            newNode.prev=last;
            newNode.next=tail;

            tail.prev=newNode;
            
            map.put(key,newNode);
            
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */