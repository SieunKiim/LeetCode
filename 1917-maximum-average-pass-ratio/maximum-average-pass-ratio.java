class Solution {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
       class ClassInfo {
            int pass, total;
            double improvement;
            
            ClassInfo(int pass, int total) {
                this.pass = pass;
                this.total = total;
                this.improvement = calculateImprovement();
            }
            
            // 한 명의 brilliant student를 추가했을 때의 pass ratio 개선량 계산
            // 공식: (total - pass) / (total * (total + 1))
            double calculateImprovement() {
                return (double)(total - pass) / ((long)total * (total + 1));
            }
            
            // 학생 한 명 추가 후 개선량 재계산
            void addStudent() {
                pass++;
                total++;
                improvement = calculateImprovement();
            }
        }
        
        // 개선량 기준 최대 힙 (내림차순)
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> 
            Double.compare(b.improvement, a.improvement));
        
        // 모든 클래스를 힙에 추가
        for (int[] cls : classes) {
            pq.offer(new ClassInfo(cls[0], cls[1]));
        }
        
        // extraStudents만큼 반복하여 최적 배치
        for (int i = 0; i < extraStudents; i++) {
            ClassInfo best = pq.poll(); // 가장 큰 개선량을 주는 클래스 선택
            best.addStudent(); // 학생 추가
            pq.offer(best); // 업데이트된 정보로 다시 힙에 추가
        }
        
        // 최종 평균 pass ratio 계산
        double sum = 0;
        while (!pq.isEmpty()) {
            ClassInfo cls = pq.poll();
            sum += (double)cls.pass / cls.total;
        }
        
        return sum / classes.length;

    }
}