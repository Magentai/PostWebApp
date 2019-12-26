package app.controller;

import app.obj.PostPackage;
import app.services.PostPackageService;
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
@RequestMapping("post/packages")
public class PackageController {

    @Autowired
    private PostPackageService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("packages", service.listAll());
        return "post/packages/list";
    }

    @GetMapping("/add")
    public String showAddForm(PostPackage obj) {
        return "post/packages/add";
    }

    @PostMapping("/add/result")
    public RedirectView add(@Valid PostPackage obj, Model model) {
        service.save(obj);
        return new RedirectView("/post/packages/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam Long id) {
        service.delete(id);
        return new RedirectView("/post/packages/list");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("packages", service.get(id));
        return "post/packages/edit";
    }

    @PostMapping("/edit/result")
    public RedirectView edit(@Valid PostPackage obj) {
        service.delete(obj.getId());
        service.save(obj);
        return new RedirectView("/post/packages/list");
    }

}

