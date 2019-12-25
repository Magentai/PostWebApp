package app.controller;

import app.obj.Office;
import app.services.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import app.rep.hibernateimpl.OfficeRepositoryHibernateImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/post/offices")
public class OfficeController {

    OfficeService officeService;

    @GetMapping("/list")
    ModelAndView list() {
        Map<String, List<Office>> data = new HashMap<String, List<Office>>();

        data.put("offices", officeService.findFirstHundred());
        return new ModelAndView("post/offices/list",
                data,
                HttpStatus.OK);
    }
}

