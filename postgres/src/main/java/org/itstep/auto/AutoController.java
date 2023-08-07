package org.itstep.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AutoController {

    @Autowired
    AutoService autoService;

    @PostMapping("/save")
    public String save(@RequestParam("file1") MultipartFile file1) throws IOException {
        autoService.save(file1);
            return "redirect:/new";
    }

    @GetMapping("/new")
    public String newImage(Model model) {
        model.addAttribute("images", autoService.findAll());
        return "new";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/new";
    }
}
