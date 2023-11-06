import java.util.*;

class SeatManager {
    PriorityQueue<Integer> refunded;
    int seatNum;

    public SeatManager(int n) {
        refunded = new PriorityQueue<>();
        seatNum = 0;
    }
    
    public int reserve() {
        if(refunded.isEmpty()){
            return ++seatNum;
        }
        return refunded.poll();
    }
    
    public void unreserve(int seatNumber) {
        refunded.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */