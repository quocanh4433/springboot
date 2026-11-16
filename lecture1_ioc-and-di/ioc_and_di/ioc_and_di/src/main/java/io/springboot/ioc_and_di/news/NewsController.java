package io.springboot.ioc_and_di.news;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/top")
    public ResponseEntity<String> getNews() { // <String> type of response body
        return  ResponseEntity.status(HttpStatus.OK).body(newsService.getTopHeadlines());
    }



}
