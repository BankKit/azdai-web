/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.valve;

import com.azdai.core.das.dal.dto.ForumUserDTO;
import com.github.obullxl.lang.FlagValve;

/**
 * Valve for ForumUserDTO.
 */
public class ForumUserValve extends FlagValve {

    /** The object class. */
	private final ForumUserDTO object;
	
	/**
	 * CTOR
	 */
	public ForumUserValve(ForumUserDTO object) {
	    this.object = object;
	}

	/**
	 * Getter for object.
	 */
    public ForumUserDTO getObject() {
        return this.object;
    }
	
	// Custome codes.
	
}
