public class SomeFunctions {
    public boolean isPalindrome(String txt){
        for (int i = 0; i < txt.length()/2; i++) {
            if (txt.charAt(i) != txt.charAt(txt.length()-1-i)) return false;
        }
        return true;
    }

    public int minSplit(int amount){
        int [] coinTypes = {50, 20, 10, 5, 1};
        int coinCount = 0;
        int currCoinType = 0;
        while (amount != 0) {
            if (amount / coinTypes[currCoinType] > 0) {
                coinCount += amount / coinTypes[currCoinType];
                amount = amount % coinTypes[currCoinType];
                currCoinType++;
                continue;
            }
            if (amount / coinTypes[currCoinType] == 0) {
                currCoinType += 1;
            }
        }
        return coinCount;
    }

    // returns -1 in case no legit value is found
    public int notContains(int[] array){
        int min = Integer.MAX_VALUE;
        for (int j : array) {
            if (j < min && j > 0) {
                min = j;
            }
        }
        return min > 1 ? min - 1: -1;
    }

    public boolean isProperly(String sequence){
        // if this dude becomes negative or is anything but zero at the end of the loop return false
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == '('){
                count++;
            }
            else if (sequence.charAt(i) == ')'){
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;
    }

    public int countVariants(int stairsCount){
        if (stairsCount == 1) return 1;
        else if (stairsCount == 2) return 2;
        else if(stairsCount <= 0) return 0;
        else {
            return countVariants(stairsCount-1) + countVariants(stairsCount-2);
        }
    }


    public static void main(String[] args) {
        SomeFunctions s = new SomeFunctions();

    }
}
