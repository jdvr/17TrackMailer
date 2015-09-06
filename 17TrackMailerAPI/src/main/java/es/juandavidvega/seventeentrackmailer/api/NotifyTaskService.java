package es.juandavidvega.seventeentrackmailer.api;

import java.io.IOException;

import es.juandavidvega.seventeentrackmailer.notifytask.NotifyTaskLoader;

public class NotifyTaskService {

    public String readAll() {
        try {
            return new NotifyTaskLoader().load().toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
