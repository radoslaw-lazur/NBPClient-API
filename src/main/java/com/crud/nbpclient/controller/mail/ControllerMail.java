package com.crud.nbpclient.controller.mail;

import com.crud.nbpclient.scheduler.MailScheduler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/v1/mail")
public class ControllerMail {
    @Autowired
    private MailScheduler mailScheduler;

    @PostMapping(value = "setCc")
    public void setCc(@RequestBody String mailCc) {
        log.info("Starting setting Cc to mail scheduler");
        if (mailCc.equals("null")) {
            mailScheduler.setMailCc(null);
        } else {
            mailScheduler.setMailCc(mailCc);
        }
        log.info("Cc has been set to: " + mailCc);
    }

    @GetMapping(value = "getCc")
    public void getCc() {
        System.out.println(mailScheduler.getMailCc());
    }

    @PostMapping(value = "sendMail")
    public void sendMail() {
        log.info("External requested mail preparation in progress");
        mailScheduler.sendScheduledMail();
    }
}
