//If any class has any of its method abstract then you must declare entire class abstract
abstract class Animal{
    //abstract method eat which makes animal class abstract
    abstract void eat();
}
 
//private class display{}    //This line is false as abstract classes can never be private

//abstract final class ImAnAbstractClass{}    //This line is false as abstract classes can never be final
  
 //Abstract class without abstract methods
 abstract class abst {

   public void display() {
      System.out.println("This is a method of abstract class");
   }
}
 
 
 //this class extends animal class so has to be abstract else all its method should be overriden                                         	
abstract class Assignment2Q4 extends Animal  {
    @Override
    public void eat(){
         System.out.println("eat overriden");
    }
    
    
    //beacause of below abstract method we have to declare Assignment2Q4 as abstract 
    abstract void hello();
	
	
	public static void main(String[] args) {
		//Line below will prove that an abstract class animal cannot be instantiated
		//Animal an=new Animal();
	}


}