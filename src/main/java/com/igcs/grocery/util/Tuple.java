package com.igcs.grocery.util;

import java.util.AbstractMap;
import java.util.Map;

//Created this class for readability
public class Tuple<X, Y> extends AbstractMap.SimpleEntry {
    public Tuple( X key, Y value ) {
        super( key, value );
    }

    public Tuple( Map.Entry entry ) {
        super( entry );
    }
}
