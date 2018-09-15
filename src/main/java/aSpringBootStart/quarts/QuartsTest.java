package aSpringBootStart.quarts;


import bFindTheAnswer.quarts.MyJob;
import bFindTheAnswer.test.SingletonSchedulerForNotice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "QuartsTest|用来测试swagger注解的控制器")
@RequestMapping("/scheduler")
public class QuartsTest {


    @RequestMapping(value="/startScheduler",method= RequestMethod.POST)
    public String startScheduler(){

        try {
            SingletonSchedulerForNotice.getInstance().start();
            return "start successful.";
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return "start fail.";

    }

    @RequestMapping(value="/shutDownScheduler",method= RequestMethod.POST)
    public String shutDownScheduler(){

        try {
            SingletonSchedulerForNotice.getInstance().shutDown();
            return "shutdown successful.";
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return "shutdown fail.";

    }

    @RequestMapping(value="/pauseScheduler",method= RequestMethod.POST)
    public String stopScheduler(@RequestParam(value = "groupName") String groupName,@RequestParam(value = "jobName") String jobName){

        Map m=new HashMap();
        m.put("groupName",groupName);
        m.put("jobName",jobName);
        try {
            SingletonSchedulerForNotice.getInstance().pause(m);
            return "Pauesed successful.";
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return "Pauesed fail.";

    }

    @RequestMapping(value="/resumeScheduler",method= RequestMethod.POST)
    @ApiOperation(value="恢复定时任务", notes="test: 仅1和2有正确返回")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", name = "groupName", value = "组名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType="query", name = "jobName", value = "任务名", required = true, dataType = "String")
    })
    public String resumeScheduler(@RequestParam(value = "groupName") String groupName,@RequestParam(value = "jobName") String jobName){

        Map m=new HashMap();
        m.put("groupName",groupName);
        m.put("jobName",jobName);
        try {
            SingletonSchedulerForNotice.getInstance().resume(m);
            return "Resumed successful.";
        }catch(SchedulerException e){
            e.printStackTrace();
        }
        return "Resumed fail.";

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
