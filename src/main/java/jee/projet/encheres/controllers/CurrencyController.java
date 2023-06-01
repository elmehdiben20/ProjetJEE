package jee.projet.encheres.controllers;
import jee.projet.encheres.Classes.CurrencyData;
import jee.projet.encheres.services.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class CurrencyController {
    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/")
    public String getCurrencies(Model model) {
        CurrencyData currencyData = currencyService.getCurrencyData();
        Map<String, Double> currencies = currencyData.getConversion_rates();

        for (Map.Entry<String, Double> entry : currencies.entrySet()) {
            String currencyCode = entry.getKey();
            Double rate = entry.getValue();
            System.out.println(currencyCode + ": " + rate);
        }

        model.addAttribute("currencies", currencies);
        return "devise";
    }
}