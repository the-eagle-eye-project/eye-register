package com.theeagleeyeproject.eyeregister.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * {@link AlertLevel} describes the types of alerts the Eagle Eye platform handles.
 *
 * @author John Robert Martinez Ponce
 */
@Getter
@AllArgsConstructor
public enum AlertLevel {

    LEVEL1("High alert!"),
    LEVEL2("Medium alert."),
    LEVEL3("Low/Passive alert");

    private final String description;
}
