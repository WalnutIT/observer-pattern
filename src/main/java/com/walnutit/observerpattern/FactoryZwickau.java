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
package com.walnutit.observerpattern;

import java.util.HashMap;

import com.walnutit.observerpattern.testing.TestDeparture;

/**
 * @author Daniel Krentzlin
 *
 */
public abstract class FactoryZwickau {

	HashMap<Integer, TestDeparture> testDepartures = new HashMap<>();

	protected ElectroCar electroCar;

	public FactoryZwickau(ElectroCar electroCar) {

		this.electroCar = electroCar;

	}

	public void addTestDeparture(int testDepartureKey,
			TestDeparture testDeparture) {
		testDepartures.put(testDepartureKey, testDeparture);
	}

	public void removeTestDeparture(int testDepartureKey) {
		testDepartures.remove(testDepartureKey);
	}

	public ElectroCar testElectroCar(int testDepartureKey,
			ElectroCar electroCar) {
		TestDeparture testDeparture = testDepartures
				.get(testDepartureKey);
		testDeparture.updateTestDeparture(electroCar);
		testDeparture.startTesting();
		return testDeparture.getTestedElectroCar();
	}

	protected abstract ElectroCar buildElectroCar();

}
