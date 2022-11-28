class LList1 {
    public static void main(String[] args) {
        LList nums = new LList();
        nums.add(45);
        nums.add(465);
        nums.add(48);
        nums.add(5);
        System.out.println(nums);
    }
}

class LList{
    LNode head; // pointer to a LNode in memory
    public LList(){
        head = null;
    }
    public void add(int n){
        LNode tmp = new LNode(n, head);
        head = tmp;
    }
    @Override
    public String toString(){
        String ans = "";
        LNode tmp = head;
        while(tmp != null){
            ans += tmp + ", ";
            tmp = tmp.getNext();
        }
        if(ans != ""){
            ans = ans.substring(0, ans.length() - 2);
        }
        return "<" + ans + ">";
    }
}

class LNode{
    private int val;
    LNode next; // point to a LNode in memory

    public LNode(int v, LNode n){
        val = v;
        next = n;
    }
    public int getVal(){
        return val;
    }
    public LNode getNext(){
        return next;
    }
    @Override
    public String toString(){
        return "" + val;
    }
}