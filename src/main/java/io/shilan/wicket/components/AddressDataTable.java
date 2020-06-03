package io.shilan.wicket.components;

import com.googlecode.wicket.kendo.ui.datatable.button.CommandButton;
import com.googlecode.wicket.kendo.ui.datatable.column.CommandColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.IColumn;
import com.googlecode.wicket.kendo.ui.datatable.column.IdPropertyColumn;
import com.googlecode.wicket.kendo.ui.datatable.editor.DropDownListEditor;
import com.googlecode.wicket.kendo.ui.datatable.editor.IKendoEditor;
import io.shilan.wicket.models.Country;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.lang.Generics;

import java.util.Arrays;
import java.util.List;

public class AddressDataTable {

    public static List<IColumn> newColumnList() {
        List<IColumn> columns = Generics.newArrayList();
        /* Important, for being sent back to server */
        columns.add(new IdPropertyColumn("id", "id", 50) {
            @Override
            public boolean isVisible(){
                return true;
            }
        });
        columns.add(new com.googlecode.wicket.kendo.ui.datatable.column.PropertyColumn("country", "country") {

            @Override
            public IKendoEditor getEditor() {
                return new DropDownListEditor("countries", Country.values());
            }
        });
        columns.add(new com.googlecode.wicket.kendo.ui.datatable.column.PropertyColumn("city", "city"));
        columns.add(new com.googlecode.wicket.kendo.ui.datatable.column.PropertyColumn("street", "street"));
        columns.add(new com.googlecode.wicket.kendo.ui.datatable.column.PropertyColumn("number", "number") {
            @Override
            public Boolean isEditable() {
                return new Boolean(false);
            }
        });


        columns.add(new CommandColumn() {

            private static final long serialVersionUID = 1L;

            @Override
            public List<CommandButton> newButtons()
            {
                /*
                 * 'edit' and 'destroy' are built-in buttons/commands, no property has to be to supply
                 * #onUpdate(AjaxRequestTarget target, JSONObject object) will be triggered
                 * #onDelete(AjaxRequestTarget target, JSONObject object) will be triggered
                 * #onClick(AjaxRequestTarget, CommandButton, String) will not be triggered
                 */
                return Arrays.asList(new CommandButton("edit", Model.of("Edit")), new CommandButton("destroy", Model.of("Delete")));
            }
        });

        return columns;
    }
}
