package org.example.dao;

import java.util.Random;

public class RandomDaoImp implements RandomDao{

    private Random random;

    public RandomDaoImp(Random random) {

        this.random = random;
    }
    @Override
    public int nextInt(int n) {
        return random.nextInt(n);
    }

}
