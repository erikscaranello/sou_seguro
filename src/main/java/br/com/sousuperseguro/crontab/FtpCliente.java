package br.com.sousuperseguro.crontab;


public class FtpCliente{
	
//	private FtpClienteImpl ftpCliente;
//		
//	public void setFtpCliente(FtpClienteImpl ftpCliente) {
//		this.ftpCliente = ftpCliente;
//	}
//
//	@Override
//	protected void executeInternal(JobExecutionContext arg0)
//			throws JobExecutionException {
//		
//		ftpCliente.executar();
//		
//	}
	
	
//	public static void main(String[] args) {
//	JobDetail job = JobBuilder.newJob(FtpClienteImpl.class)
//			.withIdentity("FtpClienteJob", "group1").build();
//	 
//		//Quartz 1.6.3
//	    	//CronTrigger trigger = new CronTrigger();
//	    	//trigger.setName("dummyTriggerName");
//	    	//trigger.setCronExpression("0/5 * * * * ?");
//	 
//	    	Trigger trigger = TriggerBuilder
//			.newTrigger()
//			.withIdentity("FtpClienteTrigger", "group1")
//			.withSchedule(
//				CronScheduleBuilder.cronSchedule("0 10 * * * *"))
//			.build();
//	 
//	    	//schedule it
//	    	
//			try {
//				Scheduler scheduler = new StdSchedulerFactory().getScheduler();
//				scheduler.start();
//		    	scheduler.scheduleJob(job, trigger);
//			} catch (SchedulerException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//}
}
