/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] map = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int di = 0;
        int i = 0;
        int j = 0;
        int closedWay = 0;

        while (closedWay < 4) {
            int temp = -1;
            if (head != null) {
                temp = head.val;
            }
            map[i][j] = temp;
            visited[i][j] = true;
            int nextI = i + dy[di % 4];
            int nextJ = j + dx[di % 4];
            if (0 <= nextI && nextI < m && 0 <= nextJ && nextJ < n && !visited[nextI][nextJ]) {
                closedWay = 0;
                i = nextI;
                j = nextJ;
                if(head!= null) head = head.next;
            } else {
                closedWay += 1;
                di += 1;
            }
        }
        return map;
    }
}