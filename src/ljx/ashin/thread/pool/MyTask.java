package ljx.ashin.thread.pool;

/**
 * Created by AshinLiang on 2017/8/15.
 */
public class MyTask implements Runnable {

    private int taskId;
    private String taskName;

    public MyTask(int taskId,String taskName){
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {

        try {
            System.out.println("正在执行任务:"+taskId+" "+taskName);
            Thread.sleep(2*1000);
            System.out.println("执行完了任务:"+taskId+" "+taskName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
