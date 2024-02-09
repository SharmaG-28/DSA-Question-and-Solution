import java.util.Scanner;

class firstOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the haystack string: ");
        String haystack = scanner.nextLine();
        
        System.out.print("Enter the needle string: ");
        String needle = scanner.nextLine();
        
        Solution solution = new Solution();
        int index = solution.strStr(haystack, needle);
        
        System.out.println("Index of needle in haystack: " + index);
        
        scanner.close();
    }
}
    
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty())
            return -1;
        for(int i=0; i<=(haystack.length()-needle.length()); i++){
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}