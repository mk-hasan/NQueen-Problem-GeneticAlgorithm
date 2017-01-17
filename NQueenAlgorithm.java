/**
 * Created by mkhasan on 17/01/2017.
 */
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NQueenAlgorithm{
    public int size= 16;
    int com=120;
    public int parent1[] = new int [size];
    public int parent2[] =new int  [size];
    public int parent3[] =new int  [size];
    public int parent4[] =new int  [size];

    int[] child1,child2,child3,child4 =new int[size];

    static int collisionNum = 0;

    public static int [] ColArr = new int[5];
    public static int [] Colfinal = new int[5];
    int inFitness;
    public static Random random = new Random();

    //make some unique initial population
    //in initial 4 empty array

    public void InitialPopulation(){
        Set<Integer> numberSet1 = new HashSet<Integer>();
        Set<Integer> numberSet2 = new HashSet<Integer>();
        Set<Integer> numberSet3 = new HashSet<Integer>();
        Set<Integer> numberSet4 = new HashSet<Integer>();

        int number1 = random.nextInt(size);
        int number2 = random.nextInt(size);
        int number3 = random.nextInt(size);
        int number4 = random.nextInt(size);
        for(int i=0;i<size;i++){
            while(numberSet1.contains(number1)){number1 = random.nextInt(size);}numberSet1.add(number1);parent1[i]= number1;

            while(numberSet2.contains(number2)){number2 = random.nextInt(size);}numberSet2.add(number2);parent2[i]= number2;

            while(numberSet3.contains(number3)){number3 = random.nextInt(size);}numberSet3.add(number3);parent3[i]= number3;

            while(numberSet4.contains(number4)){number4 = random.nextInt(size);}numberSet4.add(number4);parent4[i]= number4;
        }
        //System.out.println("population:"+parent1[2]+parent1[3]);
        //System.out.println("population:"+parent2);
        //System.out.println("population:"+parent3);
        //System.out.println("population:"+parent4);

        //calculate the fitness value for intial paretns

        CollisionNumber(parent1);
        ColArr[1] = com - collisionNum;
        CollisionNumber(parent2);
        ColArr[2] = com - collisionNum;
        CollisionNumber(parent3);
        ColArr[3] = com - collisionNum;
        CollisionNumber(parent4);
        ColArr[4] = com - collisionNum;

        int[]inFit = ColArr;
        Arrays.sort(inFit);
        inFitness = inFit[4];
        //System.out.println(inFitness);

        //print initial population with fotness value
        for(int m=0;m<size;m++){System.out.print(parent1[m]);} System.out.println("      fitness  :::"+ColArr[1]);
        for(int m=0;m<size;m++){System.out.print(parent2[m]);} System.out.println("      fitness  :::"+ColArr[2]);
        for(int m=0;m<size;m++){System.out.print(parent3[m]);} System.out.println("      fitness  :::"+ColArr[3]);
        for(int m=0;m<size;m++){System.out.print(parent4[m]);} System.out.println("      fitness  :::"+ColArr[4]);

	/*	for(int d=0;d<20;d++){
			Selection();
			CrossOver();
			Mutation();
			if(Fitness()==null){
				System.out.println("no solution");
			}else{
				if(Fitness()==child1){
					int[] k = Fitness();
					System.out.println("Fitness: "+Colfinal[1]);

					for(int m=0;m<size;m++){System.out.print(child1[m]);}


				}
				if(Fitness()==child2){
					System.out.println("Fitness: "+Colfinal[2]);
					for(int m=0;m<size;m++){System.out.print(child2[m]);}

				}
				if(Fitness()==child3){
					System.out.println("Fitness: "+Colfinal[3]);
					for(int m=0;m<size;m++){System.out.print(child3[m]);}

				}
				if(Fitness()==child4){
					System.out.println("Fitness: "+Colfinal[4]);
					for(int m=0;m<size;m++){System.out.print(child4[m]);}

				}

				//int i=
				//System.out.println("solution:"+Fitness());
				break;
			}
		}*/

    }
    public void Fitness(){
        CollisionNumber(child1);
        Colfinal[1]=com-collisionNum;
        CollisionNumber(child2);
        Colfinal[2]=com-collisionNum;
        CollisionNumber(child3);
        Colfinal[3]=com-collisionNum;
        CollisionNumber(child4);
        Colfinal[4]=com-collisionNum;

	/*System.out.println("Fitness:");
		System.out.println(Colfinal[1]);
		System.out.println(Colfinal[2]);
		System.out.println(Colfinal[3]);
		System.out.println(Colfinal[4]);*/

	/*	int[]inFit1 = Colfinal;
		Arrays.sort(inFit1);
		int inFitness1 = inFit1[4];
		if(inFitness1>=inFitness){
			if(inFitness1 == Colfinal[1]){
				return child1;
			}
			if(inFitness1 == Colfinal[2]){
				return child2;
			}
			if(inFitness1 == Colfinal[3]){
				return child3;
			}
			if(inFitness1 == Colfinal[4]){
				return child4;
			}
		}

	   return null;*/



    }

    private void CollisionNumber(int[] arr) {
        // TODO Auto-generated method stub
        //for(int m=0;m<size;m++){System.out.print(parent1[m]);}
        collisionNum = 0;

        int offset = 1;       // offset used to calculate the diagnal attack between queens

        // Calculate the total number of collisions
        for(int i=0; i<(size - 1); i++){
            offset = 1;

            for(int j=i+1; j<size; j++){
                if( (arr[j] == (arr[i] + offset)) || (arr[j] == (arr[i] - offset))){
                    collisionNum++;
                }
                offset++;
            }
        }
        for (int j = 1; j < (size-1); j++)
        {
            for (int k = j + 1; k < size; k++)
            {
                if (arr[j] == arr[k])
                {
                    collisionNum++;
                }}}
    }

    public void Selection(){
        int sarr[]= ColArr;
        Arrays.sort(sarr);
	/*	System.out.println(sarr[1]);
		System.out.println(sarr[2]);
		System.out.println(sarr[3]);
		System.out.println(sarr[4]);*/

        for(int b=0;b<3;b++){
            if(sarr[1]==ColArr[1]){
                child1=parent2;
                child2=parent3;
                child3=parent4;
                child4=parent3;
            }else
            if(sarr[1]==ColArr[2]){
                child1=parent1;
                child2=parent4;
                child3=parent1;
                child4=parent3;

            }else
            if(sarr[1]==ColArr[3]){
                child1=parent2;
                child2=parent4;
                child3=parent2;
                child4=parent1;
            }else
            if(sarr[1]==ColArr[4]){
                child1=parent2;
                child2=parent1;
                child3=parent2;
                child4=parent3;
            }

        }


	/*
	    for(int t=0;t<size;t++){System.out.print(child1[t]);}
		System.out.println(" ");
	    for(int t=0;t<size;t++){System.out.print(child2[t]);}
		System.out.println(" ");
		for(int t=0;t<size;t++){System.out.print(child3[t]);}
		System.out.println(" ");
		for(int t=0;t<size;t++){System.out.print(child4[t]);}
		System.out.println(" ");*/

    }

    public void CrossOver(){
        int temp[] =new int[size];
        for(int i=0;i<3;i++){
            temp[i] = child1[i];
            child1[i]=child2[(size-1)-i];
            child2[(size-1)-i]=temp[i];
        }
        for(int i=0;i<3;i++){
            temp[i] = child3[i];
            child3[i]=child4[(size-1)-i];
            child4[(size-1)-i]=temp[i];
        }
		/*
		System.out.println("After crossover");

		for(int e=0;e<child1.length;e++){System.out.print(child1[e]);}
		System.out.println("");
		for(int e=0;e<child2.length;e++){System.out.print(child2[e]);}
		System.out.println("");
		for(int e=0;e<child3.length;e++){System.out.print(child3[e]);}
		System.out.println("");
		for(int e=0;e<child4.length;e++){System.out.print(child4[e]);}*/
    }

    public void Mutation(){

        //System.out.println("After Mutation:");

        child1[random.nextInt(size)] = random.nextInt(size);
        child2[random.nextInt(size)] = random.nextInt(size);
        child3[random.nextInt(size)] = random.nextInt(size);
        child4[random.nextInt(size)] = random.nextInt(size);
	  /*  for(int e=0;e<child1.length;e++){System.out.print(child1[e]);}
		System.out.println("");
		for(int e=0;e<child2.length;e++){System.out.print(child2[e]);}
		System.out.println("");
		for(int e=0;e<child3.length;e++){System.out.print(child3[e]);}
		System.out.println("");
		for(int e=0;e<child4.length;e++){System.out.print(child4[e]);}*/


    }
    public void main1(){
        int k=0;
        while(k<10000000){
            Selection();
            CrossOver();
            Mutation();
            Fitness();

            boolean loop=false;

            int [] finalsol= new int[size];

            for(int a = 1;a<5;a++){
                int curr= Colfinal[a];
                if(curr>ColArr[1]&&curr>ColArr[2]&&curr>ColArr[3]&&curr>ColArr[4]){
                    //System.out.println("Result::");
                    if(a==1){finalsol=child1;}
                    if(a==2){finalsol=child2;}
                    if(a==3){finalsol=child3;}
                    if(a==4){finalsol=child4;}
                    loop=true;

                    System.out.print("Fitness::"+Colfinal[a]);
                    System.out.println();
                    System.out.println("Board:");
                    for(int sol=0;sol<size;sol++){
                        System.out.print(finalsol[sol]);



                    }
                    System.out.println("Board implement: ");
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            if (finalsol[i] == j) {
                                System.out.print("|Q ");
                            } else {
                                System.out.print("|_ ");
                            }

                        }
                        System.out.println(" ");
                    }


                }
            }

            if(loop==true){
                break;
            }else{
                System.out.println("no solution");
                k++;
            }

            //k++;
        }
    }





}















