package com.challenge.quasar.constans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SatellitesPosition {
	public static final List<Float> SATELLITE_KENOBI = Collections.unmodifiableList(
			new ArrayList<Float>() {{
				add((float) -500.0);
				add((float) -200.0);
			}});
	
	public static final List<Float> SATELLITE_SKYWALKER = Collections.unmodifiableList(
			new ArrayList<Float>() {{
				add((float) 100.0);
				add((float) -100.0);
			}});
	
	public static final List<Float> SATELLITE_SATO = Collections.unmodifiableList(
			new ArrayList<Float>() {{
				add((float) 500.0);
				add((float) 100.0);
			}});
	
	public static final List<List<Float>> SATELLITES_POSITION = Collections.unmodifiableList(
		    new ArrayList<List<Float>>() {{
		        add(SATELLITE_KENOBI);
		        add(SATELLITE_SKYWALKER);
		        add(SATELLITE_SATO);
		    }});
	
	public static final int SATELLITE_POSITION_DIMENSION = 2;
}
