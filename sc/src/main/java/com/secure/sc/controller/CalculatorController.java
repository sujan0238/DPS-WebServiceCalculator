package com.secure.sc.controller;
import com.secure.sc.services.HistoryService;
import com.secure.sc.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static java.lang.System.in;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;
    private HistoryService historyService;

    @GetMapping("/add")
    public String add(@RequestParam double num1, @RequestParam double num2) {
        double addition = calculatorService.add(num1, num2);
        return String.format("%.1f + %.1f = %.1f", num1, num2, addition);
    }

    @GetMapping("/subtract")
    public String subtract(@RequestParam double num1, @RequestParam double num2) {
        double subtraction = calculatorService.subtract(num1, num2);
        return String.format("%.1f - %.1f = %.1f", num1, num2, subtraction);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam double num1, @RequestParam double num2) {
        double multiplication = calculatorService.multiply(num1, num2);
        return String.format("%.1f * %.1f = %.1f", num1, num2, multiplication);
        //return calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public ResponseEntity<String> divide(@RequestParam double num1, @RequestParam double num2) {
        try{
            if (num2 == 0) {
                throw new IllegalArgumentException("Infinity");
                }
            double division = calculatorService.divide(num1, num2);
            return ResponseEntity.ok(String.format("%.1f / %.1f = %.1f", num1,num2, division));
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(String.format("%.1f / %.1f = %s", num1,num2, e.getMessage()));
        }
    }



}
