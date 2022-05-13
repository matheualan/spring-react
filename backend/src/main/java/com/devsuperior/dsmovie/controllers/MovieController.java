package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;
import com.devsuperior.dsmovie.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Log4j2
@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findAll"));
        return ResponseEntity.ok().body(movieService.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MovieDTO> findById(@PathVariable(value = "id") Long id) {
        log.info(dateUtil.dateFormatted(LocalDateTime.now()).concat(" /GET findById"));
        return ResponseEntity.ok().body(movieService.findById(id));
    }

}
