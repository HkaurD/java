public class BTreeEx1 {
    public static void main(String[] args){
        BTree oak = new BTree();
        oak.add(321);
        oak.add(32);
        oak.add(21);
        oak.add(76);
        oak.add(9);
        oak.add(50);
        System.out.println(oak.toString());
        System.out.println(oak.depth(76));
        System.out.println(oak.display(BTree.PRE));
        System.out.println(oak.countLeaves());
        System.out.println(oak.height());
    }
}

class BTree{
    public static final int PRE = 0, IN = 1, POST = 2;
    BNode root;

    public BTree(){
        root = null;
    }

    public void add(int v){
        // since binary trees have a recursive pattern, one brach, two,... so I can recursively check each element to check
        // if either the left or right node are null
        // if there are duplicates, ignore them
        if(root == null){
            root = new BNode(v); // starting the binary tree
        } else {
            add(v, root);
        }
    }

    public void add(int v, BNode branch){
        if(v < branch.val){ // if it's smaller than the current value
            if(branch.left == null){ // if the current element doesn't have a left element, add the new element there
                branch.left = new BNode(v); // making the node
            }
            else{
                add(v, branch.left); // recursive; check in the next element that's the current element's left
            }
        } else if(v > branch.val){ // if it's
            if(branch.right == null){ // attach
                branch.right = new BNode(v);
            }
            else{
                add(v, branch.right);
            }
        }
    }

    public int depth(int v){ // O(lgn)
        return depth(v, root);
    }

    // Takes an integer and returns the depth where the integer is found. Returns -1 if not found.
    public int depth(int v, BNode branch){
        if(branch == null){ // if the value is not found in the tree since the tree is either empty or has already been traversed
            return -1;
        } else if(branch.val == v){ // if the value is found
            return 1;
        }
        else { // continuing to traverse the tree
            int dep;
            if(v < branch.val){
                dep = depth(v, branch.left);
            } else {
                dep = depth(v, branch.right);
            }
            if(dep == -1){
                return -1;
            } else{
                return dep + 1; // increasing the depth each time it goes down a level in the binary tree
            }
        }
    }

    public int countLeaves(BNode branch){
        if(branch == null){ // empty tree
            return 0;
        } else if(branch.left == null && branch.right == null){
            return 1;
        } else{
            return countLeaves(branch.left) + countLeaves(branch.right);
        }
    }

    public int countLeaves(){ // O(n)
        return countLeaves(root);
    }

    public int height(BNode branch){
        if(branch == null){ // empty tree
            return 0;
        } else{
            return Math.max(height(branch.left), height(branch.right)) + 1;
        }
    }

    public int height(){ // O(n)
        return height(root);
    }

    public String display(int ord){
        String ans;

        if(ord == PRE){
            ans = stringifyPre(root);
        } else if(ord == IN){
            ans = stringify(root);
        } else{
            ans = stringifyPost(root);
        }

        if (ans != "") {
            ans = ans.substring(2); // no comma at the start
        }
        return "{" + ans + "}";
    }

    public String display(){ // O(n)
        return display(IN);
    }

    public String stringifyPre(BNode branch){
        if(branch == null){
            return "";
        } else{
            return ", " + branch.val +
                    stringifyPre(branch.left) +
                    stringifyPre(branch.right);
        }
    }

    public String stringifyPost(BNode branch){
        if(branch == null){
            return "";
        } else{
            return stringifyPre(branch.left) +
                    stringifyPre(branch.right) +
                    ", " + branch.val;
        }
    }

    public String stringify(BNode branch){
        if(branch == null){
            return "";
        } else{
            return stringify(branch.left) +
                    ", " + branch.val +
                    stringify(branch.right);
        }
    }

    @Override
    public String toString(){
        String ans =  stringify(root);
        if (ans != "") {
            ans = ans.substring(2); // no comma at the start
        }
        return "{" + ans + "}";
    }
}

class BNode{
    int val;
    BNode left, right;

    public BNode(int v){
        left = right = null;
        val = v;
    }

    @Override
    public String toString(){
        return "" + val;
    }
}