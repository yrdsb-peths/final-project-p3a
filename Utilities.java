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
    
    // MergeSort code: Sorts from least -> greatest
    public static void mergeSort(ArrayList<Integer> arr)
    {
        int[] tempArr = new int[arr.size()];
        mergeSortHelper(arr, 0, arr.size() - 1, tempArr);
    }
    private static void mergeSortHelper(ArrayList<Integer> arr, int from, int to, int[] tempArr)
    {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, tempArr);
            mergeSortHelper(arr, mid + 1, to, tempArr);
            merge(arr, from, mid, to, tempArr);
        }
    }
    private static void merge(ArrayList<Integer> arr, int from, int mid, int to, int[] tempArr)
    {
        int i = from;
        int j = mid + 1;
        int k = from;
        
        while (i <= mid && j <= to)
        {
            if (arr.get(i) < arr.get(j))
            {
                tempArr[k] = arr.get(i);
                i++;
            }
            else
            {
                tempArr[k] = arr.get(j);
                j++;
            }
            k++;
        }
        
        while (i<= mid)
        {
            tempArr[k] = arr.get(i);
            i++;
            k++;
        }
        
        while (j <= to)
        {
            tempArr[k] = arr.get(j);
            j++;
            k++;
        }
        
        for (k = from; k<= to; k++)
        {
            arr.set(k, tempArr[k]);
        }
    }
}
