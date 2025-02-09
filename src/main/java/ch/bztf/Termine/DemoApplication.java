package ch.bztf.Termine;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner 
{
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override // Ein Run zum Start (wäre eigentlich nicht nötig)
	public void run(String... args) throws Exception {
        System.out.println("Our DataSource is = " + dataSource);
	}
}
