package com.example.demo.config;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**  
* @Title: ScheduleConfig.java  
* @Package com.example.demo.config  
* @Description: 配置多个线程以支持整个项目的任务调度,避免出现整个项目所有任务调度共用同一个线程出现的不可预估的问题
* @author wdm  
* @date 2018年6月5日  下午1:20:45
* @version V1.0  
*/
@Configuration
public class ScheduleConfig implements SchedulingConfigurer {

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.annotation.SchedulingConfigurer#configureTasks(org.springframework.scheduling.config.ScheduledTaskRegistrar)
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		//设定一个长度10的定时任务线程池
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));

	}

}
