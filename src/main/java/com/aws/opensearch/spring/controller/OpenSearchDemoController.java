package com.aws.opensearch.spring.controller;

import com.aws.opensearch.spring.ResponseData;
import com.aws.opensearch.spring.service.OpenSearchDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/search")
public class OpenSearchDemoController {

    private static Logger log = LoggerFactory.getLogger(OpenSearchDemoController.class);

    @Autowired
    private OpenSearchDemoService openSearchDemoService;

    @PostMapping("/{name}")
    public ResponseEntity<ResponseData<?>> createIndex(@PathVariable String name) throws IOException {
        log.info("Create new index {}", name);
        openSearchDemoService.createIndex(name);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, ""));
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<ResponseData<?>> deleteIndex(@PathVariable String name) throws IOException {
        log.info("Delete index {}", name);
        openSearchDemoService.deleteIndex(name);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, ""));
    }
}
