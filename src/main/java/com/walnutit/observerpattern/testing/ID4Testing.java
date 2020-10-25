/**
 * Copyright 2020 - 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walnutit.observerpattern.testing;

import com.walnutit.observerpattern.ElectroCar;
import com.walnutit.observerpattern.utils.Timer;

/**
 * @author Daniel Krentzlin
 *
 */
public class ID4Testing implements TestDeparture {

	public final static int TEST_DEPARTURE_KEY = 1;

	@Override
	public ElectroCar update(ElectroCar electroCar) {
		System.out.println(
				"TestingDeparture received electro car with configuration id: "
						+ electroCar.getElectroCarFeatures()
								.getConfigurationId());
		Timer.sleep(2);
		System.out.println("... starting testing");
		Timer.sleep(7);
		System.out.println("... testing was successful");
		electroCar.getElectroCarFeatures().setTested(true);
		return electroCar;

	}

}
