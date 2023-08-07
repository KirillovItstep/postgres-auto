package org.itstep.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/image")
public class ImageRestController {

    @Autowired
    ImageService imageService;

    @GetMapping({"","/"})
    public List<Image> index() {
        return imageService.findAll();
    }
}
