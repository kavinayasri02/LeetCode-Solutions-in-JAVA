class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        // 9 integers to track digits 1-9 across 9 columns
        int[] cols = new int[9];
        // 9 integers to track digits 1-9 across nine 3x3 boxes
        int[] boxes = new int[9];
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];
                // Skip empty cells
                if (val == '.') {
                    continue;
                }
                // Convert char digit to bit position (e.g., '5' becomes 1 << 5)
                int mask = 1 << (val - '0'); 
                // Formula to map (row, col) to a specific 3x3 box index (0 to 8)
                int boxIndex = (r / 3) * 3 + (c / 3);
                // If the bit is already set in the row, column, or box bitmask, it's a duplicate
                if ((rows[r] & mask) != 0 || (cols[c] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }
                rows[r] |= mask;
                cols[c] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }
}