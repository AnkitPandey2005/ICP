class Solution {
    public boolean checkInclusion(String p, String s) {
        if (p.length() > s.length()) return false;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray())
            pCount[c - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;

            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                return true;
            }
        }
        return false;
    }
}
