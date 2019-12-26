package app.controller;

import app.obj.Office;
import app.services.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/post/offices")
public class OfficeController {

    @Autowired
    private OfficeService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("offices", service.listAll());
        return "post/offices/list";
    }

    @GetMapping("/add")
    public String showAddForm(Office obj) {
        return "post/offices/add";
    }

    @PostMapping("/add/result")
    public RedirectView addOffice(@Valid Office obj,Model model) {
        service.save(obj);
        return new RedirectView("/post/offices/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam Long id) {
        service.delete(id);
        return new RedirectView("/post/offices/list");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("office", service.get(id));
        return "post/offices/edit";
    }

    @PostMapping("/edit/result")
    public RedirectView edit(@Valid Office obj) {
        service.delete(obj.getId());
        service.save(obj);
        return new RedirectView("/post/offices/list");
    }
}

