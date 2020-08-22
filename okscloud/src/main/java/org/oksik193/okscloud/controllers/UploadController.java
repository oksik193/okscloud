package org.oksik193.okscloud.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/upload")
    public String diskMain (Model model) {
        return "upload";
    }

    @PostMapping("/upload")
    public String addFile (@RequestParam ("file") MultipartFile file) throws IOException {
        if(file != null) {
            File uploadDir = new File(uploadPath);

            /*if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }*/
            String fileName = file.getOriginalFilename();
            file.transferTo(new File(uploadPath + fileName));


        }

        return "userDisk";
    }
}
