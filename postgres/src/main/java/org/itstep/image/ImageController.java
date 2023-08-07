package org.itstep.image;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {

    @Autowired
    ImageService imageService;

    @PostMapping("/save")
    public String save(@RequestParam("file") MultipartFile file) throws IOException {
        imageService.save(file);
        return "redirect:/";
    }

    @GetMapping({"/",""})
    public String index(Model model) {
        List<Image> images = imageService.findAll();
        List<String> imagesBase64 = new ArrayList<>();
        images.stream().forEach(image->{
            imagesBase64.add(Base64.encodeBase64String(image.getBytes()));
        });
        //System.out.println(images);
        model.addAttribute("images",imagesBase64);
        return "images";
    }
}
