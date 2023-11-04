package com.secure.sc.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculatorService {

    @Autowired
    private HistoryService historyService;
    public double add(double num1, double num2) {
        double plus = num1 + num2;
        historyService.addCalculation(String.format("%.1f + %.1f = %.1f", num1, num2, plus));
        return plus;
    }

    public double subtract(double num1, double num2) {
        double sub = num1 - num2;
        historyService.addCalculation(String.format("%.1f - %.1f = %.1f", num1, num2, sub));
        return sub;
    }

    public double multiply(double num1, double num2) {
        double mul = num1 * num2;
        historyService.addCalculation(String.format("%.1f * %.1f = %.1f", num1, num2, mul));
        return mul;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            double ex = num1 / num2;
            historyService.addCalculation(String.format("%.1f / %.1f = %.1f", num1, num2, ex));
            return ex;
        }else{
            double div = num1 / num2;
            historyService.addCalculation(String.format("%.1f / %.1f = %.1f", num1, num2, div));
            return div;
        }
    }
    public List<String> getCalculationHistory(String calculate) {
        return historyService.getCalculationHistory(calculate);
    }

}
