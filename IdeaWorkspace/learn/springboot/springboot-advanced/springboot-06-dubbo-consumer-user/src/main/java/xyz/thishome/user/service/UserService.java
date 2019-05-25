package xyz.thishome.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import xyz.thishome.ticket.service.TicketService;

@Service
public class UserService {

    @Reference(version = "1.0.0")
    TicketService ticketService;

    public void hello() {
        System.out.println(ticketService);
    }

}
