package com.betaexpress.domain.test;

import com.betaexpress.domain.exception.InvalidSizeException;
import com.betaexpress.domain.exception.InvalidValidityException;
import com.betaexpress.domain.exception.InvalidVoltageException;
import com.betaexpress.domain.model.*;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BetaExpressTest {

    public static void main(String[] args) {

        String dir = System.getProperty("user.dir");
        String file = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            try {
                InputStream resource = new ClassPathResource("static/cart.txt").getInputStream();
                FileWriter fileW = new FileWriter(dir + file);

                BufferedWriter writing = new BufferedWriter(fileW);
                BufferedReader reading = new BufferedReader(new InputStreamReader(resource));

                String line = reading.readLine();
                Product item = Product.dummyProduct();
                Customer c = new Customer();
                List<String> typesOfProducts = List.of("C", "E", "G");

                while (line != null) {
                    String[] field = line.split(";");

                    switch (field[0].toUpperCase()) {
                        case "U":
                            c = new Customer(field[1], field[2], field[3], "Y".equalsIgnoreCase(field[4]));
                            break;

                        case "C":
                            item = new Clothing(field[1], Float.parseFloat(field[2]), field[3], "Y".equalsIgnoreCase(field[4]), field[5], field[6]);
                            ((Clothing) item).checkSize();
                            break;

                        case "E":
                            item = new Electronic(field[1], Float.parseFloat(field[2]), field[3], field[4], Integer.valueOf(field[5]), "N".equalsIgnoreCase(field[6]));
                            ((Electronic) item).checkVoltage();
                            break;

                        case "G":
                            item = new Grocery(field[1], Float.parseFloat(field[2]), field[3], field[4], Float.parseFloat(field[5]), LocalDateTime.parse(field[6], formatter));
                            ((Grocery) item).checkExpirationDate();
                            break;

                        case "":
                            writing.write(c.toString() + "\r\n");
                            break;

                        default:
                            System.out.println("invalid input");
                            break;
                    }
                    if (typesOfProducts.contains(field[0].toUpperCase()))
                        c.addToCart(item);
                    line = reading.readLine();
                }
                writing.write(c.toString() + "\r\n");
                reading.close();
                writing.close();
                fileW.close();
            } catch (InvalidSizeException | InvalidVoltageException | InvalidValidityException | IOException e) {
                e.printStackTrace();
            }

        } finally {
            System.out.println("task completed: " + (dir + file));
        }
    }
}
