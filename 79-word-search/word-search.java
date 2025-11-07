class Solution {
    int m; 
    int n; 
    int[][] directions= {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length; 
        for(int i =0;i<m;++i)
        {
            for(int j=0;j<n;++j)
            {
                //System.out.println("in for");
                if(board[i][j]==word.charAt(0))  
                {
                    if(backtrack(board,i,j,word,0)) //we found starting char
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int i ,int j ,String word, int idx)
    {
        if(idx==word.length())
            return true;     //base case

         if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='$')
            return false; 

        if(board[i][j]!= word.charAt(idx))    //standing at wrong place so backtrack
            return false; 

        char temp = board[i][j];   //will be used to revert the choices in backtracking
        board[i][j]='$';    //setting that it is visited

        
        for(int[] dir: directions)
        {
            int i_next= i+ dir[0]; 
            int j_next=j+dir[1];

        //recursive call to check for all next indices and all possible combos
            if(backtrack(board,i_next,j_next,word,idx+1))
                return true;    
        
        }

        board[i][j]=temp;   //resetting to previous cell element to *back*track
        return false;     //if nothing right happens fall back to false
    }
}

