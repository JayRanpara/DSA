class Solution {

    public boolean validateBox(char[][] board,int sr, int er, int sc, int ec) {
        HashSet<Character>set = new HashSet<>();

        for(int i=sr; i<=er; i++) {
            for(int j=sc; j<=ec; j++) {
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        //rows
        for(int i=0; i<9; i++) {
            HashSet<Character>set = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[i][j] == '.') continue;

                if(set.contains(board[i][j])) {
                    return false;
                }

                set.add(board[i][j]);
            }
        }

        //columns

        for(int i=0; i<9; i++) {
            HashSet<Character>set = new HashSet<>();
            for(int j=0; j<9; j++) {
                if(board[j][i] == '.') continue;

                if(set.contains(board[j][i])) {
                    return false;
                }

                set.add(board[j][i]);
            }
        }

        //boxes

        for(int i=0; i<9; i+=3) {
            int erow = i+2;
            for(int j=0; j<9; j+=3) {
                int ecol=j+2;

                if(!validateBox(board,i,erow,j,ecol)) {
                    return false;
                }
            }
        }

        return true;
        
    }
}
