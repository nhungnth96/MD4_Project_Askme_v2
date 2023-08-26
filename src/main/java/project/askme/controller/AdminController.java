package project.askme.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import project.askme.model.Category;
import project.askme.model.User;
import project.askme.service.AnswerService;
import project.askme.service.CategoryService;
import project.askme.service.QuestionService;
import project.askme.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @GetMapping()
    public String goDashboard() {

        return "admin/index";
    }
    // ============================== GET USER LIST ==============================
    @GetMapping("/users")
    public String showAllUser(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/user";
    }
    // ============================== GET CAT LIST ==============================
    @GetMapping("/categories")
    public String showAllCat(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "admin/category";
    }

}
