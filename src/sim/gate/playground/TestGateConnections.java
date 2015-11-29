package sim.gate.playground;

import sim.gate.cell.gate.Gate;
import sim.gate.cell.gate.type.And;
import sim.gate.cell.gate.type.NotA;
import sim.gate.cell.gate.type.Or;

public class TestGateConnections implements ITest {

    @Override
    public void execute() {
        //scenario1();
        //scenario2();
        scenario3();
    }

    private void scenario3() {
        Gate[] not = new NotA[6];

        System.out.println("initialize");
        for (int i = 0; i < not.length; i++) {
            not[i] = new NotA();
            System.out.println(not[i]);
        }

        Gate and1 = new And();
        System.out.println(and1);


        for (int i = 0; i < 4; i++) {
//            and1.setInputA(not[2].getOutput());
//            and1.setInputB(not[5].getOutput());
//            not[2].setInputA(not[1].getOutput());
//            not[1].setInputA(not[0].getOutput());
//            not[0].setInputA(not[2].getOutput());
//            not[5].setInputA(not[4].getOutput());
//            not[4].setInputA(not[3].getOutput());
//            not[3].setInputA(not[0].getOutput());
            not[0].setInputA(not[2].getOutput());
            not[1].setInputA(not[0].getOutput());
            not[3].setInputA(not[0].getOutput());
            not[4].setInputA(not[3].getOutput());
            not[5].setInputA(not[4].getOutput());
            not[2].setInputA(not[1].getOutput());
            and1.setInputA(not[2].getOutput());
            and1.setInputB(not[5].getOutput());


            System.out.println("------ " + i + " ------");
            for (int j = 0; j < not.length; j++) {
                System.out.print("[" + j + "]");
                System.out.println(not[j]);
            }
            System.out.println(and1);
        }

    }

    private void scenario2() {
        Gate not1 = new NotA();
        Gate not2 = new NotA();
        Gate not3 = new NotA();

        System.out.println("Before");
        System.out.println(not1);
        System.out.println(not2);
        System.out.println(not3);

        for (int i = 0; i < 6; i++) {
            not1.setInputA(not3.getOutput());
            not2.setInputA(not1.getOutput());
            not3.setInputA(not2.getOutput());

            System.out.println("--- " + i + " ---");
            System.out.println(not1);
            System.out.println(not2);
            System.out.println(not3);
        }

    }

    private void scenario1() {
        Gate and = new And();
        Gate or = new Or();
        Gate notA = new NotA();

        and.setInputA(true);
        and.setInputB(false);
        notA.setInputA(false);
        notA.setInputB(false);

        or.setInputA(and.getOutput());
        or.setInputB(notA.getOutput());

        System.out.println(and);
        System.out.println(notA);
        System.out.println(or);
    }

}
