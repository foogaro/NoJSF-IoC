package com.foogaro.nojsf.model;

import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "response")
public class ResponseWrapper implements Serializable{

    private List<? extends DataWrapper> dataWrapper;

    @XmlElementRef
    public List<? extends DataWrapper> getDataWrapper() {
        return dataWrapper;
    }

    public void setDataWrapper(List<? extends DataWrapper> dataWrapper) {
        this.dataWrapper = dataWrapper;
    }
}
