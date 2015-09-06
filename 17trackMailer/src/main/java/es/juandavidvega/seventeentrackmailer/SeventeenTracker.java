package es.juandavidvega.seventeentrackmailer;

import es.juandavidvega.seventeentrackmailer.notifytask.NotifyTaskSet;
import es.juandavidvega.seventeentrackmailer.trackinfo.PackagesInfo;

public class SeventeenTracker {

    public static PackagesInfo requestTrackInfoFor(final NotifyTaskSet notifyTaskSet){
        return new PackagesInfo(notifyTaskSet.toArray());
    }

}
