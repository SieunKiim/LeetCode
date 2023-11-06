import java.util.*;

class SeatManager {
    PriorityQueue<Integer> que;

    public SeatManager(int n) {
        que = new PriorityQueue<>();
        for(int i = 1; i<=n ;i++){
            que.offer(i);
        }
    }
    
    public int reserve() {

        return que.poll();
    }
    
    public void unreserve(int seatNumber) {
        que.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */