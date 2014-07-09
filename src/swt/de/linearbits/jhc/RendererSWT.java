/*
 * JHC - Java Heatmap Control
 * Copyright (C) 2014 Fabian Prasser
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.linearbits.jhc;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


/**
 * This class implements a renderer for SWT
 * 
 * @author Fabian Prasser
 */
class RendererSWT extends Renderer<Image> {

    /** The display. */
    private final Display display;

    /**
     * Creates a new instance
     * 
     * @param jhc the jhc
     * @param canvas the canvas
     */
    protected RendererSWT(_JHC jhc, Canvas<Image, Font, Color> canvas) {
        super(jhc, canvas);
        this.display = jhc.getDisplay();
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.linearbits.jhc.Renderer#getPixels(de.linearbits.jhc.Heat, de.linearbits.jhc.Configuration)
     */
    @Override
    protected Pixels<Image> getPixels(JHCHeatmap heat, JHCConfiguration config) {
        int initialColor = config.getGradient().getColor(0);
        return new PixelsSWT(new Dimension(heat.getWidth(), heat.getHeight()), display, initialColor);
    }
}
