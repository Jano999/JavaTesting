public class Main {
    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] oddNumbers = new int[numbers.length];
        int[] evenNumbers = new int[numbers.length];
        int oddCount = 0;
        int evenCount = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[evenCount] = numbers[i];
                evenCount++;
            } else {
                oddNumbers[oddCount] = numbers[i];
                oddCount++;
            }
        }

        System.out.println("Odd numbers:");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(oddNumbers[i] + " ");
        }

        System.out.println("\nEven numbers:");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
    }
}
