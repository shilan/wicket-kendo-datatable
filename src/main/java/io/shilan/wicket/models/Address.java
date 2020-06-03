package io.shilan.wicket.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Address {
    public Integer id;
    public String country;
    public String city;
    public String street;
    public String number;
}
