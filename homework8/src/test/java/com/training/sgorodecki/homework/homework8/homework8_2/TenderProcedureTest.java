package com.training.sgorodecki.homework.homework8.homework8_2;

import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TenderProcedureTest {
    private TenderProcedure tenderProcedure;
    private Map<Worker, Integer> brigadeTenderList;
    private List<Worker> brigadeKozlov;
    private List<Worker> brigadeRakov;
    private List<Worker> brigadeSvinov;
    private List<List<Worker>> listBrigades;

    @Before
    public void initiate()  {
        tenderProcedure = new TenderProcedure();
        brigadeTenderList = new HashMap<>();
        listBrigades = new ArrayList<>();

        brigadeKozlov = createKozlovBrigade();
        brigadeRakov = createRakovBrigade();
        brigadeSvinov = createSvinovBrigade();
        brigadeTenderList = createBrigadeTenderList();

        listBrigades.add(brigadeKozlov);
        listBrigades.add(brigadeRakov);
        listBrigades.add(brigadeSvinov);
    }
    private List<Worker> createKozlovBrigade(){
        brigadeKozlov = new ArrayList<>();
        brigadeKozlov.add(new Worker(Collections.singleton(Skill.MASON),100.0));
        brigadeKozlov.add(new Worker(Collections.singleton(Skill.BUILDER),200.0));
        brigadeKozlov.add(new Worker(Collections.singleton(Skill.PAINTER),50.0));
        brigadeKozlov.add(new Worker(Collections.singleton(Skill.BUILDER),150.0));
        brigadeKozlov.add(new Worker(Collections.singleton(Skill.MASON),120.0));
        return brigadeKozlov;
    }
    private List<Worker> createRakovBrigade(){
        brigadeRakov = new ArrayList<>();
        brigadeRakov.add(new Worker(Collections.singleton(Skill.MASON),100.0));
        brigadeRakov.add(new Worker(Collections.singleton(Skill.BUILDER),100.0));
        brigadeRakov.add(new Worker(Collections.singleton(Skill.PAINTER),300.0));
        brigadeRakov.add(new Worker(Collections.singleton(Skill.MASON),200.0));
        brigadeRakov.add(new Worker(Sets.newHashSet(Skill.BUILDER, Skill.PAINTER), 200.0));
        return brigadeRakov;
    }
    private List<Worker> createSvinovBrigade(){
        brigadeSvinov = new ArrayList<>();
        brigadeSvinov.add(new Worker(Collections.singleton(Skill.BUILDER), 10000.00));
        brigadeSvinov.add(new Worker(Collections.singleton(Skill.PAINTER), 10000.00));
        brigadeSvinov.add(new Worker(Collections.singleton(Skill.MASON), 10000.00));
        brigadeSvinov.add(new Worker(Collections.singleton(Skill.MASON), 10000.00));
        brigadeSvinov.add(new Worker(Collections.singleton(Skill.BUILDER), 10000.00));
        return brigadeSvinov;
    }
    private Map<Worker,Integer> createBrigadeTenderList(){
        brigadeTenderList = new HashMap<>();
        brigadeTenderList.put(new Worker(Collections.singleton(Skill.BUILDER)), 1);
        brigadeTenderList.put(new Worker(Collections.singleton(Skill.MASON)), 1);
        brigadeTenderList.put(new Worker(Collections.singleton(Skill.PAINTER)), 1);
        return brigadeTenderList;
    }
    @Test
    public void makeTenderTest() {
        List<Worker> expected = brigadeKozlov;
        List<Worker> actual = tenderProcedure.makeTender(listBrigades, brigadeTenderList);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void makeTenderTestWithMultiWorker() {
        brigadeTenderList.put(new Worker(Sets.newHashSet(Skill.BUILDER, Skill.PAINTER)),1);
        List<Worker> expected = brigadeRakov;
        List<Worker> actual = tenderProcedure.makeTender(listBrigades, brigadeTenderList);
        Assert.assertEquals(expected, actual);
    }
    @Test(expected = OutOfSuitableBrigadeException.class)
    public void makeClosedTenderTest() throws OutOfSuitableBrigadeException {
        brigadeTenderList.put(new Worker(Collections.singleton(Skill.MASON)),6);
        tenderProcedure.makeTender(listBrigades, brigadeTenderList);
    }
}