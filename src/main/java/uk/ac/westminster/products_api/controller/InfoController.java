package uk.ac.westminster.products_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/get-info")
    public String getInfo() {
        return "Description of the application.";
    }
}
