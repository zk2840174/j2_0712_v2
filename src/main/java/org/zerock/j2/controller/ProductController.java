package org.zerock.j2.controller;

import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.j2.dto.*;
import org.zerock.j2.service.ProductService;
import org.zerock.j2.util.FileUploader;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;


@CrossOrigin
@RestController
@RequestMapping("/api/products/")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    private final FileUploader uploader;

    @PostMapping("")
    public Map<String, Long> register( ProductDTO productDTO ){

        log.info(productDTO);

        List<String> fileNames = uploader.uploadFiles(productDTO.getFiles(), true);
        productDTO.setImages(fileNames);

        Long pno = service.register(productDTO);

        return Map.of("result", pno);
    }

    @GetMapping(value="list")
    public PageResponseDTO<ProductListDTO> list(PageRequestDTO pageRequestDTO) {

        log.info("---------------------------");
        log.info(pageRequestDTO);

        return service.list(pageRequestDTO);

    }
    

    
}
