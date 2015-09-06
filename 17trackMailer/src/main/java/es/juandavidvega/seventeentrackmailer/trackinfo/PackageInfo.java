package es.juandavidvega.seventeentrackmailer.trackinfo;

public class PackageInfo {

    private final String email;
    private final String trackInfo;

    public PackageInfo(String email, String trackInfo) {
        this.email = email;
        this.trackInfo = trackInfo;
    }

    public String email(){
        return email;
    }

    public String trackInfo(){
        return trackInfo;
    }

}
