package com.challenge.quasar.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import static com.challenge.quasar.constans.SatellitesPosition.*;

@Service
public class ResolveCommunicationServiceImpl implements ResolveCommunicationService{

	@Override
	public List<String> getMessage(List<List<String>> messages) {
		List<String> fullMessage = Arrays.asList(new String[messages.get(0).size()]);
		for (List<String> msg : messages) {
			IntStream.range(0, msg.size())
			.filter(i -> !msg.get(i).isEmpty())
			.mapToObj(i -> fullMessage.set(i, msg.get(i)))
			.collect(Collectors.toList());
		}
		
		return fullMessage;
	}

	@Override
	public double[] getLocation(double[] distances) {
		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(getSatellitesPositionConverted(), distances);
        NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction, new LevenbergMarquardtOptimizer());
        double[] point = nSolver.solve().getPoint().toArray();
        return point;
	}
	
	private double[][] getSatellitesPositionConverted() {
		double positions[][] = new double[SATELLITES_POSITION.size()][];
		for(int i = 0; i < SATELLITES_POSITION.size(); i++) {
			positions[i] = new double[SATELLITE_POSITION_DIMENSION]; 
			for(int j = 0; j < SATELLITE_POSITION_DIMENSION; j ++) {
				positions[i][j] = SATELLITES_POSITION.get(i).get(j);
			}
		}
		return positions;
	}
}
