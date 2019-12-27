package app.controller;

import app.obj.Transfer;
import app.services.StatusService;
import app.services.TransferService;
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
@RequestMapping("post/transfers")
public class TransferController {

    @Autowired
    private TransferService service;
    @Autowired
    private StatusService statusService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("transfers", service.listAll());
        return "post/transfers/list";
    }

    @GetMapping("/add")
    public String showAddForm(Transfer obj, Model model) {
        model.addAttribute("statuses", statusService.listAll());
        return "post/transfers/add";
    }

    @PostMapping("/add/result")
    public RedirectView add(@Valid Transfer obj, Model model) {
        service.save(obj);
        return new RedirectView("/post/transfers/list");
    }

    @GetMapping("/delete")
    public RedirectView delete(@RequestParam Long id) {
        service.delete(id);
        return new RedirectView("/post/transfers/list");
    }

    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model) {
        model.addAttribute("transfer", service.get(id));
        return "post/transfers/edit";
    }

    @PostMapping("/edit/result")
    public RedirectView edit(@Valid Transfer obj) {
        service.delete(obj.getId());
        service.save(obj);
        return new RedirectView("/post/transfers/list");
    }

}

