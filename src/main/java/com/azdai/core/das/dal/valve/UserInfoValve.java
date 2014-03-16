/**
 * obullxl@gmail.com
 */
package com.azdai.core.das.dal.valve;

import com.azdai.core.das.dal.dto.UserInfoDTO;
import com.github.obullxl.lang.FlagValve;

/**
 * Valve for UserInfoDTO.
 */
public class UserInfoValve extends FlagValve {

    /** The object class. */
	private final UserInfoDTO object;
	
	/**
	 * CTOR
	 */
	public UserInfoValve(UserInfoDTO object) {
	    this.object = object;
	}

	/**
	 * Getter for object.
	 */
    public UserInfoDTO getObject() {
        return this.object;
    }
	
	// Custome codes.
	
}
