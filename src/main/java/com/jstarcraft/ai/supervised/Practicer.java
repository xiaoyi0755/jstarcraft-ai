package com.jstarcraft.ai.supervised;

import com.jstarcraft.ai.data.DataModule;

/**
 * 训练器
 * 
 * @author Birdy
 *
 */
public interface Practicer {

	/**
	 * 训练
	 * 
	 * @param module
	 */
	void practice(DataModule module);
	
}
