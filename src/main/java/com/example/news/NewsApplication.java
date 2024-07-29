package com.example.news;

import com.example.news.DataAccess.Entry;
import com.example.news.Repositories.EntryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsApplication.class, args);
	}

	/*
	@Bean
	public CommandLineRunner commandLineRunner(EntryRepository repository){
		return args -> {
			Entry entry = new Entry();
			entry.setTitle("I connected a database to my app!");
			entry.setText("Now the app works correctly");
			entry.setDate("30.06.2024");
			repository.save(entry);
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner(EntryRepository repository){
		return args -> {
			Entry entry = new Entry();
			entry.setTitle("delete");
			entry.setText("delete");
			entry.setDate("delete");
			repository.save(entry);
		};
	}*/
}
