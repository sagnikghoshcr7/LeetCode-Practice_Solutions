class ProductOfNumbers {
    ArrayList<Integer> A = new ArrayList(){{
        add(1);
    }};

    public void add(int a) {
        if (a > 0)
            A.add(A.get(A.size() - 1) * a);
        else {
            A = new ArrayList();
            A.add(1);
        }
    }

    public int getProduct(int k) {
        int n = A.size();
        return k < n ? A.get(n - 1) / A.get(n - k - 1)  : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */