package app.controller;

import app.obj.PackageType;
import app.services.PackageTypeService;
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
@RequestMapping("post/packagetypes")
public class PackageTypeController {

    @Autowired
    private PackageTypeService service;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("packagetypes", service.listAll());
        return "post/packagetypes/list";
    }

    @GetMapping("/add")
    public String showAddForm(PackageType obj) {
        return "post/packagetypes/add";
    }

    @PostMapping("/add/result")
    public RedirectView add(@Valid PackageType obj, Model model) {
        service.save(obj);
        return new RedirectView("/post/packagetypes/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam Long id) {
        service.delete(id);
        return new RedirectView("/post/packagetypes/list");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("packageType", service.get(id));
        return "post/packagetypes/edit";
    }

    @PostMapping("/edit/result")
    public RedirectView edit(@Valid PackageType obj) {
        service.delete(obj.getId());
        service.save(obj);
        return new RedirectView("/post/packagetypes/list");
    }
}

