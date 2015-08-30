package es.juandavidvega.seventeentrackmailer.notifytask;

/**
 * Created by JuanDavid on 8/20/2015.
 */
public class NotifyTask {

    public final String targetEmail;
    public final String targetTrackNumber;

    public NotifyTask(String targetEmail, String targetTrackNumber) {
        this.targetEmail = targetEmail;
        this.targetTrackNumber = targetTrackNumber;
    }

    public String targetEmail(){
        return this.targetEmail;
    }


    public String targetTrackNumber(){
        return this.targetTrackNumber;
    }
}
