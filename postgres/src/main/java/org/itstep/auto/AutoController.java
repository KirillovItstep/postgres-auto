package org.itstep.auto;

import org.apache.tomcat.util.codec.binary.Base64;
import org.itstep.image.Image;
import org.itstep.image.ImageService;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auto")
public class AutoController {

    @Autowired
    AutoService autoService;

    @Autowired
    ImageService imageService;

    @PostMapping("/save")
    public String save(@RequestParam("name") String name, @RequestParam("files") List<MultipartFile> files) throws IOException {
        Auto auto = new Auto();
        auto.setName(name);
        Set<Image> images = new HashSet<>();
        files.stream().forEach(file-> {
            try {
                Image image = imageService.toImageEntity(file);
                image.setAuto(auto);
                images.add(image);
                //System.out.println(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        auto.setImages(images);
        System.out.println(auto);
        autoService.save(auto);
        return "redirect:/auto";
    }

    @GetMapping({"","/"})
    public String index(Model model) {
        //model.addAttribute("autos", new ArrayList<>());

        List<AutoDto> autoDtos =autoService.findAll().stream().map(auto->{
            AutoDto autoDto = new AutoDto();
            autoDto.setId(auto.getId());
            autoDto.setName(auto.getName());
            Set<String> imagesBase64 = new HashSet<>();
            auto.getImages().stream().forEach(image->{
                imagesBase64.add(Base64.encodeBase64String(image.getBytes()));
                autoDto.setImages(imagesBase64);
            });
            return autoDto;}).collect(Collectors.toList());
        model.addAttribute("autos", autoDtos);
        return "autos";
    }
}