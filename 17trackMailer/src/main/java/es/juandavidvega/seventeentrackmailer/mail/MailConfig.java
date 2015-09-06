package es.juandavidvega.seventeentrackmailer.mail;

/**
 * Created by JuanDavid on 9/6/2015.
 */
public enum MailConfig {
    Host("127.0.0.1"),
    From("root@juandavidvega.es"),
    Subject("Package tracking information");

    private String value;

    MailConfig(String value) {

        this.value = value;
    }

    public String value() {
        return value;
    }
}
