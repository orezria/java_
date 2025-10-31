class Person { }
class Student extends Person { }
class Researcher extends Person { }
class Professor extends Researcher { }

public class Ex53InstanceOfEx {
    static void print(Person p){
        if(p instanceof Person)// true
            System.out.print("Person ");
        if(p instanceof Student) // false, Student를 상속받지 않음
            System.out.print("Student ");
        if(p instanceof Researcher) // true
            System.out.print("Researcher ");
        if(p instanceof Professor) // true
            System.out.print("Professor ");
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.print("new Student() -> ");
        print(new Student());
        System.out.print("new Researcher() -> ");
        print(new Researcher());
        System.out.print("new Professor() -> ");
        print(new Professor());

    }
}