/* ******************************************************************************
 * Copyright (c) 2014 - 2015 Fabian Prasser.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Fabian Prasser - initial API and implementation
 ******************************************************************************/

package de.linearbits.jhc;

/**
 * This class implements a data provider based on char arrays
 * 
 * @author Fabian Prasser
 */
class ProviderCharArray implements JHCDataProvider{
    
    /** The orientation*/
    private final Orientation orientation;
    /** The array*/
    private final char[][] array;
    /** Scale*/
    private final JHCScale<?> xScale;
    /** Scale*/
    private final JHCScale<?> yScale;

    /**
     * Creates a new instance
     * @param array
     * @param orientation
     */
    protected ProviderCharArray(char[][] array, Orientation orientation){
        this(array, orientation, null, null);
    }
        
    /**
     * Creates a new instance
     * @param array
     * @param orientation
     * @param xScale
     * @param yScale
     */
    protected ProviderCharArray(char[][] array, Orientation orientation, JHCScale<?> xScale, JHCScale<?> yScale){
        
        if (array == null || array.length == 0 || array[0] == null || array[0].length ==0){
            throw new IllegalArgumentException("Array must not be empty");
        }
        
        int length = -1;
        for (char[] row : array) {
            if (row == null || row.length == 0){
                throw new IllegalArgumentException("Array must not be empty");    
            }
            if (length == -1) {
                length = row.length;
            } else if (length != row.length) {
                throw new IllegalArgumentException("All rows must have equal length");
            }
        }
        
        if (orientation == null) {
            throw new IllegalArgumentException("Orientation must not be null");
        }
        
        this.xScale = xScale;
        this.yScale = yScale;
        this.array = array;
        this.orientation = orientation;
    }

    /**
     * Returns the.
     * 
     * @param x the x
     * @param y the y
     * @return the double
     */
    public double get(int x, int y) {
        switch (orientation){
        case ROW:
            return array[y][x];
        case COLUMN:
            return array[x][y];
        }
        throw new IllegalStateException("Unknown array orientation");
    }

    /**
     * Gets the height.
     * 
     * @return the height
     */
    public int getHeight() {
        switch (orientation){
        case ROW:
            return array.length;
        case COLUMN:
            return array[0].length;
        }
        throw new IllegalStateException("Unknown array orientation");
    }

    /**
     * Gets the width.
     * 
     * @return the width
     */
    public int getWidth() {
        switch (orientation){
        case ROW:
            return array[0].length;
        case COLUMN:
            return array.length;
        }
        throw new IllegalStateException("Unknown array orientation");
    }

    /**
     * Gets the x labels.
     * 
     * @return the x scale
     */
    public JHCScale<?> getXScale() {
        return xScale;
    }

    /**
     * Gets the y labels.
     * 
     * @return the y scale
     */
    public JHCScale<?> getYScale() {
        return yScale;
    }

    @Override
    public Orientation getOrientation() {
        return orientation;
    }
}
