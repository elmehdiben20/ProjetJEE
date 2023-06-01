package jee.projet.encheres.services;
import jee.projet.encheres.Classes.CurrencyData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CurrencyService {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/a0ae412eddcb0a66de56bb56/latest/MAD";

    private final WebClient webClient;

    public CurrencyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public CurrencyData getCurrencyData() {
        return webClient.get()
                .uri(API_URL)
                .retrieve()
                .bodyToMono(CurrencyData.class)
                .block();
    }
}