class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxCount = 0;
        int count = 0;
        int l = s.length();
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < l; right++) {
            char ch = s.charAt(right);
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                count--;
                left++;
            }
            set.add(ch);
            count++;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}