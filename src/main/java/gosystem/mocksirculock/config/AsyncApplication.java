package gosystem.mocksirculock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncApplication {
	
	
	
	@Bean
	TaskExecutor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(4); //default: 1
	    executor.setMaxPoolSize(10); //default: Integer.MAX_VALUE
	    executor.setQueueCapacity(20); // default: Integer.MAX_VALUE
	    executor.setKeepAliveSeconds(120); // default: 60 seconds
	    executor.initialize();
	   return executor;
	}

}
