import java.io.*;
import java.util.Arrays;
public class GFG {
public static int Solution(int[] arr)
{
int n = arr.length;
// If length of array is even
if (n % 2 == 0)
{
int z = n / 2;
int e = arr[z];
int q = arr[z - 1];
int ans = (e + q) / 2;
return ans;
}
// If length if array is odd
else
{
int z = Math.round(n / 2);
return arr[z];
}
}