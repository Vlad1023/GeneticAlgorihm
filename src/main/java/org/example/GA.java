package org.example;

public class GA {

    public static void LaunchAlgorithm(int popSize, int numberOfIterations){
        // TODO Auto-generated method stub

        //READ PROBLEM DATA  PROBLEM Instance


        Individual[] pop        = new Individual[popSize];
        Individual[] children   = new Individual[popSize];
        Individual best         = new Individual();

        //1. Generate START-POPULATION
        for(int i=0;i<pop.length;i++){
            pop[i] = new Individual();
            pop[i].initialize();
            pop[i].fitness();
        }
        bestIndividual(pop, best);


//        System.out.println("Initial population:");
//        for(int k=0;k<pop.length;k++){
//            pop[k].output();
//        }
        System.out.println();

        System.out.println("Initial best individe:");
        best.output();


        for(int iter=1; iter<=numberOfIterations; iter++){

            for(int i=0;i<children.length;i=i+2){

                int parentIndex1 = selection(pop);
                int parentIndex2 = selection(pop);

                children[i]      = new Individual();
                children[i+1]    = new Individual();

                Individual.crossover(pop[parentIndex1], pop[parentIndex2], children[i], children[i+1]);

                children[i].mutation();
                children[i+1].mutation();

                children[i].fitness();
                children[i+1].fitness();


            }





            //Replacement
            pop        = children;
            children   = new Individual[popSize];

            bestIndividual(pop, best);
//            for(int k=0;k<pop.length;k++){
//                pop[k].output();
//            }
//            System.out.println("Best individe on current step: ");
//            best.output();
            //System.out.println();

        }
        System.out.println("Output of the best individual:");
        best.output();
        System.out.println();
        System.out.println();
    }


    public static int selection(Individual[] list){
        int index = 0;

        //Tournement Selection for maximization!

        int index1 = (int)(Math.random()*list.length);
        int index2 = (int)(Math.random()*list.length);


        if(list[index1].fitness > list[index2].fitness){
            index = index1;
        }
        else{
            index = index2;
        }
        return index;
    }





    public static void bestIndividual(Individual[] liste, Individual best){
        for(int i=0;i<liste.length;i++){
            if(liste[i].fitness > best.fitness){
                best.reproduce(liste[i]);
            }
        }
    }

}
