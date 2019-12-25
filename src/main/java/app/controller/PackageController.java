package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.rep.hibernateimpl.PackageRepositoryHibernateImpl;

@Controller
@RequestMapping("post/packages")
public class PackageController {

    PackageRepositoryHibernateImpl packageRepository;
}

