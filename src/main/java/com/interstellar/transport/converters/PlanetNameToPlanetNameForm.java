package com.interstellar.transport.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.interstellar.transport.entity.Planet;
import com.interstellar.transport.form.PlanetNameForm;

/**
 * @author nandan_kelkar
 */

@Component
public class PlanetNameToPlanetNameForm implements Converter<Planet, PlanetNameForm> {

    @Override
    public PlanetNameForm convert(Planet planets) {
        PlanetNameForm planetNameForm = new PlanetNameForm();
        planetNameForm.setPlanetNode(planets.getPlanetName());
        planetNameForm.setPlanetName(planets.getPlanetName());
        return planetNameForm;
    }
}
