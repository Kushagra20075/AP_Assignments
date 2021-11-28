public class Calculator<T> {
    Calculator(){}
    int divide(T op1 , T op2){
        if(op1.getClass()!=op2.getClass()){
            //Throws Exception
        }
        if(op1.getClass() == Integer.class){
            // Check for divide by Zero;
            int a = (int) op1;
            int b = (int) op2;
            int res = a/b;
            return res;
        }
        return 0;
    }
    String concat(T op1 , T op2){
        if(op1.getClass()!=op2.getClass()){
            // Throws Exception
        }
        if(op1.getClass() == String.class){
            // Check for divide by Zero;
            String a = (String) op1;
            String b = (String) op2;
            String res = a.concat(b);
            return res;
        }
        return "";
    }
}
