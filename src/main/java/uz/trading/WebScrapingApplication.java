package uz.trading;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@EnableScheduling
//@OpenAPIDefinition(
//        servers = {@Server(url = "http://localhost:8080",description = "server url")},
//        info = @Info(title = "Trading API", version = "1.0"))
public class WebScrapingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebScrapingApplication.class, args);

        String endDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("STARTED..." + endDate);
    }

    //for Test Product Service
//    @Bean
//    public CommandLineRunner commandLineRunner(ProductService productService) {
//        return args -> {
//            productService.scrapeProductPage();
//        };
//    }


    //for StockService
//    @Bean
//    public CommandLineRunner commandLineRunner(StockDataService stockDataService) {
//        return args -> {
//            stockDataService.fetchStockData();};
//    }

}
