package org.example.boottestcicd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fishcake")
public class FishcakeController {
    @GetMapping
    public ResponseEntity<List<Fishcake>> list() {
        List<Fishcake> fishcakes = List.of(
                new Fishcake("스펀지밥"), new Fishcake("뚱이"),
                new Fishcake("징징이"), new Fishcake("집게사장")
        );
        return ResponseEntity.ok(fishcakes);
    }

    public record Fishcake(String shape) {
    }
}
