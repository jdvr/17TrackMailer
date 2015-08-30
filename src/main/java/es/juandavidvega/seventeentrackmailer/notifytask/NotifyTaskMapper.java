package es.juandavidvega.seventeentrackmailer.notifytask;

import com.google.gson.annotations.SerializedName;

public class NotifyTaskMapper {

    @SerializedName("target_email")
    public String targetEmail;

    @SerializedName("target_track_number")
    public String targetTrackNumber;


    public boolean isValid() {
        return  targetEmail != null && targetTrackNumber != null
                && !targetTrackNumber.equals("") && !targetEmail.equals("");
    }

    public NotifyTask bind() {
        return new NotifyTask(targetEmail, targetTrackNumber);
    }
}
