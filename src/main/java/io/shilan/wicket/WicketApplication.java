package io.shilan.wicket;

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication;
import com.googlecode.wicket.kendo.ui.settings.KendoUILibrarySettings;
import io.shilan.wicket.pages.layout.js.KendoAllResourceReference;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.RuntimeConfigurationType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class WicketApplication extends WicketBootStandardWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WicketApplication.class, args);
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // If you cannot link to a javascript library cdn directly here you can include it locally.
        KendoUILibrarySettings settings = KendoUILibrarySettings.get();
        settings.setJavaScriptReference(KendoAllResourceReference.get());

        getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
        getMarkupSettings().setDefaultMarkupEncoding("UTF-8");

        // Set default error pages for HTML markup
        if (getConfigurationType() == RuntimeConfigurationType.DEPLOYMENT) {
            //Restart on error
            getMarkupSettings().setStripWicketTags(true);
        }
        getApplicationSettings().setPageExpiredErrorPage(getHomePage());
    }
}
