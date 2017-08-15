package com.jdy.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		/*SpringApplication app =new SpringApplication(Application.class);
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.print("\n" +
						"  ____      ___        __ __       _____ ____  ____   ____  ____    ____      ____    ___    ___   ______       ____   ___       _       ___   __ __    ___ \n" +
						" |    |    |   \\      |  |  |     / ___/|    \\|    \\ |    ||    \\  /    |    |    \\  /   \\  /   \\ |      |     /    | /   \\     | |     /   \\ |  |  |  /  _]\n" +
						" |__  |    |    \\     |  |  |    (   \\_ |  o  )  D  ) |  | |  _  ||   __|    |  o  )|     ||     ||      |    |   __||     |    | |    |     ||  |  | /  [_ \n" +
						" __|  |    |  D  |    |  ~  |     \\__  ||   _/|    /  |  | |  |  ||  |  |    |     ||  O  ||  O  ||_|  |_|    |  |  ||  O  |    | |___ |  O  ||  |  ||    _]\n" +
						"/  |  |    |     |    |___, |     /  \\ ||  |  |    \\  |  | |  |  ||  |_ |    |  O  ||     ||     |  |  |      |  |_ ||     |    |     ||     ||  :  ||   [_ \n" +
						"\\  `  |    |     |    |     |     \\    ||  |  |  .  \\ |  | |  |  ||     |    |     ||     ||     |  |  |      |     ||     |    |     ||     | \\   / |     |\n" +
						" \\____|    |_____|    |____/       \\___||__|  |__|\\_||____||__|__||___,_|    |_____| \\___/  \\___/   |__|      |___,_| \\___/     |_____| \\___/   \\_/  |_____|\n" +
						"                                                                                                                                                            \n");
			}
		});
		app.run(args);*/
	}
}
