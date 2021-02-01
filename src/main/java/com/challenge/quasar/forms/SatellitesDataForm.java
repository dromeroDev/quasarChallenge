package com.challenge.quasar.forms;

import static com.challenge.quasar.constans.SatellitesPosition.SATELLITES_POSITION;

import java.util.ArrayList;
import java.util.List;

import com.challenge.quasar.entities.Position;
import com.challenge.quasar.entities.Satellite;
import com.challenge.quasar.validators.MaxSizeConstraint;

public class SatellitesDataForm {
	@MaxSizeConstraint
	private List<Satellite> satellites;

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

	public List<Float> getDistances(){
		List<Float> distances = new ArrayList();
        this.satellites.stream().forEach(s -> {
        	distances.add(s.getDistance());
        });
        return distances;
    }

    public List<Position> getPositions(){
        List<Position> positions = new ArrayList();
        this.satellites.stream().forEach(s -> {
        	positions.add(s.getPosition());
        });
        return positions;
    }

    public List<List<String>> getMessages(){
        List<List<String>> messages = new ArrayList<List<String>>();
        this.satellites.stream().forEach(s -> {
        	messages.add(s.getMessage());
        });
        return  messages;
    }
    
    public double[] getDistancesConverted() {
    	List<Float> distances = this.getDistances();
		double distancesConverted[] = new double[SATELLITES_POSITION.size()];
		for(int i = 0; i < SATELLITES_POSITION.size(); i++) {
			distancesConverted[i] = distances.get(i);
		}
		return distancesConverted;
	}
}

