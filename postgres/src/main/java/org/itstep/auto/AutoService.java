package org.itstep.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
    public class AutoService {

    @Autowired
    private AutoRepository autoRepository;

    public List<Auto> findAll() {
        return autoRepository.findAll();
    }

    public Auto findById(Long id){
        return autoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Auto save(MultipartFile file) throws IOException {
        return autoRepository.save(toImageEntity(file));
    }

    private Auto toImageEntity(MultipartFile file) throws IOException {
        Auto auto = new Auto();
        auto.setName(file.getOriginalFilename());
        return auto;
    }
}