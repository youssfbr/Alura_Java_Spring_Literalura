package com.github.youssfbr.literalura;


import com.github.youssfbr.literalura.application.ApplicationMenu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	private final ApplicationMenu principal;

    public LiteraluraApplication(ApplicationMenu principal) {
        this.principal = principal;
    }

	@Override
	public void run(String... args) throws Exception {
		principal.showMenu();
	}
}
