package com.example.sleuthoverrideexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DummyController {

    @GetMapping("/dummy")
    public ResponseEntity<Void> dummy() {
        log.info("Here's a log line!");
        return ResponseEntity.ok().build();
    }
}
