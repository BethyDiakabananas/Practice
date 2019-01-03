public class Solution {
    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 2; i < a; i++) {
            if (isPrime(i) && isPrime(a - i)) {
                arr.add(i);
                arr.add(a - i);
                return arr;
            }
        }
        return arr;
    }

    public boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
