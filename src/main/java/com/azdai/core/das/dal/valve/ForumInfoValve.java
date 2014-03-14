/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.valve;

import com.azdai.core.das.dal.dto.ForumInfoDTO;
import com.github.obullxl.lang.FlagValve;

/**
 * Valve for ForumInfoDTO.
 */
public class ForumInfoValve extends FlagValve {

    /** The object class. */
	private final ForumInfoDTO object;
	
	/**
	 * CTOR
	 */
	public ForumInfoValve(ForumInfoDTO object) {
	    this.object = object;
	}

	/**
	 * Getter for object.
	 */
    public ForumInfoDTO getObject() {
        return this.object;
    }
	
	// Custome codes.
	
}
