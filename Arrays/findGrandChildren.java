import java.util.*;
public class findGrandChildren {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] family = {{"luke","shaw"},
                            {"wayne","rooney"},
                            {"rooney","ronaldo"},
                            {"shaw","rooney"},
                            {"mary","ronaldo"},
                            {"son","mary"}};
        System.out.println("Enter your target name:");
        String target = input.next();
        int count = 0;
        for(int i =0;i<family.length;i++){
            if(family[i][1].equals(target)){
                 count += grandchildren(family[i][0],family);
            }
        }
        System.out.println(target+" has "+count+" Grandchildren");

    }
    public static int grandchildren(String target,String[][] family){
        int count =0;
        for(int i =0;i<family.length;i++){
            if(family[i][1].equals(target)){
                count++;
            }
        }
        return count;
    }
}
