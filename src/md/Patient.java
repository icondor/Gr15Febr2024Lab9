package md;

import login.User;

public class Patient extends User {

    private double weight; // in kg
    private int height; // in cm

    private String name;

   private BloodTestKeto bloodTestKeto;


    public Patient(String username, String name, double w, int h) {
        super(username);
        this.height = h;
        this.weight = w;
        this.name = name;

    }

    public Patient(String username, String name) {
        super(username);
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calcBMI() {
        double bmi = (100 * 100 * weight) / (height * height);
        return bmi;
    }

    public static String evaluateBMI(double bmi) {
        String result;
        if (bmi < 18.5)
            result = "underweight";
        else if (bmi < 25)
            result = "healthy weight";
        else if (bmi < 30)
            result = "overweight";
        else
            result = "obese";
        return result;
    }

    public String evaluateBMI() {
        double bmi= calcBMI();
        String result = evaluateBMI( bmi);
        return result;
    }

    public BloodTestKeto getBloodTestKeto() {
        return bloodTestKeto;
    }

    public void setBloodTestKeto(BloodTestKeto bloodTestKeto) {
        this.bloodTestKeto = bloodTestKeto;
    }


    public double calcKetoTrigliHDL() {

        double c = bloodTestKeto.getHdl();
        double tri = bloodTestKeto.getTrigl();
        double ratio = tri/c;
        return ratio;
    }


    public String evaluateKetoTrigliHDLRatio()
    {
        double r= calcKetoTrigliHDL();
        String result = evaluateKetoTrigliHDLRatio(r);
        return result;
    }

    public String evaluateKetoTrigliHDLRatio(double r) {
        String result;
        if (r < 2)
            result = "excellent. bravoooo ";
        else if (r >=2 && r<=6)
            result = "good, keep improving";
        else
            result = "npot good. pls revisit what you eat and do";

        return result;
    }
}

