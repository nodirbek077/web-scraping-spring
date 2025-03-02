package uz.trading.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import uz.trading.repository.ProductRepository;
import uz.trading.entity.Product;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class ProductService {
//    private final ProductRepository productRepository;
//
//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Scheduled(cron = "0 0/15 * * * ?")
//    public void scrapeProductPage() {
//
//        System.out.println("WEB SCRAPING PRODUCT STARTED");
//
////        if (!pageToScrap.isEmpty()) {
////            String url = pageToScrap.remove(0);
//
////            pageDiscovered.add(url);
//
//            Document doc;
//            try {
//                doc = Jsoup
//                        .connect("https://www.scrapingcourse.com/ecommerce/")
//                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
//                        .header("Accept-Language", "*")
//                        .post();
//                System.out.println("WEB SCRAPING CONNECTED SUCCESSFULLY");
//            }catch (IOException e) {
//                throw new RuntimeException();
//            }
//
//            Elements productElements = doc.select("li.product");
//
//            for (Element productElement : productElements) {
//                Product product = new Product();
//
//                product.setUrl(Objects.requireNonNull(productElement.selectFirst("a")).attr("href"));
//                product.setImage(Objects.requireNonNull(productElement.selectFirst("img")).attr("src"));
//                product.setName(Objects.requireNonNull(productElement.selectFirst("h2")).text());
//                product.setPrice(Objects.requireNonNull(productElement.selectFirst("span")).text());
//                product.setCreatedDate(LocalDateTime.now());
////                products.add(product);
//                productRepository.save(product);
//            }
//
//            System.out.println("WEB SCRAPING PRODUCT ENDED");
//
////            products.toString();
////            System.out.println(products);
//
////            Elements paginationElements = doc.select("a.page-numbers");
////            for (Element paginationElement : paginationElements) {
////                String pageUrl = paginationElement.attr("href");
////                if (!pageDiscovered.contains(pageUrl) && !pageToScrap.contains(pageUrl)) {
////                    pageToScrap.add(pageUrl);
////                }
////
////                pageDiscovered.add(pageUrl);
////            }
////
////            System.out.println(url + " -> page scraped");
////        }
//    }

}
