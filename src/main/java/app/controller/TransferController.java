package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.rep.hibernateimpl.TransferRepositoryHibernateImpl;

@Controller
@RequestMapping("post/transfers")
public class TransferController {

    TransferRepositoryHibernateImpl transferRepository;
}

