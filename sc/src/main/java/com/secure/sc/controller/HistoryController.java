package com.secure.sc.controller;
import com.secure.sc.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/calculator/history")

public class HistoryController {
    @Autowired
    private HistoryService  historyService ;


    @GetMapping("/get")
    public ResponseEntity<String> getHistory(String calculate) {
        List<String> history = historyService.getCalculationHistory(calculate);
        List<String> finalHistory = new ArrayList<>();
        for (String rmBracket : history) {
            String cleanedEntry = rmBracket.replaceAll("\\[", "").replaceAll("]", "");
            finalHistory.add(cleanedEntry);
        }

        return ResponseEntity.ok(String.valueOf(finalHistory));
    }


        @GetMapping("/clear")

        public ResponseEntity<String> clearHistory(String resultList){
            List<String> historyClear = historyService.getCalculationHistory(resultList);
            // Assigning to empty list
            historyClear = new ArrayList<String>();
            System.out.println(historyClear);
            String message = "<h1>History has been cleared.....</h1>";
            return ResponseEntity.ok(message);
        }

}

