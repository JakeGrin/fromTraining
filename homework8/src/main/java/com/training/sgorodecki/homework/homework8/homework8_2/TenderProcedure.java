package com.training.sgorodecki.homework.homework8.homework8_2;

import java.util.*;

public class TenderProcedure {
    public List<Worker> makeTender(List<List<Worker>> brigades, Map<Worker, Integer> brigadeTenderList) {
        List<List<Worker>> suitableBrigades = findSuitableBrigades(brigades, brigadeTenderList);
        if (!suitableBrigades.isEmpty()) {
            return chooseSuitableBrigade(suitableBrigades);
        }  else {
            throw new OutOfSuitableBrigadeException("Tender will be finished");
        }
    }

    private List<List<Worker>> findSuitableBrigades(List<List<Worker>> brigades, Map<Worker, Integer> brigadeTenderList) {
        List<List<Worker>> suitableBrigades = new ArrayList<>();
        for (List<Worker> brigade : brigades) {
            if (isSuitableBrigades(brigade, brigadeTenderList)) {
                suitableBrigades.add(brigade);
            }
        }
        return suitableBrigades;
    }

    private boolean isSuitableBrigades(List<Worker> brigades, Map<Worker, Integer> brigadeTenderList) {
        for (Map.Entry<Worker, Integer> entry : brigadeTenderList.entrySet()) {
            int number = Collections.frequency(brigades, entry.getKey());
            if (number < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private Double calculateBrigadeCost(List<Worker> brigade) {
        Double brigadeCost = 0.0;
        for (Worker worker : brigade) {
            brigadeCost += worker.getRate();
        }
        return brigadeCost;
    }

    private List<Worker> chooseSuitableBrigade(List<List<Worker>> suitableBrigades) {
        TreeMap<Double, List<Worker>> mapOfBrigades = new TreeMap<>();
        for (List<Worker> brigade : suitableBrigades) {
            mapOfBrigades.put(calculateBrigadeCost(brigade), brigade);
        }
        return mapOfBrigades.firstEntry().getValue();
    }
}

