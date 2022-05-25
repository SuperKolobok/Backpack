import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backpack {
  public static void main(String[] args) {
    int maxWeight = 10;
    int capacity = 3;
    int[] weights = {1, 4, 8};
    int amount = (int) (Math.pow(2, capacity) - 1);
    List<int[]> list = new ArrayList<>();
    int[] sum = new int[amount];

    for (int i = 0; i < amount; i++) {
      String binaryString = String.format("%" + capacity + "s", Integer.toBinaryString(i + 1)).replace(" ", "0");
      int[] temp = new int[capacity];
      int sumOfArray = 0;
      for (int j = 0; j < capacity; j++) {
        if (binaryString.charAt(j) - 48 == 0) {
          temp[j] = 0;
        } else {
          temp[j] = weights[j];
        }
        sumOfArray += temp[j];
      }
      list.add(temp);
      sum[i] = sumOfArray;
    }

    int max = sum[0];
    int index = 0;
    for (int i = 1; i < sum.length; i++) {
      if (sum[i] > max && sum[i] <= maxWeight) {
        max = sum[i];
        index = i;
      }
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println(Arrays.toString(list.get(i)));
    }
    System.out.println(Arrays.toString(sum));
    System.out.println(max);
    System.out.println(Arrays.toString(list.get(index)));
  }
}
