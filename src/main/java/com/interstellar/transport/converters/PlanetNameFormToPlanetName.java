package com.interstellar.transport.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.interstellar.transport.entity.Planet;
import com.interstellar.transport.form.PlanetNameForm;

/**
 * @author nandan_kelkar
 */

@Component
public class PlanetNameFormToPlanetName implements Converter<PlanetNameForm, Planet> {

    @Override
    public Planet convert(PlanetNameForm planetNameForm) {
        Planet planet = new Planet(planetNameForm.getPlanetNode(),
                planetNameForm.getPlanetName());
        return planet;
    }
}
