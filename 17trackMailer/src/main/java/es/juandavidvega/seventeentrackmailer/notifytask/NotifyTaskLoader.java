package es.juandavidvega.seventeentrackmailer.notifytask;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class NotifyTaskLoader {
    private static final String NotifyTaskDotJsonPath = "/var/17tracker/NotifyTasks.json";
    public static final String[] EmptyLines = new String[0];

    public NotifyTaskSet load() throws IOException {
        return getNotifyTaskSetFrom(jsonData());
    }

    public String[] jsonData() throws IOException {
        Path path = Paths.get(NotifyTaskDotJsonPath);
        try (Stream<String> stream = Files.lines(path)) {
            return stream.toArray(String[]::new);
        } catch (IOException e) {
            return EmptyLines;
        }
    }

    private NotifyTaskSet getNotifyTaskSetFrom(String[] jsonData) {
        NotifyTaskSet notifyTaskSet = new NotifyTaskSet();
        for (String jsonNotifyTask : jsonData)
            addIfiSValid(notifyTaskSet, jsonNotifyTask);
        return notifyTaskSet;
    }

    private void addIfiSValid(NotifyTaskSet notifyTaskSet, String NotifyTaskString) {
        Gson json = new Gson();
        NotifyTaskMapper notifyTaskMapper = json.fromJson(NotifyTaskString, NotifyTaskMapper.class);
        if (notifyTaskMapper.isValid()) notifyTaskSet.add(notifyTaskMapper.bind());
    }
}
