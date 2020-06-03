package io.shilan.wicket.pages;


import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.PackageResourceReference;

/**
 * Subclass this page to inherit the Nordea look and navigation.
 * Include asset files like images, css and javascripts here.
 */
public abstract class BasePage extends WebPage {
    private static final long serialVersionUID = 1L;


    public BasePage(final PageParameters parameters) {
    	super(parameters);
    	// add content surrounding layout.
        add(new Image("logo",new PackageResourceReference(BasePage.class,"layout/css/images/chirpy.jpg")));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
    }


    @Override
    protected void setHeaders(WebResponse response) {
        super.setHeaders(response);
        response.setHeader("X-UA-Compatible", "IE=9,chrome=1");
    }

}
