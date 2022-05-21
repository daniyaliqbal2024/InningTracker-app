package com.chadbyers.inningtracker;

public class InningTracker {
    private int numBalls = 0;
    private int numStrikes = 0;
    private int numOuts = 0;

    public InningTracker(){}
    public InningTracker(int numBalls, int numStrikes, int numOuts) {
        this.numBalls = numBalls;
        this.numStrikes = numStrikes;
        this.numOuts = numOuts;
    }

    public int getNumBalls() {
        return numBalls;
    }

    public int getNumStrikes() {
        return numStrikes;
    }

    public int getNumOuts() {
        return numOuts;
    }

    public void incrementNumBalls (){
        if(numBalls == 3){
            numBalls = 0;
            numStrikes = 0;
        }
        else{
            numBalls++;
        }
    }

    public void incrementNumStrikes(){
        if(numStrikes == 2){
            numBalls = 0;
            numStrikes = 0;
            numOuts++;
            if(numOuts == 3){
                numOuts = 0;
            }
        }
        else{
            numStrikes++;
        }
    }

    public void incrementNumOuts(){
        numBalls = 0;
        numStrikes = 0;
        if(numOuts == 2){
            numOuts = 0;
        }
        else{
            numOuts++;
        }
    }

    public void resetBallsAndStrikes(){
        numBalls = 0;
        numStrikes = 0;
    }


}

