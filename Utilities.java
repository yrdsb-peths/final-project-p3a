import java.util.ArrayList;
/**
 * Write a description of class Utilities here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Utilities  
{   
    // Used to draw HP indicator onto screen
    public static void drawHP(Player pc)
    {
        for(int i = 0; i < Player.lives.length; i++)
        {
            pc.getWorld().addObject(Player.lives[i], (384*3 - (Lives.resizeX/2)) - (Lives.resizeX*i), 
                0 + (Lives.resizeY/2));
        }
    }
    // Used to draw score onto screen
    public static void drawScore(Player pc)
    {
        pc.getWorld().addObject(new ScoreCount(pc), 384*3 - ((144/5)*2), 68);
    }
    // MergeSort will sort from lowest -> greatest
    public static void mergeSort(ArrayList<Integer> arr)
    {
        int[] tempArr = new int[arr.size()];
        mergeSort(arr, tempArr, 0, arr.size()-1);
    }
    public static void mergeSort(ArrayList<Integer> arr, int[] tempArr, int low, int high)
    {
        if (low >= high)
        {
            return;
        }
        int mid = (low + high)/2;
        mergeSort(arr, tempArr, low, mid);
        mergeSort(arr, tempArr, mid + 1, high);
        merge(arr, tempArr, low, mid, high);
    }
    public static void merge(ArrayList<Integer> arr, int[] tempArr, int low, int mid, int high)
    {
        for (int i = low; i <= high; i++)
        {
            tempArr[i] = arr.get(i);
        }
        int j = low;
        int k = mid + 1;
        for (int i = low; i <= high; i++)
        {
            if (j > mid)
            {
                arr.set(i, tempArr[k++]);
            }
            else if (k > high)
            {
                arr.set(i, tempArr[low++]);
            }
            else if (tempArr[k] < tempArr[j])
            {
                arr.set(i, tempArr[k++]);
            }
            else
            {
                arr.set(i, tempArr[low++]);
            }
        }
    }
}
