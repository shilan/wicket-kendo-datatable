package io.shilan.wicket.integration;

import io.shilan.wicket.models.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Slf4j
public class AddressDataProvider extends SortableDataProvider<Address, String> {

    public AddressDataProvider() {
        setSort("country", SortOrder.ASCENDING);
    }

    @Override
    public Iterator<? extends Address> iterator(long first, long count) {
        List<Address> data = new ArrayList<>(getData());
        data.sort(new SortableDataProviderComparator());
        return data.subList((int) first, (int) Math.min(first + count, data.size()))
                .iterator();
    }

    @Override
    public long size() {
        return getData().size();
    }

    @Override
    public IModel<Address> model(Address address) {
        return null;
    }

    /**
     * get the list of Addresses from your service, database etc.
     * Here I have build some sample data.
     * @return
     */
    public List<Address> getData() {
        List<Address> list = new ArrayList<Address>();
        list.add(Address.builder().id(1).country("Denmark").city("Copenhangen").number("13B").build());
        list.add(Address.builder().id(2).country("Iran").city("Tehran").number("453").build());
        list.add(Address.builder().id(3).country("UK").city("London").number("2").build());
        list.add(Address.builder().id(4).country("France").city("Paris").number("12").build());

        return list;
    }

    class SortableDataProviderComparator implements Comparator<Address>, Serializable {
        public int compare(final Address o1, final Address o2) {
            setSort("country", SortOrder.ASCENDING);
            PropertyModel<Comparable> model1 = new PropertyModel<>(o1, getSort().getProperty());
            PropertyModel<Comparable> model2 = new PropertyModel<>(o2, getSort().getProperty());

            int result;
            if (model1.getObject() != null && model2.getObject() != null) {
                result = model1.getObject().compareTo(model2.getObject());
            } else {
                result = 0;
            }

            if (!getSort().isAscending()) {
                result = -result;
            }

            return result;
        }
    }
}
