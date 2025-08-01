package com.example.invoice.entry.controller.common;

import com.example.invoice.entry.entity.User;
import com.example.invoice.entry.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminMenuController {
    private final UserService userService;

    public AdminMenuController(UserService userService) {
        this.userService = userService;
    }

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
    public String loadPendingFragment(Model model){
        List<User> pending = userService.findByStatus(User.Status.PENDING);
        model.addAttribute("users",pending);
        return "fragments/pending :: content";
    }
}
