package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.rep.hibernateimpl.PackageTypeRepositoryHibernateImpl;

@Controller
@RequestMapping("post/packagetypes")
public class PackageTypeController {

    PackageTypeRepositoryHibernateImpl packageTypeRepository;
}

