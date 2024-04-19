using System;

public class MainClass {
    public static void Main(string[] args) {
        string input = Console.ReadLine();
        string[] parts = input.Split('-');
        int res = int.MaxValue;
        foreach (string part in parts) {
            int temp = 0;
            string[] nums = part.Split('+');
            foreach (string num in nums) {
                temp += int.Parse(num);
            }
            if (res == int.MaxValue)
                res = temp;
            else
                res -= temp;
        }
        Console.WriteLine(res);
    }
}
