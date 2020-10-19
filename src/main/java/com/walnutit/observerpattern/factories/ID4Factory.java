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
package com.walnutit.observerpattern.factories;

import com.walnutit.observerpattern.ElectroCar;
import com.walnutit.observerpattern.FactoryZwickau;
import com.walnutit.observerpattern.testing.ID4Testing;

/**
 * @author Daniel Krentzlin
 *
 */
public class ID4Factory extends FactoryZwickau {

	ElectroCar electroCar;

	public static ID4Factory getID4Factory(ElectroCar electroCar) {
		return new ID4Factory(electroCar);
	}

	private ID4Factory(ElectroCar electroCar) {

		this.electroCar = electroCar;

	}

	@Override
	protected ElectroCar buildElectroCar() {

		ElectroCar untestedElectroCar = electroCar.addToProduction();

		ElectroCar testedElectroCar = updateTestDeparture(
				ID4Testing.TEST_DEPARTURE_KEY, untestedElectroCar);

		return testedElectroCar;
	}

}
