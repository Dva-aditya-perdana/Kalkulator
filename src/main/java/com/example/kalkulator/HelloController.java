package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField display;

    private double first = 0;
    private String operator = "";
    private boolean newNumber = true;

    @FXML
    private void onNumber(ActionEvent e) {
        String value = ((Button) e.getSource()).getText();

        if (newNumber) {
            display.setText(value);
            newNumber = false;
        } else {
            display.setText(display.getText() + value);
        }
    }

    @FXML
    private void onOperator(ActionEvent e) {
        if (display.getText().equals("Error")) return;

        if (!operator.isEmpty()) {
            calculate();
        }

        operator = ((Button) e.getSource()).getText();
        first = Double.parseDouble(display.getText());
        newNumber = true;
    }

    @FXML
    private void onEquals(ActionEvent e) {
        if (!operator.isEmpty()) {
            calculate();
            operator = "";
        }
    }

    @FXML
    private void onClear(ActionEvent e) {
        display.setText("0");
        operator = "";
        first = 0;
        newNumber = true;
    }

    @FXML
    private void onBackspace(ActionEvent e) {
        if (newNumber) return;

        String text = display.getText();
        if (text.length() > 1) {
            display.setText(text.substring(0, text.length() - 1));
        } else {
            display.setText("0");
            newNumber = true;
        }
    }

    @FXML
    private void onDecimal(ActionEvent e) {
        if (newNumber) {
            display.setText("0.");
            newNumber = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    private void calculate() {
        double second = Double.parseDouble(display.getText());
        double result = 0;

        switch (operator) {
            case "+" -> result = first + second;
            case "-" -> result = first - second;
            case "*" -> result = first * second;
            case "/" -> {
                if (second == 0) {
                    display.setText("Error");
                    newNumber = true;
                    return;
                }
                result = first / second;
            }
        }

        display.setText(
                result == (long) result
                        ? String.valueOf((long) result)
                        : String.valueOf(result)
        );

        first = result;
        newNumber = true;
    }
}
