package com.example.reinos1500.Controllers;

import com.example.reinos1500.Entities.ReinosEntity;
import com.example.reinos1500.Services.ReinosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reinos")
public class ReinosController {

    @Autowired
    private ReinosService reinosService;

    @GetMapping
    public List<ReinosEntity> getReinos() {
        return reinosService.getAllReinos();
    }

    @GetMapping("/{id}")
    public ReinosEntity getReinoById(@PathVariable int id) {
        return reinosService.getReinoById(id);
    }

    @PostMapping
    public ReinosEntity postReino(@RequestBody ReinosEntity reino) {
        return reinosService.createReino(reino);
    }

    @PutMapping("/{id}")
    public ReinosEntity putReino(@PathVariable int id, @RequestBody ReinosEntity reino) {
        return reinosService.updateReino(id, reino);
    }

    @DeleteMapping("/{id}")
    public String deleteReino(@PathVariable int id) {
        return reinosService.deleteReino(id);
    }
}
