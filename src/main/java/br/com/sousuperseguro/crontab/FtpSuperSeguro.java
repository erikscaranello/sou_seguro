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
import br.com.sousuperseguro.utilImpl.FtpSuperSeguroImpl;

public class FtpSuperSeguro {
	
	public static void main(String[] args) {
		
		
		JobDetail job = JobBuilder.newJob(FtpSuperSeguroImpl.class)
				.withIdentity("FtpSuperSeguroJob", "group1").build();
		 
		    	Trigger trigger = TriggerBuilder
				.newTrigger()
				.withIdentity("FtpSuperSeguroTrigger", "group1")
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
