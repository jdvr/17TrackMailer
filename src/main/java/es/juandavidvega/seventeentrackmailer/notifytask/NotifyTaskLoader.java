package es.juandavidvega.seventeentrackmailer.notifytask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

public class NotifyTaskLoader {
    private static final String NotifyTaskDotJsonPath = "/var/17tracker/NotifyTasks.json";
    public static final ArrayList<String> EmptyList = new ArrayList<>();

    public NotifyTaskSet load() throws IOException {

        return getNotifyTaskSetFrom(jsonData());
    }

    private ArrayList<String> jsonData() throws IOException {
        ArrayList<String> notifyTaskFileContent = new ArrayList<>();
        try{
            File notifyTaskFile = new File(NotifyTaskDotJsonPath);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(notifyTaskFile));
            String line;
            while ((line = bufferedReader.readLine()) != null)
                notifyTaskFileContent.add(line);
        } catch (FileNotFoundException ex) {
            return EmptyList;
        }
        return notifyTaskFileContent;
    }

    private NotifyTaskSet getNotifyTaskSetFrom(ArrayList<String> jsonData) {
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
