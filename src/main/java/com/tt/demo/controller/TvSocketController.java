package com.tt.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hansiyuan
 * @date 2021年06月22日 9:14
 */
@RestController
@RequestMapping("/api/tv")
public class TvSocketController {

    @GetMapping("/start")
    public String start() {
        return "start";
    }

    @GetMapping("/end")
    public String end() {
        return "end";
    }
}
