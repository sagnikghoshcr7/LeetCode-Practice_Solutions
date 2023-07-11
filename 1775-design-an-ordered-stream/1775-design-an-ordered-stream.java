class OrderedStream {
    private String[] data;
    private int ptr;

    public OrderedStream(int n) {
        data = new String[n + 1];
        ptr = 1;
    }

    public String[] insert(int idKey, String value) {
        data[idKey] = value;
        List<String> res = new ArrayList<>();
        for (int i = ptr; i < data.length; i++) {
            if (data[i] != null) {
                res.add(data[i]);
            } else {
                ptr = i;
                break;
            }
        }
        return res.toArray(new String[0]);
    }
}