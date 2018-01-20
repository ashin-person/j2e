package ljx.ashin.thread.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *自定义拒绝策略
 * Created by AshinLiang on 2017/8/15.
 */
public class MyRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        MyTask myTask = (MyTask)r;
        System.out.println("未处理的任务Id:"+myTask.getTaskId());
        executor.execute(myTask);

    }
}
