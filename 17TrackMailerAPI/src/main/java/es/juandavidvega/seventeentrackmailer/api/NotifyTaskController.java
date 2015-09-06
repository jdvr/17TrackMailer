package es.juandavidvega.seventeentrackmailer.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class NotifyTaskController {

    NotifyTaskService notifyTaskService = new NotifyTaskService();

    @RequestMapping("/read")
    @ResponseBody
    String readCurrentNotifyTask() {
        return notifyTaskService.readAll();
    }

}
