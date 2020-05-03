package com.gusev.otus.docker.controller;

import java.io.Serializable;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Greeting controller
 *
 * @author A. Gusev
 * @since 18 апр. 2020 г.
 */
@Slf4j
@RestController
public class GreetingController {

    @Getter
    @AllArgsConstructor
    public static class ResponseVO implements Serializable {

        private static final long serialVersionUID = -1174063250154475944L;

        private HttpStatus status;
    }

    @GetMapping("health")
    @ResponseBody
    ResponseEntity<ResponseVO> checkHeatlh() {
        log.debug("Check health: '{}'", new Date());
        return ResponseEntity.ok(new ResponseVO(HttpStatus.OK));
    }
}
