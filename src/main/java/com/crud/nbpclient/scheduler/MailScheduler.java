package com.crud.nbpclient.scheduler;

import com.crud.nbpclient.config.AdminConfig;
import com.crud.nbpclient.controller.nbpapi.ControllerNbp;
import com.crud.nbpclient.domain.chf.Chf;
import com.crud.nbpclient.domain.eur.Eur;
import com.crud.nbpclient.domain.gbp.Gbp;
import com.crud.nbpclient.domain.mail.Mail;
import com.crud.nbpclient.repository.RepositoryChf;
import com.crud.nbpclient.repository.RepositoryEur;
import com.crud.nbpclient.repository.RepositoryGbp;
import com.crud.nbpclient.service.mail.SimpleMailService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;

@Component
@Setter
@Getter
@Slf4j
public class MailScheduler {
    @Autowired
    private SimpleMailService simpleMailService;
    @Autowired
    private RepositoryChf repositoryChf;
    @Autowired
    private RepositoryEur repositoryEur;
    @Autowired
    private RepositoryGbp repositoryGbp;
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private ControllerNbp controllerNbp;

    private String mailCc = null;
    private static final String SUBJECT_ALL = "Rates: ** CHF ** EUR ** GBP ** "
            + LocalDate.now(ZoneId.of("Europe/Paris"));

    @Scheduled(fixedDelay = 4000)
    public void sendScheduledMail() {
        long sizeChf = repositoryChf.count();
        long sizeEur = repositoryEur.count();
        long sizeGbp = repositoryGbp.count();

        simpleMailService.send(new Mail(
                        adminConfig.getAdminMail(),
                        mailCc,
                        SUBJECT_ALL,
                        "CHF records: " + sizeChf + "\n" + printRatesChf() + "\n" + "EUR records: " + sizeEur
                                + "\n" + printRatesEur() + "\n" + "GBP records: " + sizeGbp + "\n" + printRatesGbp()
        ));

        if (sizeChf == 31 || sizeEur == 31 || sizeGbp == 31) {
            repositoryChf.deleteAll();
            repositoryEur.deleteAll();
            repositoryGbp.deleteAll();
            log.info("Repositories cleaned up");
        }
    }

    private String printRatesChf() {
        controllerNbp.saveCHF();
        StringBuilder chfRates = new StringBuilder();
        for (Chf chf : repositoryChf.findAll()) {
            chfRates.append(chf.getName()).append(" * ").append(chf.getDate()).append(" * ").append(chf.getMidPLN())
                    .append(" PLN").append("\n");
        }
        return chfRates.toString();
    }

    private String printRatesEur() {
        controllerNbp.saveEUR();
        StringBuilder eurRates = new StringBuilder();
        for (Eur eur : repositoryEur.findAll()) {
            eurRates.append(eur.getName()).append(" * ").append(eur.getDate()).append(" * ").append(eur.getMidPLN())
                    .append(" PLN").append("\n");
        }
        return eurRates.toString();
    }

    private String printRatesGbp() {
        controllerNbp.saveGBP();
        StringBuilder gbpRates = new StringBuilder();
        for (Gbp gbp : repositoryGbp.findAll()) {
            gbpRates.append(gbp.getName()).append(" * ").append(gbp.getDate()).append(" * ").append(gbp.getMidPLN())
                    .append(" PLN").append("\n");
        }
        return gbpRates.toString();
    }
}
