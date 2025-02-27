package uz.trading.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.trading.entity.StockData;
import uz.trading.payload.response.GetStockDataResponse;
import uz.trading.repository.StockRepository;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockDataService {
    private final StockRepository stockRepository;

    @Scheduled(cron = "0 0/15 * * * ?")
    public void fetchStockData() {
        try {
            String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("GETTING INFORMATION FROM SITE PROCESS STARTED AT... " + startDate);

            fetchStockDataAAPL();
//            fetchStockDataTALK();

            String endDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("GETTING INFORMATION FROM SITE PROCESS ENDED AT... " + endDate);

        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        }
    }

    public void fetchStockDataAAPL() {

        String API_URL = "https://yahoo-finance15.p.rapidapi.com/api/v1/markets/stock/quotes?ticker=AAPL%2CMSFT%2C%5ESPX%2C%5ENYA%2CGAZP.ME%2CSIBN.ME%2CGEECEE.NS";
        String API_KEY = "1ec4f42581msh80ca931008ce330p17c34fjsn3b82c3565c69";

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL)
                .header("X-RapidAPI-Key", API_KEY)
                .header("X-RapidAPI-Host", "yahoo-finance15.p.rapidapi.com")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("Request failed: " + response.code());
                return;
            }

            assert response.body() != null;
            String responseData = response.body().string();

            ObjectMapper mapper = new ObjectMapper();

            ResponseDTO responseDTO = mapper.readValue(responseData, ResponseDTO.class);

            if(responseDTO.getBody().isEmpty()){
                System.out.println("Response body is empty");
                return;
            }
            for (Map<String, Object> map :  responseDTO.getBody()) {
                StockData stockData = new StockData();
                stockData.setStockPrice(Double.parseDouble(map.get("regularMarketPrice").toString()));
                stockData.setStockVolume(map.get("regularMarketVolume").toString());
                stockData.setStockOpen(Double.parseDouble(map.get("regularMarketOpen").toString()));
                stockData.setTodayDate(LocalDateTime.now());
                stockData.setStockName(map.get("symbol").toString());


                stockRepository.save(stockData);
            }

            System.out.println("Yahoo Finance API Response: " + responseData);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

//        try {
//            driver.get("https://finance.yahoo.com/quote/AAPL/");
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            // ✅ Foydalanuvchi sahifani ko'rib chiqayotganga o'xshatish
//            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
//
//            // ✅ Sahifa yuklanishini kutish
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-testid='qsp-price']")));
//
//            String price = driver.findElement(By.cssSelector("span[data-testid='qsp-price']")).getText();
//            String volume = driver.findElement(By.cssSelector("fin-streamer[data-field='regularMarketVolume']")).getText();
//            String open = driver.findElement(By.cssSelector("fin-streamer[data-field='regularMarketOpen']")).getText();
//
//            System.out.println("Price: " + price);
//            System.out.println("Volume: " + volume);
//            System.out.println("Open: " + open);
//            System.out.println("Date: " + LocalDateTime.now());
//
//            int waitTime = ThreadLocalRandom.current().nextInt(5000, 15000);
//            System.out.println("Waiting for " + (waitTime / 1000) + " seconds...");
//            Thread.sleep(waitTime);
//
//            StockData stockData = new StockData();
//            stockData.setStockPrice(Double.valueOf(Objects.requireNonNull(price).replace(",", "")));
//            stockData.setStockVolume(volume.replace(",", ""));
//            stockData.setStockOpen(Double.valueOf(Objects.requireNonNull(open).replace(",", "")));
//            stockData.setCurrentDate(LocalDateTime.now());
//            stockData.setStockName("AAPL");
//
//            stockRepository.save(stockData);
//
//        } catch (Exception e) {
//            System.out.println("Error while fetching AAPL data: " + e.getMessage());
//        } finally {
//            driver.quit();
//        }
    }

    public void fetchStockDataTALK() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled"); // ✅ Selenium deteksiyasini oldini olish
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get("https://finance.yahoo.com/quote/TALK/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // ✅ Brauzer sahifani ko'rib chiqayotganga o'xshatish
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

            // ✅ Elementlar yuklanishini kutish
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[data-testid='qsp-price']")));

            String price = driver.findElement(By.cssSelector("span[data-testid='qsp-price']")).getText();
            String volume = driver.findElement(By.cssSelector("fin-streamer[data-field='regularMarketVolume']")).getText();
            String open = driver.findElement(By.cssSelector("fin-streamer[data-field='regularMarketOpen']")).getText();

            LocalDateTime currentDate = LocalDateTime.now();

            System.out.println("Price: " + price);
            System.out.println("Volume: " + volume);
            System.out.println("Open: " + open);
            System.out.println("Date: " + currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

            int waitTime = ThreadLocalRandom.current().nextInt(5000, 15000);
            System.out.println("Waiting for " + (waitTime / 1000) + " seconds...");
            Thread.sleep(waitTime);

            StockData stockData = new StockData();
            stockData.setStockPrice(Double.valueOf(Objects.requireNonNull(price).replace(",", ""))); // ✅ Virgullarni olib tashlash
            stockData.setStockVolume(volume.replace(",", ""));
            stockData.setStockOpen(Double.valueOf(Objects.requireNonNull(open).replace(",", "")));
            stockData.setTodayDate(LocalDateTime.now()); // ✅ LocalDateTime sifatida saqlash
            stockData.setStockName("TALK");

            stockRepository.save(stockData);

        } catch (Exception e) {
            System.out.println("Error while fetching TALK data: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    public GetStockDataResponse getAllStockData() {
        List<StockData> allStockData = stockRepository.findAllStockData();
        return new GetStockDataResponse(0, "Completed successfully!", allStockData);
    }

    public List<GetStockDataResponse> getStockDataByName(String stockName) {
        List<StockData> stockDataList = stockRepository.findByStockNameOrderByIdDesc(stockName);

        return stockDataList.stream()
                .map(stock -> new GetStockDataResponse(0, "Completed successfully", stockDataList))
                .collect(Collectors.toList());
    }
}
