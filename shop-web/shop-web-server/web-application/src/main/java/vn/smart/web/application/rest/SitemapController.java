package vn.smart.web.application.rest;

import com.redfin.sitemapgenerator.WebSitemapGenerator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@RestController
@CrossOrigin
public class SitemapController extends AbstractController {

    private static final String BASE_URL = "https://sieuthimega.com";

    @RequestMapping(path = "/sitemap.xml", produces = APPLICATION_XML_VALUE)
    public void createSiteMap(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_XML_VALUE);
        try (Writer writer = response.getWriter()) {
            writer.append(createSitemap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createSitemap() throws MalformedURLException {
        WebSitemapGenerator sitemap = new WebSitemapGenerator(BASE_URL);
        sitemap.addUrl(BASE_URL + "/thietbi-dientu");
        sitemap.addUrl(BASE_URL + "/thoitrang-nu");
        sitemap.addUrl(BASE_URL + "/thoitrang-nam");
        sitemap.addUrl(BASE_URL + "/nha-bep");
        sitemap.addUrl(BASE_URL + "/giay-tuixach");
        sitemap.addUrl(BASE_URL + "/camera");
        sitemap.addUrl(BASE_URL + "/linh-kien-may-tinh");
        sitemap.addUrl(BASE_URL + "/noithat-giadung");
        sitemap.addUrl(BASE_URL + "/me-va-be");
        sitemap.addUrl(BASE_URL + "/cho-do-cu");
        return String.join("", sitemap.writeAsStrings());
    }
}
