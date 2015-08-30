package es.juandavidvega.seventeentrackmailer.trackinfo;

import java.io.IOException;
import java.util.Iterator;

import es.juandavidvega.seventeentrackmailer.notifytask.NotifyTask;

public class PackagesInfo implements Iterable<PackageInfo>{

    public static final String ERRO_MESSAGE = "Unnable to get package track information";

    private NotifyTask[] notifyTasks;

    public PackagesInfo(NotifyTask[] notifyTasks) {

        this.notifyTasks = notifyTasks;
    }

    public Iterator<PackageInfo> iterator() {
        return new Iterator<PackageInfo>() {

            private int index = 0;
            public boolean hasNext() {
                return notifyTasks.length > index;
            }

            public PackageInfo next() {

                try {
                    PackageInfo trackInfo = new PackageInfo(targetEmail(), getTrackingInformation());
                    index++;
                    return trackInfo;
                } catch (IOException e) {
                    return new PackageInfo(targetEmail(), ERRO_MESSAGE);
                }
            }

            private String targetEmail() {
                return notifyTasks[index].targetEmail();
            }

            private String getTrackingInformation() throws IOException {
                return new TrackNumberRequest().track(notifyTasks[index].targetTrackNumber());
            }
        };
    }
}
