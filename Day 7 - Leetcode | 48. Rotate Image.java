class Solution {

    void swap(int[][] matrix, int i, int j)
    {
        // System.out.println("I'm called");
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
    }

    void transpose(int[][] matrix, int n,  int m)
    {
        for(int i=0; i<n ;i++)
        {
            for(int j=i+1; j<m ;j++)
            {  
                swap(matrix, i, j);
            }
        }
    }

    void reverseRows(int[][] matrix, int n, int m)
    {
        for(int i=0; i<n ;i++)
        {
            for(int j=0; j<m/2 ;j++)
            {  
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][m-j-1];
                matrix[i][m-j-1] = t;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n=matrix.length, m = matrix[0].length;
        
        transpose(matrix, n, m);

        // for(int[] a: matrix)
        // {
        //     System.out.println(Arrays.toString(a));
        // }

        reverseRows(matrix,n,m);
        // for(int[] a: matrix)
        // {
        //     System.out.println(Arrays.toString(a));
        // }
    }
}

// 11 12 13    11 21 31
// 21 22 23 -> 12 22 32
// 31 32 33    13 23 33
