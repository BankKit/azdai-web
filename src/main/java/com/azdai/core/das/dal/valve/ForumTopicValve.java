/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.valve;

import com.azdai.core.das.dal.dto.ForumTopicDTO;
import com.github.obullxl.lang.FlagValve;

/**
 * Valve for ForumTopicDTO.
 */
public class ForumTopicValve extends FlagValve {

    /** The object class. */
	private final ForumTopicDTO object;
	
	/**
	 * CTOR
	 */
	public ForumTopicValve(ForumTopicDTO object) {
	    this.object = object;
	}

	/**
	 * Getter for object.
	 */
    public ForumTopicDTO getObject() {
        return this.object;
    }
	
	// Custome codes.
	
}
