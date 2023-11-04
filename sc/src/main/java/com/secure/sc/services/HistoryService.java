package com.secure.sc.services;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HistoryService {
    private final List<String> historyService = new ArrayList<>();


    public List<String> getCalculationHistory(String calculate) {
        calculate = String.valueOf(historyService);
        /* System.out.println(calculate);
         return historyService;*/
        return Collections.singletonList(calculate);

    }

    public void addCalculation(String calculation) {
    // Getting value
        historyService.add(calculation);
        System.out.println(historyService);
    }
}