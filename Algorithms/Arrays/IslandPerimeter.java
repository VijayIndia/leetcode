public class Solution 
{
    public int islandPerimeter(int[][] grid) 
    {
        int count=0;
        int max_row=grid.length;
        int max_column=grid[0].length;
        for(int row=0;row<max_row;row++)
            {
                for(int column=0;column<max_column;column++)      
                    {
                        if(grid[row][column]==1)
                            {
                                if(row-1<0 || grid[row-1][column]==0)
                                   {
                                       count++;
                                   }
                                if(column-1<0 || grid[row][column-1]==0)
                                {
                                    count++;
                                }
                                if((row+1>=max_row) || ((row+1<max_row) && grid[row+1][column]==0))
                                    {
                                        count++;
                                    }
                                if((column+1>=max_column) || ((column+1<max_column) && grid[row][column+1]==0))
                                    {
                                        count++;
                                       
                                    }
                            }
                    }
                    System.out.println(count);
            }
      return count;
    }
}