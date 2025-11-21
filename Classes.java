public class Classes {
    public static void main(String[] args) {
        int num =5;
        String name ="Meow";
        double nums = 3.14;
        boolean hmm = true;
        System.out.println("hello world"+num);
        Car car1 = new Car(1981,"pink");
        Math math1 = new Math(8,9);
        math1.multiply();
        math1.add();
        car1.start();
        car1.model();        
    }
}
    class Car {
        int model ;
        String color ;

        Car(int model,String color){
            this.model = model;
            this.color = color;
        }
        void model(){
            System.out.println("The model of the vehicle is: "+model);
        }
    void start(){
        System.out.println("vroom vroom!!");
    }

    
}
     class Math {
        int a;
        int b;
        Math(int a,int b)
        {
            this.a = a;
            this.b =b;
        }
        void multiply()
        {
            System.out.println("The answer for "+a+"X"+b+"="+(a*b));
        }
         void add()
        {
            System.out.println("The answer for "+a+"+"+b+"="+(a+b));
        }
    
        
    }

    
