public class Grade_Calculator {
    public static void main(String[]arg){
        //task1: grade calculator
        int mark1 = 93;
        int mark2 = 44;
        int mark3 = 75;
        double average = (mark1 + mark2 + mark3)/3.0;
        String grade;
        if (average >= 90){
        grade = "A";}
        else if (average>=75){
            grade ="B";
        }
        else if (average>= 50){
            grade ="C";
        }
        else{
            grade = "Fail";
        }
        System.out.println("Marks:"+mark1+","+mark2+","+mark3);
        System.out.println("Average:"+String.format("%.2f",average));
        System.out.println("Grade:"+grade);
    }
}
