package com.hazelcast.demo;

import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;

/**
 * 
 * @author wrmay
 *
 */

@ComponentScan
@Configuration
public class Loader implements CommandLineRunner
{
	private static Logger log = LogManager.getLogger(Loader.class);

    public static void main( String[] args )
    {
		SpringApplication.run(Loader.class, args);
    }


    @Bean
    HazelcastInstance hazelcast() {
    	return HazelcastClient.newHazelcastClient();
    }

    @Autowired
    HazelcastInstance hz;

    @Autowired
    Environment environ;

	@Override
	public void run(String... args) throws Exception {
		String name = hz.getName();
		log.info("HELLO FROM {}",name);
		hz.shutdown();
	}

	@PreDestroy
	public void shutdown() {
		log.info("BYE");
	}

}
