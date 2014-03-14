/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.valve;

import com.azdai.core.das.dal.dto.ImageDTO;
import com.github.obullxl.lang.FlagValve;

/**
 * Valve for ImageDTO.
 */
public class ImageValve extends FlagValve {

    /** The object class. */
	private final ImageDTO object;
	
	/**
	 * CTOR
	 */
	public ImageValve(ImageDTO object) {
	    this.object = object;
	}

	/**
	 * Getter for object.
	 */
    public ImageDTO getObject() {
        return this.object;
    }
	
	// Custome codes.
	
}
