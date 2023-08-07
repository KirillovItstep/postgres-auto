package org.itstep.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
    public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    public Image findById(Long id){
        return imageRepository.findById(id).orElse(null);
    }

    @Transactional
    public Image save(MultipartFile file) throws IOException {
        return imageRepository.save(toImageEntity(file));
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setBytes(file.getBytes());
        return image;
    }
}