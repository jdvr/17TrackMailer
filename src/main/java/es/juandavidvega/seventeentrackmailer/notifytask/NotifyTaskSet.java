package es.juandavidvega.seventeentrackmailer.notifytask;


import java.util.ArrayList;
import java.util.List;

import es.juandavidvega.seventeentrackmailer.NotifyTask;

/**
 * Created by JuanDavid on 8/20/2015.
 */
public class NotifyTaskSet {
    private final List<NotifyTask> notifyTaskSet = new ArrayList<>();

    public NotifyTask get(int index) {
        return notifyTaskSet.get(index);
    }

    public boolean add(NotifyTask notifyTask) {
        return notifyTaskSet.add(notifyTask);
    }

    public NotifyTask[] toArray() {
        return notifyTaskSet.toArray(new NotifyTask[notifyTaskSet.size()]);
    }
}
