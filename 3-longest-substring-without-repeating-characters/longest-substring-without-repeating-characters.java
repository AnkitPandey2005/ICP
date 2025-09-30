class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxans = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> sc = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (sc.contains(s.charAt(j))) {
                    break;
                }
                sc.add(s.charAt(j));
            }
            maxans = Math.max(maxans, sc.size());
        }
        return maxans;
    }
}
