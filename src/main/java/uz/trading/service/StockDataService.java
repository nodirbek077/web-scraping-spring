package uz.trading.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.trading.entity.StockData;
import uz.trading.payload.response.GetStockDataResponse;
import uz.trading.repository.StockRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class StockDataService {
    private final StockRepository stockRepository;

    @Scheduled(cron = "0 0/2 * * * ?")
    public void fetchStockData() {
        try {
            String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("GETTING INFORMATION FROM SITE PROCESS STARTED AT... " + startDate);

            fetchStockDataAAPL();
            fetchStockDataTALK();

            String endDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("GETTING INFORMATION FROM SITE PROCESS ENDED AT... " + endDate);

        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void fetchStockDataAAPL() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://finance.yahoo.com/quote/AAPL/");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String price = (String) js.executeScript("return document.querySelector(\"span[data-testid='qsp-price']\").textContent;");

            String volume = (String) js.executeScript("return document.querySelector(\"fin-streamer[data-field='regularMarketVolume']\").innerText;");

            String open = (String) js.executeScript("return document.querySelector(\"fin-streamer[data-field='regularMarketOpen']\").innerText;");

            String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("Price: " + price);
            System.out.println("Volume: " + volume);
            System.out.println("Open: " + open);
            System.out.println("Date: " + currentDate);

            StockData stockData = new StockData();
            stockData.setStockPrice(Double.valueOf(Objects.requireNonNull(price)));
            stockData.setStockVolume(volume);
            stockData.setStockOpen(Double.valueOf(Objects.requireNonNull(open)));
            stockData.setCurrentDate(currentDate);
            stockData.setStockName("AAPL");

            stockRepository.save(stockData);

        } catch (Exception e) {
            System.out.println("Unable to find element (AAPL): " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public void fetchStockDataTALK() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://finance.yahoo.com/quote/TALK/");

            JavascriptExecutor js = (JavascriptExecutor) driver;
            String price = (String) js.executeScript("return document.querySelector(\"span[data-testid='qsp-price']\").textContent;");

            String volume = (String) js.executeScript("return document.querySelector(\"fin-streamer[data-field='regularMarketVolume']\").innerText;");

            String open = (String) js.executeScript("return document.querySelector(\"fin-streamer[data-field='regularMarketOpen']\").innerText;");

            String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            System.out.println("Price: " + price);
            System.out.println("Volume: " + volume);
            System.out.println("Open: " + open);
            System.out.println("Date: " + currentDate);

            StockData stockData = new StockData();
            stockData.setStockPrice(Double.valueOf(Objects.requireNonNull(price)));
            stockData.setStockVolume(volume);
            stockData.setStockOpen(Double.valueOf(Objects.requireNonNull(open)));
            stockData.setCurrentDate(currentDate);
            stockData.setStockName("TALK");

            stockRepository.save(stockData);

        } catch (Exception e) {
            System.out.println("Unable to find element (TALK): " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public GetStockDataResponse getAllStockData() {
        List<StockData> allStockData = stockRepository.findAllStockData();
        return new GetStockDataResponse(0, "Completed successfully!", allStockData);
    }
}
