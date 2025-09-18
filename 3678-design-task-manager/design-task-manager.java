class TaskManager {

    public class Task {
        int userId;
        int id;
        int priority;

        public Task(int userId, int id, int priority){
            this.userId = userId;
            this.id = id;
            this.priority = priority;
        }
    }

    // userId별 PQ
    Map<Integer, PriorityQueue<Task>> userTaskMap = new HashMap<>();
    // 전체 PQ
    PriorityQueue<Task> totalTask = new PriorityQueue<>((o1, o2) -> {
        if (o1.priority == o2.priority) {
            return o2.id - o1.id;
        }
        return o2.priority - o1.priority;
    });

    // taskId → 현재 유효한 Task
    Map<Integer, Task> currentTask = new HashMap<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (var raw : tasks) {
            add(raw.get(0), raw.get(1), raw.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);

        userTaskMap.computeIfAbsent(userId, k ->
            new PriorityQueue<>((a, b) -> {
                if (a.priority == b.priority) return b.id - a.id;
                return b.priority - a.priority;
            })
        ).add(task);

        totalTask.add(task);
        currentTask.put(taskId, task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = currentTask.get(taskId);
        if (old == null) return; // 이미 삭제됨

        // 새로운 Task를 생성하고 추가
        Task updated = new Task(old.userId, taskId, newPriority);
        currentTask.put(taskId, updated);

        userTaskMap.get(old.userId).add(updated);
        totalTask.add(updated);
    }

    public void rmv(int taskId) {
        currentTask.remove(taskId); // PQ에는 남아있지만 무효화
    }

    public int execTop() {
        while (!totalTask.isEmpty()) {
            Task top = totalTask.peek();
            Task valid = currentTask.get(top.id);
            if (valid == null || valid != top) { 
                totalTask.poll(); // 무효화된 Task 제거
                continue;
            }
            totalTask.poll();
            currentTask.remove(top.id);

            // user PQ에서도 제거
            PriorityQueue<Task> userPQ = userTaskMap.get(top.userId);
            while (!userPQ.isEmpty() && 
                   (currentTask.get(userPQ.peek().id) != userPQ.peek())) {
                userPQ.poll(); // 무효화된 것 제거
            }
            return top.userId;
        }
        return -1;
    }
}
