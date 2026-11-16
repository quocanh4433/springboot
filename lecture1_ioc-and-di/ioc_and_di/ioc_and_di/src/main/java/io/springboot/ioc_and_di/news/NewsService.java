package io.springboot.ioc_and_di.news;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service 
public class NewsService {

    @Value("${news.api.key}")
    private String API_KEY;

    @Value("${news.api.url}")
    private String URI;

    private final RestTemplate restTemplate;

    public NewsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getTopHeadlines () {
        // https://newsapi.org/docs/endpoints/top-headlines
        // Construct the URL with query parameters
        String url = UriComponentsBuilder.fromUriString(URI)
        .queryParam("apiKey", API_KEY)
        .queryParam("country", "us")
        .toUriString();

        return restTemplate.getForObject(url, String.class); // String.class chi doi tuong String
        
    }
}
