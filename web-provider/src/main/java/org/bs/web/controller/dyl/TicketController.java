package org.bs.web.controller.dyl;

import org.bs.web.mapper.dyl.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketMapper ticketMapper;
}
