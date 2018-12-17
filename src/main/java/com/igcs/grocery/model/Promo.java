package com.igcs.grocery.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Promo {

    private List<ProductQuantityPair> requirements;

    private List<ProductQuantityPair> gettables;

    public Promo() {
        this.requirements = new ArrayList<>();
        this.gettables = new ArrayList<>();
    }

    public List<ProductQuantityPair> getRequirements() {
        return requirements;
    }

    public void setRequirements( List<ProductQuantityPair> requirements ) {
        this.requirements = requirements;
    }

    public void addRequirement( ProductQuantityPair requirement ) {
        this.requirements.add( requirement );
    }

    public void addRequirements( ProductQuantityPair[] requirements ) {
        this.requirements.addAll( Arrays.asList( requirements ) );
    }

    public List<ProductQuantityPair> getGettables() {
        return gettables;
    }

    public void setGettables( List<ProductQuantityPair> gettables ) {
        this.gettables = gettables;
    }

    public void addGettable( ProductQuantityPair gettable ) {
        this.requirements.add( gettable );
    }

    public void addGettables( ProductQuantityPair[] gettables ) {
        this.requirements.addAll( Arrays.asList( gettables ) );
    }
}
