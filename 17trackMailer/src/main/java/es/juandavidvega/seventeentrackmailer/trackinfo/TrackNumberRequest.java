package es.juandavidvega.seventeentrackmailer.trackinfo;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSection;

public class TrackNumberRequest {

    public static final String BASE_URL = "http://www.17track.net/en/result/post-details.shtml?nums=";

    public String track(String trackNumber) throws IOException {
        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);
        final HtmlPage page = webClient.getPage(BASE_URL + trackNumber);
        final HtmlSection section = page.getHtmlElementById("events");
        return section.asText();
    }
}
