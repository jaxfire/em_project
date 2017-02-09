package com.jaxfire.james_ash_earthmiles;

public enum Locations {

    UK("Available throughout UK"), US("Available throughout US"), BRIGHTON("Brighton"), EDINBURGH("Edinburgh"),  GLASGOW("Glasgow"), LONDON("London");

    private final String text;

    Locations(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
