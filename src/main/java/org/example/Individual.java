package org.example;

public class Individual {
    int[] bits;    // SOLUTION (OR REPRESENTATION OF A SOLUTION)
    int   fitness; // SOLUTION-QUALITY
    double p_MUT;  //MUTATION-PROBABILITY of EACH BIT

    public Individual(int popSize){
        //bits    = new int[Daten.anzahlProjekte];
        bits    = new int[popSize];
        p_MUT   = 1./bits.length;
    }


    public void mutation(){
        for(int i=1;i<bits.length;i++){
            double p = Math.random();//[0;1)
            if(p < p_MUT){
                if(this.bits[i] == 0){
                   int bitToSwap = this.bits[i - 1];
                   this.bits[i - 1] = this.bits[i];
                   this.bits[i] = bitToSwap;
                }
            }
        }
    }


    public static void crossover(Individual papa, Individual mama, Individual son, Individual daughter){
        int crosspointLower = (int)(Math.random()*papa.bits.length);
        int crosspointUpper = (int)(Math.random()*papa.bits.length);
        if(crosspointLower > crosspointUpper){
            int temp = crosspointLower;
            crosspointLower = crosspointUpper;
            crosspointUpper = temp;
        }

        //first child
        for(int i=0;i<crosspointLower;i++){
            son.bits[i]   = papa.bits[i];
        }
        for(int i=crosspointLower;i<crosspointUpper;i++){
            son.bits[i]    = mama.bits[i];
        }
        for(int i=crosspointUpper;i<papa.bits.length;i++){
            son.bits[i]   = papa.bits[i];
        }

        //second child
        for(int i=0;i<crosspointLower;i++){
            daughter.bits[i]   = mama.bits[i];
        }
        for(int i=crosspointLower;i<crosspointUpper;i++){
            daughter.bits[i]    = papa.bits[i];
        }
        for(int i=crosspointUpper;i<papa.bits.length;i++){
            daughter.bits[i]   = mama.bits[i];
        }
    }

    public void output(){
        for(int i=0;i<bits.length;i++){
            System.out.print(bits[i]);
        }
        System.out.print(" " + fitness);
        System.out.println();
    }



    public void initialize(){
        for(int i=0;i<this.bits.length;i++){
            bits[i] = 0;
            if(Math.random()<0.5){
                bits[i] = 1;
            }
        }
    }

    public void fitness(){
        fitness = 0;
        for(int i=0;i<bits.length;i++){
            fitness += bits[i];
        }
    }

    public void reproduce(Individual template){
        for(int i=0;i<bits.length;i++){
            this.bits[i] = template.bits[i];
        }
        this.fitness = template.fitness;
        this.p_MUT   = template.p_MUT;
    }



}
