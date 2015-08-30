package es.juandavidvega.seventeentrackmailer;

import java.io.IOException;

import javax.mail.MessagingException;

import es.juandavidvega.seventeentrackmailer.notifytask.NotifyTaskLoader;
import es.juandavidvega.seventeentrackmailer.trackinfo.PackageInfo;
import es.juandavidvega.seventeentrackmailer.trackinfo.PackagesInfo;


public class App {
    public static void main(String[] args) throws IOException, MessagingException {
        PackagesInfo trackInfo = SeventeenTracker.requestTrackInfoFor(new NotifyTaskLoader().load());
        for (PackageInfo packageTrackInfo : trackInfo) {
            new MailSender(packageTrackInfo.email(), packageTrackInfo.trackInfo()).send();
        }
    }
}
