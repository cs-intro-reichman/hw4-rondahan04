/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {
    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c','l','e','a','r','l','y'};
        char[] arr2 = {'U','n','d','e','r','s','t', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1,2));      
        System.out.println(indexOf(arr1,'l'));  
        System.out.println(indexOf(arr1,'l',3)); 
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /** Prints the given array of characters, and moves the cursor to the next line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /** Returns the char value at the specified index. Assume that the array is non-empty.
     */
    public static char charAt(char[] arr, int index) {
            return arr[index];
    }

    /** If the two arrays have the same value in every index, 
     *  returns true; Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length == 0 && arr2.length == 0){ // they are both empty
            return true;
        }
        if (arr1.length == arr2.length){ // if they are in the same length
            for (int i=0; i<arr1.length;i++){
                if(arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
       if (arr1.length < arr2.length){
        for (int i=0; i<arr1.length;i++){ // run on arr1
            if (arr1[i] != arr2[i]){ // they are not equal
                return false;
            }
        }  
        } // if you exited the loop they are equal
        if (arr2.length < arr1.length){
            for (int i=0; i<arr2.length;i++){ // run on arr2
                if (arr2[i] != arr1[i]){ // they are not equal
                    return false;
                }
            }
        }   
        return true;  
    }

    /** Returns the index within the given array of the first occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        if ( arr.length == 0 ) { //array is empty
            return -1;
        }
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /** Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i=fromIndex;i<arr.length;i++){
            if (arr[i] == ch){
                return i;
            }
        }
        return -1;
    }

    /** Returns the index within the given arr of the last occurrence of the given character.
     *  If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length-1; i>0; i--) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /* Returns an array which is the concatanation of the two given arrays.
    */
    public static char[] concat(char[] arr1, char[] arr2) {
        int duplicateindex = 0;
        char[] duplicate = new char [arr1.length + arr2.length]; // the new array
       for ( int i = 0 ; i< arr1.length ; i++){ // runs on array 1 , if its 0 then it doesnt enter
              duplicate[duplicateindex] = arr1[i];
              duplicateindex++;
       }
       for (int j = 0;j<arr2.length; j++){ // runs on array 2 , if its 0 then it doesnt enter
              duplicate[duplicateindex] = arr2[j];
              duplicateindex++;
       }
        return duplicate;
    }

    /** Returns a new array that can be described as a sub-array of this array.
     *  The sub-array begins at the specified beginIndex and extends to the character at index endIndex - 1.
     *  For example, if arr contains the characters "hamburger", then subArray(4, 8) returns an array of
     *  characters containing the characters "urge".
     */     
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] subchar = new char [arr.length]; // the new array
        int subcharindex = 0; // its index
        for (int i = beginIndex;i<endIndex;i++){ // runs on arr
            subchar[subcharindex]=arr[i];
            subcharindex++;
        }
        return subchar;
    }

     /** Returns a single integer that represents the given array. This integer is sometimes 
     *  referred to as the array's "hash code". Later in the course we'll explain what these 
     *  hash codes are used for. For now, simply implement the specification given below.
     *  The hash code is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 + arr[n-1]
     *  where arr[i] is the i'th character of the array, and n is the array's length.
     *  The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) { 
        if (arr.length == 0){ // if the array is empty
            return 0;
        }
        long hash = 0; // the hash code
        for (int i = 0; i<arr.length; i++){ // runs on the array
            hash += arr[i] * Math.pow(7, arr.length-1-i); // the formula
        }
        return hash;
    }

    /**
     * Compares the two strings lexicographically.
     * Assume that both strings are not empty.
     * 
     * Characters are compared one by one from left to right, using their numeric Unicode values,
        as follows:
     * 1. If two characters at the same position in both strings are different,
     *    the string with the smaller character is considered lexicographically smaller.
     * 2. If all characters in the shorter string match the corresponding characters
     *    in the longer string, the shorter string is considered lexicographically smaller.
     * 3. If both strings have the same characters and the same length, they are considered equal.
     * 
     * Examples:
     * - "apple" is less than "banana" because 'a' comes before 'b'.
     * - "abc" is less than "abcd" because it is shorter.
     * - "hello" is equal to "hello".
     * - "date" is greater than "dark" because 't' comes after 'k'.
     * 
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2,
     *         zero if they are equal, and 1 if str1 is
     *         lexicographically greater than str2.
     *         return -2 if there is an error with the input.
     */
    public static int compareTo(String str1, String str2) {
        if (str1.length() == 0 || str2.length() == 0){ // if one of the strings is empty
            return -2;
        }
        int min = Math.min(str1.length(), str2.length()); // the minimum length
        for (int i = 0; i<min; i++){ // runs on the strings
            if (str1.charAt(i) < str2.charAt(i)){ // if the first string is smaller
                return -1;
            }
            if (str1.charAt(i) > str2.charAt(i)){ // if the second string is smaller
                return 1;
            }
        }
        if (str1.length() < str2.length()){ // if the first string is smaller
            return -1;
        }
        if (str1.length() > str2.length()){ // if the second string is smaller
            return 1;
        }
        return 0;
    }
}
