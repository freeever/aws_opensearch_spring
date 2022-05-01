package com.aws.opensearch.spring.controller;

import com.aws.opensearch.spring.model.AbandonedMine;
import com.aws.opensearch.spring.model.DrillHole;
import com.aws.opensearch.spring.model.GeologyDocumentRequest;
import com.aws.opensearch.spring.model.ResponseData;
import com.aws.opensearch.spring.service.OpenSearchDemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/geo")
public class OpenSearchDemoController {

    private static Logger log = LoggerFactory.getLogger(OpenSearchDemoController.class);

    @Autowired
    private OpenSearchDemoService openSearchDemoService;

    /**
     * Search Abandoned Mine by its own ID, which comes from original on prem database
     * @param oriId
     * @return
     * @throws IOException
     */
    @GetMapping("/abandoned-mine/{oriId}")
    public ResponseEntity<ResponseData<AbandonedMine>> findAbandonedMineByOriId(@PathVariable String oriId)
            throws IOException {
        log.info("Find Abandoned Mine by id");
        AbandonedMine abandonedMine = openSearchDemoService.findAbandonedMineByOriId(oriId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, abandonedMine));
    }

    @GetMapping("/drill-hole/{oriId}")
    public ResponseEntity<ResponseData<DrillHole>> findDrillHoleByOriId(@PathVariable String oriId)
            throws IOException {
        log.info("Find Drill Hole by id");
        DrillHole drillHole = openSearchDemoService.findDrillHoleByOriId(oriId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, drillHole));
    }

    @PostMapping
    public ResponseEntity<ResponseData<?>> add(@RequestBody GeologyDocumentRequest request) throws IOException {
        log.info("Add Geology Ontario documents indices...");
        int response = openSearchDemoService.add(request);
        String msg = String.format("%d Geology Ontario records were added", response);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, msg));
    }

    @PutMapping
    public ResponseEntity<ResponseData<?>> update(@RequestBody GeologyDocumentRequest request) throws IOException {
        log.info("Update Geology Ontario documents indices...");
        int response = openSearchDemoService.update(request);
        String msg = String.format("%d Geology Ontario records were updated", response);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, msg));
    }

    @PostMapping("/index/{name}")
    public ResponseEntity<ResponseData<?>> createIndex(@PathVariable String name) throws IOException {
        log.info("Create new index {}", name);
        openSearchDemoService.createIndex(name);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, ""));
    }

    @DeleteMapping("/index/{name}")
    public ResponseEntity<ResponseData<?>> deleteIndex(@PathVariable String name) throws IOException {
        log.info("Delete index {}", name);
        openSearchDemoService.deleteIndex(name);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseData<>(true, ""));
    }
}
