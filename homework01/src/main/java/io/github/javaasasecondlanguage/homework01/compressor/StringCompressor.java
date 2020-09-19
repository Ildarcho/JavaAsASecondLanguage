package io.github.javaasasecondlanguage.homework01.compressor;

public class StringCompressor {
    /**
     * Given an array of characters, compress it using the following algorithm:
     *
     * Begin with an empty string s.
     * For each group of consecutive repeating characters in chars:
     * If the group's length is 1, append the character to s.
     * Otherwise, append the character followed by the group's length.
     * Return a compressed string.
     * </p>
     * Follow up:
     * Could you solve it using only O(1) extra space?
     * </p>
     * Examples:
     * a -> a
     * aa -> a2
     * aaa -> a3
     * aaabb -> a3b2
     * "" -> ""
     * null -> Illegal argument
     * 234 sdf -> Illegal argument
     *
     * @param str nullable array of chars to compress
     *            str may contain illegal characters
     * @return a compressed array
     * @throws IllegalArgumentException if str is null
     * @throws IllegalArgumentException if any char is not in range 'a'..'z'
     */
    public char[] compress(char[] str) {
        if (str == null) {
            throw new IllegalArgumentException("null string");
        }
        if (str.length == 0) {
            return str;
        }
        char currentChar = 0;
        int charCount = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            if (c < 'a' || c > 'z') {
                throw new IllegalArgumentException("illegal characters in the string");
            }
            if (c != currentChar) {
                if (charCount > 1) {
                    sb.append(charCount);
                }
                currentChar = c;
                charCount = 0;
                sb.append(currentChar);
            }
            charCount++;
        }
        if (charCount > 1) {
            sb.append(charCount);
        }
        return sb.toString().toCharArray();
    }
}
