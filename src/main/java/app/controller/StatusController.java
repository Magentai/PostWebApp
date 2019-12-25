package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.rep.hibernateimpl.StatusRepositoryHibernateImpl;

@Controller
@RequestMapping("post/statuses")
public class StatusController {

    StatusRepositoryHibernateImpl statusRepository;
}

