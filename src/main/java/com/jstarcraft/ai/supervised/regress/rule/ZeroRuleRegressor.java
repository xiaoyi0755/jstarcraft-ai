package com.jstarcraft.ai.supervised.regress.rule;

import com.jstarcraft.ai.data.DataInstance;
import com.jstarcraft.ai.data.DataModule;
import com.jstarcraft.ai.supervised.Practicer;
import com.jstarcraft.ai.supervised.Predictor;

/**
 * 零规则回归器
 * 
 * @author Birdy
 *
 */
public class ZeroRuleRegressor implements Practicer, Predictor {

	private float quantity;

	@Override
	public void practice(DataModule module) {
		float markSum = 0F;
		float weightSum = 0F;
		for (DataInstance instance : module) {
			markSum += instance.getQuantityMark() * instance.getWeight();
			weightSum += instance.getWeight();
		}
		quantity = markSum / weightSum;
	}

	@Override
	public void predict(DataInstance instance) {
		instance.setQuantityMark(quantity);
	}

}
