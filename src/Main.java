import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    private static  Double Tuple(String[] tuple, double sunny, double overcast, double rain, double hot, double mild, double cool, double high, double normal, double strong, double weak, double x, double P){
        double tuple_p=0.0,tuple_n=0.0;
        for (String tuple1 : tuple) {
            if (tuple1.contains("Sunny")) {
                tuple_p = sunny/x;
            }
            if (tuple1.contains("Ovecast")) {
                tuple_p = overcast/x;
            }
            if (tuple1.contains("Rain")) {
                tuple_p = rain/x;
            }
            if (tuple1.contains("Hot")) {
                tuple_p = hot*tuple_p/x;
            }
            if (tuple1.contains("Mild")) {
                tuple_p = mild*tuple_p/x;
            }
            if (tuple1.contains("Cool")) {
                tuple_p = cool*tuple_p/x;
            }
            if (tuple1.contains("High")) {
                tuple_p = high*tuple_p/x;
            }
            if (tuple1.contains("Normal")) {
                tuple_p = normal*tuple_p/x;
            }
            if (tuple1.contains("Strong")) {
                tuple_p = strong*tuple_p/x;
            }
            if (tuple1.contains("Weak")) {
                tuple_p = weak*tuple_p/x;
            }
        }
        return tuple_p*P;
    }
    public static void main(String[] args) {

        int[] Day = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        String[] Outlook = new String[]{"Sunny", "Sunny", "Ovecast", "Rain", "Rain", "Rain", "Ovecast", "Sunny", "Sunny", "Rain", "Sunny", "Ovecast", "Ovecast", "Rain"};
        String[] Temperature = new String[]{"Hott", "Hott", "Hott", "Mild", "Cool", "Cool", "Cool", "Mild", "Cool", "Mild", "Mild", "Mild", "Hott", "Mild"};
        String[] Humidity = new String[]{"High", "High", "High", "High", "Normal", "Normal", "Normal", "High", "Normal", "Normal", "Normal", "High", "Normal", "High"};
        String[] Wind = new String[]{"Weak", "Strong", "Weak", "Weak", "Weak", "Strong", "Strong", "Weak", "Weak", "Weak", "Strong", "Strong", "Weak", "Strong"};
        String[] Play = new String[]{"No", "No", "Yes", "Yes", "Yes", "No", "Yes", "No", "Yes", "Yes", "Yes", "Yes", "Yes", "No"};
        String[] TrainingSet = new String[]{"Day\t", "Outlook\t", "Temperature", "Humidity", "Wind", "Play"};
        DecimalFormat df = new DecimalFormat("#.####");

        for (String TrainingSet1 : TrainingSet)
            System.out.print(TrainingSet1 + "\t");

        System.out.println();

        for(int i=0;i<Day.length;i++)
            System.out.println(Day[i] + "\t\t" + Outlook[i] + "\t\t" + Temperature[i] + "\t\t" + Humidity[i] + "\t\t" + Wind[i] + "\t" + Play[i]);

        double p = 0.0;
        double n = 0.0;
        for (String Play1 : Play) {
            if (Play1.contains("Yes")) {
                p++;
            }
            if (Play1.contains("No")) {
                n++;
            }
        }
        System.out.println("\nStep 1 : Probabilities of individual target classes");
        Double P = p/(p+n);
        Double N = n/(p+n);
        System.out.println("P(p) = "+df.format(P));
        System.out.println("P(n) = "+df.format(N));

        double sunny_p=0,sunny_n=0,overcast_p=0,overcast_n=0,rain_p=0,rain_n=0,hot_p=0,hot_n=0,mild_p=0,mild_n=0,cool_p=0,cool_n=0,high_p=0,high_n=0,normal_p=0,normal_n=0,strong_p=0,strong_n=0,weak_p=0,weak_n=0;
        for(int i=0;i<Day.length;i++){
            if(Outlook[i].contains("Sunny")){
                if(Play[i].contains("Yes")){
                    sunny_p++;
                }
                if(Play[i].contains("No")){
                    sunny_n++;
                }
            }
            if(Outlook[i].contains("Ovecast")){
                if(Play[i].contains("Yes")){
                    overcast_p++;
                }
                if(Play[i].contains("No")){
                    overcast_n++;
                }
            }
            if(Outlook[i].contains("Rain")){
                if(Play[i].contains("Yes")){
                    rain_p++;
                }
                if(Play[i].contains("No")){
                    rain_n++;
                }
            }
            if(Temperature[i].contains("Hot")){
                if(Play[i].contains("Yes")){
                    hot_p++;
                }
                if(Play[i].contains("No")){
                    hot_n++;
                }
            }
            if(Temperature[i].contains("Mild")){
                if(Play[i].contains("Yes")){
                    mild_p++;
                }
                if(Play[i].contains("No")){
                    mild_n++;
                }
            }
            if(Temperature[i].contains("Cool")){
                if(Play[i].contains("Yes")){
                    cool_p++;
                }
                if(Play[i].contains("No")){
                    cool_n++;
                }
            }
            if(Humidity[i].contains("High")){
                if(Play[i].contains("Yes")){
                    high_p++;
                }
                if(Play[i].contains("No")){
                    high_n++;
                }
            }
            if(Humidity[i].contains("Normal")){
                if(Play[i].contains("Yes")){
                    normal_p++;
                }
                if(Play[i].contains("No")){
                    normal_n++;
                }
            }
            if(Wind[i].contains("Strong")){
                if(Play[i].contains("Yes")){
                    strong_p++;
                }
                if(Play[i].contains("No")){
                    strong_n++;
                }
            }
            if(Wind[i].contains("Weak")){
                if(Play[i].contains("Yes")){
                    weak_p++;
                }
                if(Play[i].contains("No")){
                    weak_n++;
                }
            }
        }

        System.out.println("\nOutlook");
        System.out.print("P(sunny|p) = " +df.format(sunny_p/p));
        System.out.println("\t\tP(sunny|n) = " +df.format(sunny_n/n));
        System.out.print("P(overcast|p) = " +df.format(overcast_p/p));
        System.out.println("\tP(overcast|n) = " +df.format(overcast_n/n));
        System.out.print("P(rain|p) = " +df.format(rain_p/p));
        System.out.println("\t\tP(rain|n) = " +df.format(rain_n/n));

        System.out.println("\nTemperature");
        System.out.print("P(hot|p) = " +df.format(hot_p/p));
        System.out.println("\t\tP(hot|n) = " +df.format(hot_n/n));
        System.out.print("P(mild|p) = " +df.format(mild_p/p));
        System.out.println("\t\tP(mild|n) = " +df.format(mild_n/n));
        System.out.print("P(cool|p) = " +df.format(cool_p/p));
        System.out.println("\t\tP(cool|n) = " +df.format(cool_n/n));

        System.out.println("\nHumidity");
        System.out.print("P(high|p) = " +df.format(high_p/p));
        System.out.println("\t\tP(high|n) = " +df.format(high_n/n));
        System.out.print("P(normal|p) = " +df.format(normal_p/p));
        System.out.println("\tP(normal|n) = " +df.format(normal_n/n));

        System.out.println("\nWind");
        System.out.print("P(strong|p) = " +df.format(strong_p/p));
        System.out.println("\tP(strong|n) = " +df.format(strong_n/n));
        System.out.print("P(weak|p) = " +df.format(weak_p/p));
        System.out.println("\t\tP(weak|n) = " +df.format(weak_n/n));

        System.out.println("\nStep 2 : Consider the unseen tuple");
        String[] tuple = new String[4];
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Unseen Tuple");
        for(int i=0;i<4;i++){
            tuple[i] = sc.next();
        }
        //  String tuple[] = {"Ovecast","Cool","High","Strong"};
        Double tuple_P =Tuple(tuple,sunny_p,overcast_p,rain_p,hot_p,mild_p,cool_p,high_p,normal_p,strong_p,weak_p,p,P);
        Double tuple_N =Tuple(tuple,sunny_n,overcast_n,rain_n,hot_n,mild_n,cool_n,high_n,normal_n,strong_n,weak_n,n,N);

        System.out.println("\nP(X|p)*P(p)");
        for (String tuple1 : tuple) {
            System.out.print("P(" + tuple1 + "|p)*");
        }
        System.out.println("P(p)");
        System.out.println(df.format(tuple_P));

        System.out.println("\nP(X|n)*P(n)");
        for (String tuple1 : tuple) {
            System.out.print("P(" + tuple1 + "|n)*");
        }
        System.out.println("P(n)");
        System.out.println(df.format(tuple_N));

        if(tuple_P>tuple_N){
            System.out.println("\nSince the Probability of class 'p' is highest\nThe tuple fall under the class 'YES'");
        }else{
            System.out.println("\nSince the Probability of class 'n' is highest\nThe tuple fall under the class 'NO'");
        }
    }
}
