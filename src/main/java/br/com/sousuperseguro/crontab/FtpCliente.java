package br.com.sousuperseguro.crontab;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import br.com.sousuperseguro.utilImpl.FtpClienteImpl;

public class FtpCliente {
	public static void main(String[] args) {
		JobDetail job = JobBuilder.newJob(FtpClienteImpl.class)
				.withIdentity("FtpClienteJob", "group1").build();
		 
			//Quartz 1.6.3
		    	//CronTrigger trigger = new CronTrigger();
		    	//trigger.setName("dummyTriggerName");
		    	//trigger.setCronExpression("0/5 * * * * ?");
		 
		    	Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("FtpClienteTrigger", "group1")
				.withSchedule(
					CronScheduleBuilder.cronSchedule("0 10 * * * *"))
				.build();
		 
		    	//schedule it
		    	
				try {
					Scheduler scheduler = new StdSchedulerFactory().getScheduler();
					scheduler.start();
			    	scheduler.scheduleJob(job, trigger);
				} catch (SchedulerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
