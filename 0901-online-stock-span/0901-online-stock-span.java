class pair{
    int money;
    int span;

    public pair(int money,int span){
        this.money=money;
        this.span=span;
    }
}
class StockSpanner {

    Stack<pair> s;

    public StockSpanner() {
        s= new Stack<>();
    }
    
    public int next(int price) {
        int days=1;
        while(!s.isEmpty() && s.peek().money<=price){
            pair curr = s.peek();
            days+=s.peek().span;
            s.pop();
        }

        s.push(new pair(price,days));

        return days;

    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */