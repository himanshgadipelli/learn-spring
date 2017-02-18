package com.apress;

import java.beans.PropertyEditorSupport;

/**
 * Created by bobby on 2/17/2017.
 */
public class NamePropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String[] name = text.split("\\s");

        setValue(new Name(name[0], name[1]));
    }
}
