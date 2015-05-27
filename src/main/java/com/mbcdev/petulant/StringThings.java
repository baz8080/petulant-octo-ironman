package com.mbcdev.petulant;

import java.util.HashMap;
import java.util.Map;

/**
 * A collection of functions for operating on Strings.
 *
 * Created by barry on 22/05/15.
 */
public class StringThings {

    /**
     * Reverses a string
     *
     * @param stringToReverse The string to reverse
     * @return The reversed string, or null if the argument was null
     */
    public String reverse(String stringToReverse) {

        if (stringToReverse == null) {
            return null;
        }

        String trimmedStringToReverse = stringToReverse.trim();

        if (trimmedStringToReverse.length() == 0) {
            return "";
        }

        char[] reversed = new char[trimmedStringToReverse.length()];

        for (int i = 0; i <= trimmedStringToReverse.length() / 2; i++) {
            reversed[i] = trimmedStringToReverse.charAt(trimmedStringToReverse.length() - 1 - i);
            reversed[reversed.length - i - 1] = trimmedStringToReverse.charAt(i);
        }

        return new String(reversed);
    }

    /**
     * Performs a simple string compression.
     * <p/>
     * abba will become ab2a
     *
     * @param stringToCompress The string to compress
     * @return The compressed string or null if the argument was null
     */
    public String compress(String stringToCompress) {

        if (stringToCompress == null) {
            return null;
        }

        int characterCount = 1;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stringToCompress.length(); i++) {

            if (i == stringToCompress.length() - 1) {
                sb.append(stringToCompress.charAt(stringToCompress.length() - 1));

                if (characterCount > 1) {
                    sb.append(characterCount);
                }

            } else if (stringToCompress.charAt(i + 1) == stringToCompress.charAt(i)) {
                characterCount++;
            } else {

                sb.append(stringToCompress.charAt(i));

                if (characterCount > 1) {
                    sb.append(characterCount);
                }

                characterCount = 1;
            }

        }

        return sb.toString();
    }

    /**
     * Finds the first non-repeating non-whitespace character in a string
     *
     * @param stringToSearch The string to search
     * @return The first non repeating character or null if the argument was null or empty
     */
    public Character findFirstNonRepeatingCharacter(String stringToSearch) {

        if (stringToSearch == null) {
            return null;
        }

        String noWhiteSpace = stringToSearch.replaceAll("\\s", "");

        if (noWhiteSpace.length() == 0) {
            return null;
        }

        Map<Character, Integer> characterCount = new HashMap<>();

        char[] characters = noWhiteSpace.toCharArray();

        for (char currentCharacter : characters) {

            Integer count = characterCount.get(currentCharacter);

            if (count == null) {
                characterCount.put(currentCharacter, 1);
            } else {
                characterCount.put(currentCharacter, count + 1);
            }
        }

        Character firstNonRepeating = null;

        for (int i = 0; i < characters.length && firstNonRepeating == null; i++) {
            Integer count = characterCount.get(characters[i]);

            if (count == 1) {
                firstNonRepeating = characters[i];
            }
        }

        return firstNonRepeating;
    }

    /**
     * Rotates the characters in a string by a given amount using character manipulation.
     * <p/>
     * If the input is "hello" and we rotate it by 2, then it becomes:
     *
     * <ul>
     *     <li>h -> j</li>
     *     <li>e -> g</li>
     *     <li>l -> n</li>
     *     <li>l -> n</li>
     *     <li>o -> q</li>
     * </ul>
     *
     * <p/>
     * If the rotation wraps past 'z' we start add it to 'a'. For example if we
     * rotate "zoo" by 2 it becomes:
     *
     * <ul>
     *     <li>z -> b</li>
     *     <li>o -> q</li>
     *     <li>o -> q</li>
     * </ul>
     *
     * <p/>
     * This function only operates on a-z and A-Z. Other characters are not rotated.
     *
     * @param stringToRotate The string to rotate
     * @param rotation The number of characters to rotate by, may be positive or negative
     * @return The rotated string or null if the argument string was null.
     */
    public String rotateByN(String stringToRotate, int rotation) {

        if (stringToRotate == null) {
            return null;
        }

        stringToRotate = stringToRotate.trim();

        if (stringToRotate.length() == 0) {
            return "";
        }

        if (rotation < 0) {
            rotation = 26 + (rotation % 26);
        } else if (rotation > 26) {
            rotation = rotation % 26;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (char currentChar : stringToRotate.toCharArray()) {

            if (Character.isLowerCase(currentChar)) {

                if (currentChar + rotation > 'z') {
                    int overshot = ((currentChar + rotation) - 'z') - 1;
                    stringBuilder.append((char)('a' + overshot));
                } else {
                    stringBuilder.append((char)(currentChar + rotation));
                }

            } else if (Character.isUpperCase(currentChar)) {

                if (currentChar + rotation > 'Z') {
                    int overshot = ((currentChar + rotation) - 'Z') - 1;
                    stringBuilder.append((char)('A' + overshot));
                } else {
                    stringBuilder.append((char)(currentChar + rotation));
                }

            } else {
                stringBuilder.append(currentChar);
            }

        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        // Empty
    }
}
