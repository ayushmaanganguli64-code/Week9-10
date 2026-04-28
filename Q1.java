import java.util.Scanner;

public class BMIProgram {

 
    static String[] calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0; 
        double bmi = weight / (heightM * heightM);

        String status;

        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

       
        return new String[] {
            String.valueOf(heightCm),
            String.valueOf(weight),
            String.format("%.2f", bmi),
            status
        };
    }

 
    static String[][] processBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {
            String[] personData = calculateBMI(data[i][0], data[i][1]);

            for (int j = 0; j < 4; j++) {
                result[i][j] = personData[j];
            }
        }

        return result;
    }

 
    static void display(String[][] result) {

        System.out.println("\n------------------------------------------------------");
        System.out.println("Person\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < result.length; i++) {
            System.out.println((i + 1) + "\t" +
                    result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t\t" +
                    result[i][3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2]; // [weight][height]

   
        for (int i = 0; i < 10; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));

            System.out.print("Weight (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Height (cm): ");
            data[i][1] = sc.nextDouble();
        }

        
        String[][] result = processBMI(data);

        display(result);
    }
}
