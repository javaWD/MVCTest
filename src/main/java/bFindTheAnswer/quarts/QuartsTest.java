package bFindTheAnswer.quarts;


import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bFindTheAnswer.test.SingletonSchedulerForNotice;

@RestController
public class QuartsTest {
    public static void main(String[] args) {
        try {
//            QuartsTest quartsTest = new QuartsTest();
//            quartsTest.schedulerJob();

            SingletonSchedulerForNotice.getInstance().start();


        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

    @RequestMapping("/execByHttpsRequest")
    public boolean execByHttpsRequest(){

        try {
            SingletonSchedulerForNotice.getInstance().start();
            return true;
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return false;

    }

    public static void schedulerJob() throws SchedulerException{
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
        //创建触发器 每3秒钟执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
                .build();
        Scheduler scheduler = getScheduler();
        //将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        scheduler.start();

    }

    //创建调度器
    public static Scheduler getScheduler() throws SchedulerException{
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }


}
