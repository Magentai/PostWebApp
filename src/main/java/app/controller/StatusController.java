package app.controller;

import app.obj.Status;
import app.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("post/statuses")
public class StatusController {

    @Autowired
    private StatusService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("statuses", service.listAll());
        return "post/statuses/list";
    }

    @GetMapping("/add")
    public String showAddForm(Status obj) {
        return "post/statuses/add";
    }

    @PostMapping("/add/result")
    public RedirectView add(@Valid Status obj, Model model) {
        service.save(obj);
        return new RedirectView("/post/statuses/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam Long id) {
        service.delete(id);
        return new RedirectView("/post/statuses/list");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("status", service.get(id));
        return "post/statuses/edit";
    }

    @PostMapping("/edit/result")
    public RedirectView edit(@Valid Status obj) {
        service.delete(obj.getId());
        service.save(obj);
        return new RedirectView("/post/statuses/list");
    }
}


