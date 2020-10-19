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

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.walnutit.observerpattern.domain.features.ElectroCarFeatures;
import com.walnutit.observerpattern.domain.features.general.BatteryCapacity;
import com.walnutit.observerpattern.domain.features.general.Color;
import com.walnutit.observerpattern.domain.features.general.Engine;
import com.walnutit.observerpattern.domain.features.general.ExtraEquipment;
import com.walnutit.observerpattern.domain.features.general.Rim;
import com.walnutit.observerpattern.domain.features.id3.ElectroCarFeaturesID3Version1;
import com.walnutit.observerpattern.domain.features.id3.ElectroCarFeaturesID3Version2;
import com.walnutit.observerpattern.domain.features.id4.ElectroCarFeaturesID4Version1;
import com.walnutit.observerpattern.factories.ID3Factory;
import com.walnutit.observerpattern.factories.ID4Factory;
import com.walnutit.observerpattern.products.ID3Version1;
import com.walnutit.observerpattern.products.ID3Version2;
import com.walnutit.observerpattern.products.ID4Version1;
import com.walnutit.observerpattern.testing.ID3Testing;
import com.walnutit.observerpattern.testing.ID4Testing;
import com.walnutit.observerpattern.utils.Timer;

/**
 * @author Daniel Krentzlin
 *
 */
@Controller
public class Client implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println("\n\n");
		System.out.println("\n\n");

		ElectroCarFeatures carFeatures = ElectroCarFeaturesID3Version1
				.getEctroCarFeaturesID3(Engine.engine1, Color.blue,
						BatteryCapacity.kWh77, Rim.model2,
						ExtraEquipment.package3);
		FactoryZwickau factoryZwickau = new ID3Factory(
				ID3Version1.getID3Version1(carFeatures));
		
		factoryZwickau.addTestDeparture(1, new ID3Testing());
		factoryZwickau.addTestDeparture(2, new ID4Testing());
		
		System.out.println("\n\n");
		System.out.println(
				"Building VW ID3 Version 1 with configuration id: "
						+ carFeatures.getConfigurationId());
		System.out.println("\n");
		ElectroCar electroCar = factoryZwickau.buildElectroCar();
		System.out
				.println("Electro Car with configuration ID"
						+ electroCar.getEcltraFeatures()
								.getConfigurationId()
						+ " is tested: "
						+ electroCar.getEcltraFeatures().isTested());

		Timer.sleep(5);
		System.out.println("\n\n");
		carFeatures = null;
		electroCar = null;
		factoryZwickau = null;
		

		carFeatures = ElectroCarFeaturesID3Version2
				.getElectroCarFEaturesID3Version2(Engine.engine1,
						Color.black, BatteryCapacity.kWh58,
						Rim.model3, ExtraEquipment.package1);
		factoryZwickau = new ID3Factory(
				ID3Version2.getID3Version2(carFeatures));
		
		factoryZwickau.addTestDeparture(1, new ID3Testing());
		factoryZwickau.addTestDeparture(2, new ID4Testing());
		System.out.println("\n\n");
		System.out.println(
				"Building VW ID3 Version 2 with configuration id: "
						+ carFeatures.getConfigurationId());
		System.out.println("\n");
		electroCar = factoryZwickau.buildElectroCar();
		System.out
				.println("Electro Car with configuration ID"
						+ electroCar.getEcltraFeatures()
								.getConfigurationId()
						+ " is tested: "
						+ electroCar.getEcltraFeatures().isTested());

		Timer.sleep(5);
		System.out.println("\n\n");
		carFeatures = null;
		electroCar = null;
		factoryZwickau = null;

		carFeatures = ElectroCarFeaturesID4Version1
				.getElectroCarFEaturesID4Version1(Engine.engine1,
						Color.silver, BatteryCapacity.kWh58,
						Rim.model1, ExtraEquipment.package2);
		factoryZwickau = ID4Factory.getID4Factory(
				ID4Version1.getID4Version1(carFeatures));
		
		factoryZwickau.addTestDeparture(1, new ID3Testing());
		factoryZwickau.addTestDeparture(2, new ID4Testing());
		System.out.println("\n\n");
		System.out.println(
				"Building VW ID4 Version 1 with configuration id: "
						+ carFeatures.getConfigurationId());
		System.out.println("\n");
		electroCar = factoryZwickau.buildElectroCar();
		System.out
				.println("Electro Car with configuration ID"
						+ electroCar.getEcltraFeatures()
								.getConfigurationId()
						+ " is tested: "
						+ electroCar.getEcltraFeatures().isTested());

		Timer.sleep(2);
		System.out.println("\n\n");

	}

}
