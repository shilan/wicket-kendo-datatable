package io.shilan.wicket.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.github.openjson.JSONObject;
import com.googlecode.wicket.jquery.core.Options;
import com.googlecode.wicket.kendo.ui.datatable.DataTable;
import com.googlecode.wicket.kendo.ui.panel.KendoFeedbackPanel;
import io.shilan.wicket.components.AddressDataTable;
import io.shilan.wicket.integration.AddressDataProvider;
import io.shilan.wicket.models.Address;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;


@WicketHomePage
public class HomePage extends BasePage {
    private static final long serialVersionUID = 1L;
    private AddressDataProvider dataProvider = new AddressDataProvider();

    @Override
    protected void onInitialize() {
        super.onInitialize();
    }

    public HomePage(PageParameters parameters) {
        super(parameters);

        setVersioned(false); //No backward history state
        // FeedbackPanel //
        final KendoFeedbackPanel feedback = new KendoFeedbackPanel("feedback");
        add(feedback);

        // DataTable //
        Options options = new Options();
        options.set("editable", Options.asString("inline"));
        options.set("pageable", true);
        options.set("toolbar", "[ { name: 'create', text: 'Create' } ]"); /* 'toolbar' option can be used as long as #getToolbarButtons returns no button */
        options.set("reorderable", true);

        final DataTable<Address> table = new DataTable<Address>("datatable", AddressDataTable.newColumnList(), dataProvider, 25, options) {

            private static final long serialVersionUID = 1L;

            @Override
            public void onCancel(AjaxRequestTarget target)
            {
                this.info("Cancelled...");
                target.add(feedback);
            }

            @Override
            public void onCreate(AjaxRequestTarget target, JSONObject object) {
                Address quarantinedIpAddress = Address.builder()
                        .country(object.get("country").toString())
                        .city(object.get("city").toString())
                        .build();
                        this.warn("created #" + quarantinedIpAddress.getCountry());

                target.add(feedback);
            }

            @Override
            public void onUpdate(AjaxRequestTarget target, JSONObject object) {
                    Address quarantinedIpAddress = Address.builder()
                            .country(object.get("country").toString())
                            .city(object.get("city").toString())
                            .build();
//                    client.updateStatusAndReason(quarantinedIpAddress);

                    this.warn("Updated #" + quarantinedIpAddress.getCountry());
                target.add(feedback);
            }

            @Override
            public void onDelete(AjaxRequestTarget target, JSONObject object) {
                String id = object.get("id").toString();
//                client.delete(id);

                this.warn("Deleted #" + id);
                target.add(feedback);
            }
        };

        table.setOutputMarkupId(true);
        add(table);

    }

}
