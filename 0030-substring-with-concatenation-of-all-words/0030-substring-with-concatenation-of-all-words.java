class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
         List<Integer> res = new ArrayList<>();
        int w = words[0].length(), k = words.length, total = w * k, n = s.length();
        if (n < total) return res;
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) freq.put(word, freq.getOrDefault(word, 0) + 1);
        for (int offset = 0; offset < w; offset++) {
            int count = 0, left = offset;
            Map<String, Integer> window = new HashMap<>();
            for (int right = offset; right + w <= n; right += w) {
                String sub = s.substring(right, right + w);
                if (freq.containsKey(sub)) {
                    window.put(sub, window.getOrDefault(sub, 0) + 1);
                    count++;
                    // shrink window if overflow
                    while (window.get(sub) > freq.get(sub)) {
                        String leftWord = s.substring(left, left + w);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += w;
                        count--;
                    }
                    if (count == k) { 
                        res.add(left);
                        String leftWord = s.substring(left, left + w);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += w;
                        count--;
                    }
                } else { 
                    window.clear();
                    count = 0;
                    left = right + w;
                }
            }
        }
        return res;
    }
}