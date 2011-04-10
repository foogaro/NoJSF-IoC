package com.foogaro.nojsf.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO extends ABaseDTO {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getIdentifier() {
        return this.lastName;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.lastName = identifier;
    }

}
