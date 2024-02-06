package md;

public class ConsoleAppMD {

    public static void main(String[] args) {

        String username="x@x.com";
        String name ="ionel condor";
        double w = 79.4;
        int h = 182;

        Patient p = new Patient(username, name, w, h);

       BloodTestKeto bloodTestKeto6Febr = new BloodTestKeto();

       bloodTestKeto6Febr.setHdl(30);
       bloodTestKeto6Febr.setTrigl(280);

       p.setBloodTestKeto(bloodTestKeto6Febr);

       double r = p.calcKetoTrigliHDL();
       String rr = p.evaluateKetoTrigliHDLRatio(r);
        System.out.println(rr);

       String resultKetoBloodTest = p.evaluateKetoTrigliHDLRatio();
        System.out.println(resultKetoBloodTest);



        //metoda1
        double d = p.calcBMI();
        String status = p.evaluateBMI(d);
        System.out.println(status);

        String x = p.evaluateBMI();
        System.out.println(x);




    }
}
