package fraction;

import java.util.ArrayList;
import java.util.Collections;

/**
 * create a Fraction class to represent fractions and 
 * to do fraction arithmetic.
 * @author Owner
 *
 */
public class Fraction {

	/**
	 * Fraction numerator
	 */
    int numerator;

    /**
     * Fraction denominator
     */
    int denominator;
    
    //constructor
    /**
     * Creates a Fraction with given numerator and denominator.
     * Properly format negative fraction.
     * @param numerator
     * @param denominator
     */
    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;

        //properly format negative fraction values
        formatNegativeFraction();

    }
    
    //methods
    
    /**
     * Correctly format the fraction if it has negative value in the denominator
     * if both numerator and denominator are negative and set them both to positive
     * 
     * For example, 2/-3 should be set to -2/3
     * -2/-3 should be set to 2/3
     */
    public void formatNegativeFraction(){
    	//fraction with negative denominator
        if(this.denominator < 0){       	
        	
        	//change numerator to its opposite value
            this.numerator = -numerator;
            
            //always keep denominator as positive
            this.denominator = -denominator;
        }
    }
    
    /**Reduce the current fraction by eliminating common factors.
     * That is, turn a fraction like 4/16 into 1/4 and a fraction like 320/240 into 4/3. 
     */

    public void reduceToLowestForm(){
        if(this.numerator == 0){
            this.numerator = 0;
            this.denominator = 1;
        }else if(this.numerator % this.denominator == 0){
            this.numerator = this.numerator / this.denominator;
            this.denominator = 1;
        }else{
            ArrayList<Integer> divisorsNum = this.findDivisors(this.numerator);
            ArrayList<Integer> divisorsDen = this.findDivisors(this.denominator);

            int greatestCommon = 0;
            
            Collections.sort(divisorsNum, (a,b) -> (b-a));
            Collections.sort(divisorsDen, (a,b) -> (b-a));

            for(Integer divNum : divisorsNum){
                if(divisorsDen.contains(divNum)){
                    greatestCommon = divNum;
                    break;
                }
            }                    
            this.numerator = this.numerator / greatestCommon;
            this.denominator = this.denominator / greatestCommon;
        }
    }

    public static ArrayList<Integer> findDivisors(int num){
        ArrayList<Integer> divisors = new ArrayList<>();

        if(num < 0) num = -num;

        for(int i = num; i >= 1; i--){
            if(num % i == 0) divisors.add(i);
        }

        return divisors;
    }

    public Fraction add(Fraction otherFraction){
        int n = this.numerator * otherFraction.denominator + otherFraction.numerator * this.denominator;
        int d = this.denominator * otherFraction.denominator;

        Fraction newFraction = new Fraction(n, d);
        newFraction.reduceToLowestForm();
        return newFraction;
    }

    public Fraction subtract(Fraction otherFraction){
        int n = this.numerator * otherFraction.denominator - otherFraction.numerator * this.denominator;
        int d = this.denominator * otherFraction.denominator;

        Fraction newFraction = new Fraction(n, d);
        newFraction.reduceToLowestForm();
        return newFraction;
    }

    public Fraction mul(Fraction otherFraction){
        int n = this.numerator * otherFraction.numerator;
        int d = this.denominator * otherFraction.denominator;

        Fraction newFraction = new Fraction(n, d);
        newFraction.reduceToLowestForm();
        return newFraction;

    }

    public Fraction div(Fraction otherFraction){
        int n = this.numerator * otherFraction.denominator;
        int d = this.denominator * otherFraction.numerator;

        Fraction newFraction = new Fraction(n, d);
        newFraction.reduceToLowestForm();
        return newFraction;
    }

    public double decimal(){
        return this.numerator / (double)this.denominator;
    }

    public void sqr(){
        this.numerator *= this.numerator;
        this.denominator *= this.denominator;
        reduceToLowestForm();
    }

    
    public Fraction average(Fraction otherFraction){
        Fraction sum = this.add(otherFraction);
        Fraction div = new Fraction(1,2);
        Fraction newFraction = sum.mul(div);
        newFraction.reduceToLowestForm();

        return newFraction;
    }

    public static Fraction average(Fraction[] fractions){
        if(fractions == null || fractions.length == 0){
            return new Fraction(0, 1);
        }

        int len = fractions.length;

        Fraction sum = fractions[0];
        for(int i = 1; i < fractions.length; i++){
            sum = sum.add(fractions[i]);
        }

        Fraction aver = sum.div(new Fraction(len, 1));
        aver.reduceToLowestForm();
        return aver;
    }

    public static Fraction average(int[] ints){
        if(ints == null || ints.length == 0){
            return new Fraction(0, 1);
        }

        int sum = 0;
        int len = ints.length;
        for(int i: ints){
            sum += i;
        }

        Fraction fracSum = new Fraction(sum,1);
        Fraction aver = fracSum.div(new Fraction(len,1));
        aver.reduceToLowestForm();
        return aver;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Fraction)) return false;

        Fraction ob = (Fraction) object;

        Fraction tmp = new Fraction(this.numerator, this.denominator);
        tmp.reduceToLowestForm();

        Fraction obTmp = new Fraction(ob.numerator, ob.denominator);
        obTmp.reduceToLowestForm();

        if(tmp.numerator == obTmp.numerator && tmp.denominator == obTmp.denominator) return true;

        return false;

    }

    /**
     * 
     */
    @Override
    public String toString(){
        String output = "";

        output += this.numerator + "/" + this.denominator;
        return output;
    }

    public static void main(String[] args) {
        //System.out.println("Finish homework tonight");

        Fraction f = new Fraction(40,-500);
        f.reduceToLowestForm();

        System.out.println(f);
        // System.out.println(f.numerator);
        // System.out.println(f.denominator);
        // Fraction[] fArray = new Fraction[]{new Fraction(3,4), new Fraction(3, 5), new Fraction(3,6)};
        // Fraction added = Fraction.average(fArray);

        // int[] intArray = new int[]{1,2,3,4};
        // Fraction added = Fraction.average(intArray);



        // Fraction another = new Fraction(5,8);
        // Fraction added = f.average(another);

        // System.out.println(added.numerator);
        // System.out.println(added.denominator);


    }

}

