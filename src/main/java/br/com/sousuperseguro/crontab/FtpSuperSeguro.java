package br.com.sousuperseguro.crontab;


public class FtpSuperSeguro {

//	private FtpSuperSeguroImpl ftpSuperSeguro;
//	
//	public void setFtpCliente(FtpSuperSeguroImpl ftpSuperSeguro) {
//		this.ftpSuperSeguro = ftpSuperSeguro;
//	}
//	
//	
//	@Override
//	protected void executeInternal(JobExecutionContext arg0)
//			throws JobExecutionException {
//		
//		ftpSuperSeguro.executar();
//	}
	
	
	
	
	
	
	
//	public static void ftpSuperSeguro() {
//		
//		
//		JobDetail job = JobBuilder.newJob(FtpSuperSeguroImpl.class)
//				.withIdentity("FtpSuperSeguroJob", "group1").build();
//		 
//		    	Trigger trigger = TriggerBuilder
//				.newTrigger()
//				.withIdentity("FtpSuperSeguroTrigger", "group1")
//				.withSchedule(
//					CronScheduleBuilder.cronSchedule("0 10 * * * *"))
//				.build();
//		 
//		    	//schedule it
//		    	
//				try {
//					Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//					scheduler.start();
//			    	scheduler.scheduleJob(job, trigger);
//				} catch (SchedulerException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		
//	}
	
}
