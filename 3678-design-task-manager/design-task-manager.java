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

        @Override
        public boolean equals(Object o){
            if(this == o)return true;
            if(!(o instanceof Task)) return false;
            Task task = (Task) o;
            return this.id == task.id && this.userId == task.userId && this.priority == task.priority;
        }

        @Override
        public int hashCode(){
            return Objects.hash(userId, id, priority);
        }
    }

    HashMap<Integer, PriorityQueue<Task>> userTaskMap = new HashMap<>();
    HashMap<Integer, Task> realTask = new HashMap<>();
    PriorityQueue<Task> totalTask = new PriorityQueue<>((o1, o2) -> {
        if (o1.priority == o2.priority) {
            return o2.id - o1.id;
        }
        return o2.priority - o1.priority;
    });

    public TaskManager(List<List<Integer>> tasks) {
        for(int i =0; i<tasks.size();i++){
            var rawTask = tasks.get(i);
            int userId = rawTask.get(0);
            int taskId = rawTask.get(1);
            int priority = rawTask.get(2);
            this.add(userId, taskId, priority);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        var temp = userTaskMap.getOrDefault(userId, new PriorityQueue<Task>((o1,o2)-> {
                if(o1.priority == o2.priority){
                    return o2.id-o1.id;
                }
                return o2.priority - o1.priority;
            }));
        var task = new Task(userId, taskId, priority);
        temp.add(task);
        userTaskMap.put(userId, temp);
        realTask.put(taskId, task);
        totalTask.add(task);
    }
    
    public void edit(int taskId, int newPriority) {
        Integer userId = realTask.get(taskId).userId;
        var taskMap = userTaskMap.get(userId);
        var newTask = new Task(userId, taskId, newPriority);
        taskMap.add(newTask);
        userTaskMap.put(userId, taskMap);
        realTask.put(taskId, newTask);

        totalTask.add(newTask);
    }
    
    public void rmv(int taskId) {
        realTask.remove(taskId);
    }
    
    public int execTop() {
        int output = -1;
        while(!totalTask.isEmpty()){
            var peak = totalTask.poll();
            var realT = realTask.get(peak.id);
            if(realT != null && realT.equals(peak)){
                output = peak.userId;
                realTask.remove(peak.id);
                break; 
            }
        }
        return output;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */