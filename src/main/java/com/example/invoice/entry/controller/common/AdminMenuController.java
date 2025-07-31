package com.example.invoice.entry.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminMenuController {
    @GetMapping("/qna")
    public String loadQnaFragment(){
        return "fragments/qna :: content";
    }
    @GetMapping("/ocr")
    public String loadOcrFragment(){
        return "fragments/ocr :: content";
    }
    @GetMapping("/verification")
    public String loadVerificationFragment(){
        return "fragments/verification :: content";
    }

    @GetMapping("/email")
    public String loadEmailFragment(){
        return "fragments/email :: content";
    }
    @GetMapping("/guide")
    public String loadGuideFragment(){
        return "fragments/guide :: content";
    }
    @GetMapping("/pending")
    public String loadPendingFragment(){
        return "fragments/pending :: content";
    }
}
