package org.example.threllia.Controllers;

import org.example.threllia.Modal.News.LatestUpdate;
import org.example.threllia.Servicies.LatestUpdateService;
import org.example.threllia.requests.LatestUpdateRequest;
import org.example.threllia.utils.FileUploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private FileUploader fileUploader;
    @Autowired
    private LatestUpdateService latestUpdateService;

    @GetMapping
    public ResponseEntity<List<LatestUpdate>> getAllNews(){
        return new ResponseEntity<>(latestUpdateService.getAllNews(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LatestUpdate> getLatestUpdateById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(latestUpdateService.getLatestUpdateById(id), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LatestUpdate> createLatestUpdate(@RequestPart("content") LatestUpdateRequest request, @RequestPart("image") MultipartFile image) throws Exception {
        String fileName = FileUploader.uploadLatestUpdateImage(image);
        System.out.println("fileName");
        LatestUpdate newLatestUpdate = latestUpdateService.createLatestUpdate(request, fileName);
        return new ResponseEntity<>(newLatestUpdate, HttpStatus.CREATED);
    }

}
