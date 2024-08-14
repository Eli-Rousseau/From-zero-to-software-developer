package com.codewithmosh.flyweight;

import java.util.Hashtable;
import java.util.Map;

public class CellFactory {

    private Map<String, CellType> typesOfCells = new Hashtable<>();

    public CellType getCellType(String fontFamily, int fontSize, boolean isBold) {
        String cellHashValue = fontFamily + fontSize + isBold;
        if (!typesOfCells.containsValue(cellHashValue)) {
            typesOfCells.put(cellHashValue, new CellType(fontFamily, fontSize, isBold));
        }
        return typesOfCells.get(cellHashValue);
    }
}
