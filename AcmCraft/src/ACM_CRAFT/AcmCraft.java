package ACM_CRAFT;

import java.util.Arrays;
import java.util.Scanner;

public class AcmCraft {
    /**
     * How to Solve
     * 1. Create buildLevel [N]
     * 2. Insert value and search value's level
     * 3. Create level[maxLevel]
     * 4. Insert max value of each levels
     * 5. Add level 1 to level of w
     */

    private int buildLevel [], levelMax[], outPut[], buildCost[];
    Scanner scanner = new Scanner(System.in);

    public AcmCraft(){

        makeAcmCraft(inputTest());
    }
    private void makeAcmCraft(int _testCase){

        for (int i = 0; i < _testCase; i++)
            outPut[i] = makeCase();
        printOutPut();  // Print all outputs

    }
    private int inputTest(){
        int _t = Integer.parseInt(scanner.nextLine());
        outPut = new int[_t];
        return _t;
    }
    private int makeCase(){
        makeArrays();

        return findLeastTime();
    }
    private void makeArrays(){
        String[] _input = (scanner.nextLine()).split(" ");
        int _n = Integer.parseInt(_input[0]);
        int _k = Integer.parseInt(_input[1]);
        makeCost(_n);

        buildLevel = new int[_n];
        buildLevel[0] = 0;
        int _levelCount = 0;
        for (int i = 0; i < _k; i++)
            _levelCount = makeLevel(0);

        makeMaxValues(_levelCount +1);


    }
    private void makeCost(int bCount){
        buildCost = new int[bCount];

        String _cost = scanner.nextLine();
        buildCost = Arrays.stream(_cost.split(" ")).mapToInt(Integer::parseInt).toArray();  //String[] -> int[]
        for ( int cost : buildCost){
        }
    }
    private int makeLevel(int _levelCount){
        String[] _input = (scanner.nextLine()).split(" ");
        int start = Integer.parseInt(_input[0]) -1;
        int end = Integer.parseInt(_input[1]) -1;
        buildLevel[end] = buildLevel[start] + 1;

        return (buildLevel[end] > _levelCount) ? buildLevel[end] : _levelCount;
    }
    private void makeMaxValues(int _levelCount){

        levelMax = new int[_levelCount];

        for (int _index = 0; _index < buildLevel.length; _index++) {
            int _cost = buildCost[_index];
            levelMax[ buildLevel[_index] ] = (_cost > levelMax[ buildLevel[_index] ]) ? _cost : levelMax[ buildLevel[_index] ];
        }

    }
    private int findLeastTime(){
        int _dest = Integer.parseInt(scanner.nextLine());
        int _destLevel = buildLevel[_dest -1];
        int _leastTime =0;
        for (int _index = 0; _index <= _destLevel; _index++ )
            _leastTime += levelMax[_index];
        return _leastTime;
    }
    private void printOutPut(){
        for (int _outPut:outPut) {
            System.out.println(_outPut);
        }
    }

}
