package com.trading.simulator;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/trade")
public class TradingController {

    private final Map<String, Integer> portfolio = new HashMap<>();

    @PostMapping("/buy")
    public void buyStock(@RequestBody Trade trade) {
        portfolio.put(trade.getSymbol(), portfolio.getOrDefault(trade.getSymbol(), 0) + trade.getQuantity());
    }

    @PostMapping("/sell")
    public void sellStock(@RequestBody Trade trade) {
        portfolio.put(trade.getSymbol(), Math.max(portfolio.getOrDefault(trade.getSymbol(), 0) - trade.getQuantity(), 0));
    }

    @GetMapping("/portfolio")
    public List<Trade> getPortfolio() {
        List<Trade> list = new ArrayList<>();
        for (var entry : portfolio.entrySet()) {
            list.add(new Trade(entry.getKey(), entry.getValue()));
        }
        return list;
    }
}

class Trade {
    private String symbol;
    private int quantity;

    public Trade() {}
    public Trade(String symbol, int quantity) { this.symbol = symbol; this.quantity = quantity; }
    
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
