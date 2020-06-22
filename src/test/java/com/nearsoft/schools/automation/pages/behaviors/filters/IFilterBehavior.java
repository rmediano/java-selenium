package com.nearsoft.schools.automation.pages.behaviors.filters;

public interface IFilterBehavior {
    void selectFilter(String filterTitle, String filterOption);
    boolean isFilterSelected(String filterTitle, String filterOption);
}
