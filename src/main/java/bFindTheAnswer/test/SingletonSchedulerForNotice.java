package bFindTheAnswer.test;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import bFindTheAnswer.quarts.MyJob;
import org.quartz.impl.matchers.GroupMatcher;

import java.util.*;

/**
 *
 * @ClassName: SingletonSchedulerForNotice
 * @Description:
 * @Author: drudg
 * @CreateDate: 2018/9/4 15:52

 */
public class SingletonSchedulerForNotice {
    private Scheduler scheduler;
    private JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();
    //创建触发器 每3秒钟执行一次
    private Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group3")
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
            .build();

    private SingletonSchedulerForNotice(){
        scheduler = getScheduler();
    }


    private static SingletonSchedulerForNotice ssfn=new SingletonSchedulerForNotice();

    public static SingletonSchedulerForNotice getInstance(){
        return ssfn;
    }

    public void init() {

    }

    public void start() throws SchedulerException{
        //将任务及其触发器放入调度器
        scheduler.scheduleJob(jobDetail, trigger);
        //调度器开始调度任务
        scheduler.start();


    }

    public void pause(Map<String,String> mParam)throws SchedulerException{

        //scheduler.getJobKeys();
        //遍历scheduler里的所有job，group
//        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//
//        for (String groupName : scheduler.getJobGroupNames()) {
//
//            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
//
//                String jobName = jobKey.getName();
//                String jobGroup = jobKey.getGroup();
//
//                //get job's trigger
//                List<Trigger> triggers = (List<Trigger>) scheduler.getTriggersOfJob(jobKey);
//                Date nextFireTime = triggers.get(0).getNextFireTime();
//
//                System.out.println("[jobName] : " + jobName + " [groupName] : "
//                        + jobGroup + " - " + nextFireTime);
//
//            }
//
//        }

        String groupName=mParam.get("groupName");
        String jobName=mParam.get("jobName");

        JobKey key = JobKey.jobKey(jobName, groupName);
        scheduler.pauseJob(key);



    }

    public void resume(Map<String,String> mParam)throws SchedulerException{
        String groupName=mParam.get("groupName");
        String jobName=mParam.get("jobName");

        JobKey key = JobKey.jobKey(jobName, groupName);
        scheduler.resumeJob(key);
    }

    public void shutDown() throws SchedulerException{
        scheduler.shutdown();
    }

    //创建调度器
    public static Scheduler getScheduler(){
        try {
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            return schedulerFactory.getScheduler();
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return null;
    }

}
