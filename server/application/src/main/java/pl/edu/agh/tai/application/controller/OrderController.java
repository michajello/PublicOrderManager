package pl.edu.agh.tai.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.agh.tai.application.util.ApiConstants;

import java.io.IOException;
import java.net.URL;

@RestController
public class OrderController {

    @GetMapping(ApiConstants.ORDERS)
    public ResponseEntity<?> getOrders() throws IOException {
        URL url = new URL(ApiConstants.DATA_SERVER_ADDRESS);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");

        return new ResponseEntity<>("Nothing", HttpStatus.OK);

    }

}
