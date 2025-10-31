# 박시현(202530110)



# (10월 31일 강의)
<font color = "orange">
## 인터페이스의 구성 요소들의 특징
* **상수** : 

  -public만 허용, 

  -public static final 생략


* **추상 메소드** : 

  -public abstract 생략 가능


* **default 메소드** : 

  -인터페이스에 코드가 작성된 메소드

  -인터페이스를 구현하는 클래스에 자동 상속

  -public 접근 지점만 허용. 생략 가능


* private 메소드 : 

  -인터페이스 내에 메소드 코드가 작성되어야 함

  -인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능


* static 메소드 : public, private 모두 지정 가능. 생략하면 public

## 자바 인터페이스 특징
<font color = "orange"></font>
* 인터페이스의 객체 생성 불가
* 인터페이스 타입의 `레퍼런스 변수 선언 가능`

## 인터페이스 상속
* 인터페이스 간에 상속 가능 :

  -인터페이스를 상속하여 확장된 인터페이스 작성 가능

  -extends 키워드로 상속 선언

* 인터페이스 다중 상속 허용 (* 일반 상속에서는 허용하지 않음)

## 인터페이스 구현
* 인터페이스의 추상 메소드를 모두 구현한 클래스 작성
  * implements 키워드 사용
  * 여러 개의 인터페이스 동시 구현 가능
* 인터페이스 구현 사례
  * PhoneInterface 인터페이스를 구현한 SamsungPhone 클래스



## 추상 클래스
* 추상 메소드(abstract method)

  :abstract로 선언된 메소드, `메소드의 코드는 없고 원형만 선언`
```java
abstract public String getName();
abstract public String fail() { return "Good Bye".} // 추상 메소드 아님. 컴파일 오류
```

* 추상 클래스(abstract class)

  -추상 메소드를 가지며, abstract로 선언된 클래스

  -추상 메소드 없이, abstract로 선언한 클래스

```java
// 추상 메소드를 가진 추상 클래스
abstract class Shape {
    public Shape() {...}
    public void edit() {...}
    
    abstract public void draw(); // 추상 메소드
}
```
```java
// 추상 메소드 없는 추상 클래스
abstract class JComponent {
    String name;
    public void load(String name) {
        this.name = name;
    }
}
```

## 추상 클래스의 인스턴스 생성 불가
* 추상 클래스는 온전한 클래스가 아니기 때문에 `인스턴스를 생성할 수 없음`

```java
JComponent p; // 오류 없음. 추상 클래스의 레퍼런스 선언
p = new JComponent(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
Shape obj = new Shape(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
```

## 추상 클래스의 상속과 구현
* 추상 클래스 상속
    * 추상 클래스를 상속받으면 추상 클래스가 됨
    * 서브 클래스도 abstract로 선언해야 함
```java
abstract class A { // 추상 클래스
    abstract public int add(int x, int y); // 추상 메소드
}
abstract class B extends A { // 추상 클래스
    public void show() { System.out.println("B");}
}
```
```java
A a = new A(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
B b = new B(); // 컴파일 오류. 추상 클래스의 인스턴스 생성 불가
```
* 추상 클래스 구현
    * 서브 클래스에서 슈퍼 클래스의 추상 메소드 구현 (오버라이딩)
    * 추상 클래스를 구현한 서브 클래스는 추상 클래스 아님
```java
class C extends A { // 추상 클래스 구현. C는 정상 클래스
    public int add(int x, int y) { return x+y } // 추상 메소드 구현. 오버라이딩
    public void show() { System.out.println("C"); }
}
...
C c = new C(); // 정상
```

## 추상 클래스의 목적
* 추상 클래스의 목적

  -상속을 위한 슈퍼 클래스로 활용하는 것

  -서브 클래스에서 추상 메소드 구현

  -다형성 실현

##


## super 키워드로 슈퍼 클래스에 접근
- 슈퍼 클래스의 멤버에 접근시 사용하는 레퍼런스
- super.슈퍼클래스의 맴버
- 서브 클래스에서만 사용
- 슈퍼 클래스의 필드 접근
- 슈퍼 클래스의 메소드 호출시 super로 이루어지는 메소드 호출 : 정적 바인딩

## 메소드 오버라이딩(Method Overriding)의 개념
* 서브 클래스에서 슈퍼 클래스의 메소드 중복 작성
* 슈퍼 클래스의 메소드 무력화, 항상 서브 클래스에 오버라이딩한 메소드가 실행되도록 보장됨
* 메소드 무시하기로 번역되기도 함

* **오버라이딩 조건**
  > 슈퍼 클래스 메소드의 원형(메소드 이름, 인자 타입 및 개수, 리턴 타입) 동일하게 작성

## 서브 클래스 객체와 오버라이딩된 메소드 호출
* 오버라이딩 한 메소드가 실행됨을 보장
```java
clas A {
    void f() {
        System.out.println("A의 f() 호출");
    }
} 
class B extends A {
    void f() {
        System.out.println("B의 f() 호출");
    }
}
```

## 오버라이딩의 목적, 다형성 실현
* 오버라이딩으로 다형성 실현
* 하나의 인터페이스(다른 이름)에 서로 다른 구현
* 슈퍼 클래스의 메소드를 서브 클래스에서 `각각 목적에 맞게 다르게 구현`
* 사례 : shape의 draw() 메소드를 Line, Rect Circle에서 오버라이딩하여 다르게 구현

## instanceof 연산자 사용
* 레퍼런스가 가리키는 객체의 타입 식별 : 연산의 결과는 true/false의 불린 값으로 반환

`객체레퍼런스 instanccof 클래스 타입`

```java
Person p = new Professor();

if(p instanceof Person) // true
if(p instanceof Student) // false, Student를 상속받지 않음
if(p instanceof Researcher) // true
if(p instanceof Professor) // true
```
```java
if("java" instanceof String) // true
```

</font>

# (10월 30일 강의)

## 업캐스팅 레퍼런스로 객체 구별?
* 업캐스팅된 레퍼런스로는 객체의 실제 타입을 구분하기 어려움
* 슈퍼 클래스는 여러 서브 클래스에 상속되기 때문

## 다운캐스팅(downcasting)
* 슈퍼 클래스 레퍼런스를 서브 클래스 레퍼런스에 업캐스팅 된 것을 다시 원래대로 되돌리는 것
* 반드시 명시적 타입 변환 지정
```java
class Person { }
class Student extends Person { }

Person p = new Student("이재문"); // 업캐스팅

Student s = (Student)p; // 다운캐스팅
```
`강제 타입 변환`

* 다운캐스팅 사례
```java
public class DowncastingEx {
    static void main(String[] args) {
        Person p = new Student("이재문"); // 업캐스팅
        Student s;
        
        s = (Student)p; // 다운캐스팅

        System.out.println(s.name); // 오류 없음
        s.grade = "A"; // 오류 없음
    }
}
```


## 업캐스팅(upcasting)
* 생물이 들어가는 박스에 사람이나 코끼리를 넣어도 무방
* 사람이나 코끼리 모두 생물을 상속받았기 때문
* 업캐스팅이란?
    - 서브 클래스의 레퍼런스를 슈퍼 클래스 레퍼런스에 대입
    - 슈퍼 클래스 레퍼런스로 서브 클래스 객체를 가리키게 되는 현상

## 업캐스팅(upcasting) 개념
* 하위 클래스의 레퍼런스는 상위 클래스를 가리킬 수 없지만, 상위 클래스의 레퍼런스는 하위 클래스를 가리킬 수 있다는 설명

## 업캐스팅 사례
```java
class Person {
    String name;
    String id;
    public Person(String name) {
        this.name = name;
    }
}
class Student extends Person {
    String grade;
    String department;
    
    public Student(String name) {
        super(name)
    }
}

public class UpcastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("이재문");
        p = s; //업캐스팅 발생
        
        System.out.println(p.name); //오류 없음
        
        p.grade = "A" //컴파일 오류
        p.department = "Com"; // 컴파일 오류
    }
}
```
* `p레퍼런스는 Person 타입이기 때문에 Person의 맴버에만 접근이 가능`
* `p.grade와 p.department는 Person 타입으로 Student의 맴버에 접근하려고 해서 오류`
* `모든 맴버에 접근하려면 s레퍼런스를 이용해야함`

## 그렇다면 왜 p = s로 업케스팅을 한 걸까?
* 이 사례는 업캐스팅의 제한 사항을 설명하기 위한 코드임
* 실제로는 이런 식으로 업캐스팅을 사용하지 않음
* 실제로는 여러 자식 클래스를 하나의 부모 타입으로 다루기 위해 사용함
```java
person[] people = new Person[3];
people[0] = new Student("홍길동");
people[1] = new Student("김영희");
people[2] = new Person("이순신");
```
* 이렇게 하면 공통된 타입(Person)으로 여러 자식 클래스를 한 배열에 담을 수 있음
* 대신 접근은 Person 수준에서만 가능

## super()로 슈퍼 클래스의 생성자 명시적 선택
* super() : 서브 클래스에서 명시적으로 슈퍼 클래스의 생성자 선택 호출
* 사용 방식
* `super(parameter);`
* `인자를 이용하여 슈퍼 클래스의 적당한 생성자 호출`
* `반드시 서브 클래스 생성자 코드의 제일 첫 라인에 와야 함`

## 슈퍼 클래스에 기본 생성자가 없어 오류 난 경우
```java
class A {
    public A(int x) {
        System.out.println("생성자A");
    }
}
```
`B()에 대한 짝, A()를 찾을 수 없음`
```java
class B extends A {
    public B() {
        System.out.println("생성자B");
    }
}
```
```java
public class ConstructorEx2 {
    public static void main(String[] args) {
        B b;
        b = new B;
    }
}
```
        
## 컴파일러에 의해 슈퍼 클래스의 기본 생성자가 묵시적 선택(1)
* 개발자가 서브 클래스의 생성자에 대해 슈퍼 클래스의 생성자를 *명시적으로 선택하지 않은 경우*

`서브 클래스의 기본 생성자에 대해 컴파일러는 자동으로 슈퍼 클래스의 기본 생성자의 짝을 맺음`
## 서브 클래스와 슈퍼 클래스의 생성자 선택
* 슈퍼 클래스와 서브 클래스 : 각각 여러 개의 생성자 작성 가능
* 서브 클래스의 객체가 생성될 때 : 슈퍼 클래스 생성자 1개와 서브 클래스 생성자 1개가 실행
* 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 결정되는 방식
1. 개발자의 영시적 선택
   - 서브 클래스 개발자가 슈퍼 클래스의 생성자 명시적 선택
   - super() 키워드를 이용하여 선택 
2. 컴파일러가 기본 생성자 선택
   - 서브 클래스 개발자가 슈퍼 클래스의 생성자를 선택하지 않는 경우
   - 컴파일러가 자동으로 슈퍼 클래스의 기본 생성자 선택

`서브 클래스의 객체가 생성될 때, 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 모두 실행된다
서브 클래스의 생성자와 슈퍼 클래스의 생성자중 슈퍼 클래스의 생성자가 먼저 실행된다`
## 서브 클래스/슈퍼 클래스의 생성자 호출과 실행
* 서브 클래스의 객체가 생성될 때 : 슈퍼 클래스 생성자와 서브 클래스 생성자 모두 실행
* 호출 순서 : 서브 클래스의 생성자 먼저 호출 -> 슈퍼 클래스 생성자 호출
* 실행 순서 : 슈퍼 클래스의 생성자가 먼저 실행 -> 서브 클래스의 생성자 실행

## 슈퍼 클래스의 맴버에 대한 서브 클래스의 접근
* 슈퍼 클래스의 private 맴버 : 서브 클래스에서 접근할 수 없음
* 슈퍼 클래스의 디폴트 맴버 : 서브 클래스가 동일한 패키지에 있을 때, 접근 가능
* 슈퍼 클래스의 public 맴버 : 서브 클래스는 항상 접근 가능

## 자바 상속의 특징
* 클래스 다중 상속 불허
  * 하나의 클래스가 둘 이상의 부모 클래스를 동시에 상속받는 것을 말합니다.
* `C++는 다중 상속 가능`
* `C++는 다중 상속으로 맴버가 중복 생성되는 문제 있음. (다이아몬드 상속)`
  * 부모 클래스 간에 계층적 관계가 있을 경우, 중복된 맴버가 생성될 수 있습니다.
  * 모호성 문제 : 두 부모 클래스에 동일한 이름의 맴버가 존재할 경우, 어떤 부모의 맴버를 호출해야 할지 모호해집니다.
* 자바는 인터페이스의 다중 상속 허용
  * 다중 상속과 유사한 기능을 제공합니다.
* 모든 자바 클래스는 묵시적으로 Object클래스 상속받음
* `java.lang.Object는 클래스는 모든 클래스의 슈퍼 클래스`
## 서브 클래스 객체의 모양
* 슈퍼 클래스 객체와 서브 클래스의 객체는 별개
* 서브 클래스 객체는 슈퍼 클래스 맴버 포함

## 상속의 필요성
* 상속이 없는 경우 중복된 맴버를 가진 4개의 클래스
* 상속을 이용한 경우 중복이 제거되고 간결해진 클래스 구조

## 클래스 상속과 객체
* 상속 선언 : extends 키워드 사용
* 부모 클래스를 물려받아 자식 클래스를 확장한다는 의미
* 부모 클래스 -> 슈퍼 클래스
* 자식 클래스 -> 서브 클래스
* colorPoint는 Point를 물려 받으므로, Point에 선언된 필드와 메소드 선언 필요 없음

## 메소드의 제약 조건1
* static 메소드는 오직 static 맴버만 접근 가능
* 객체가 생성되지 않은 상황에서도 static 메소드는 실행될 수 있기 때문에, non-static 맴버 활용 불가

## 메소드의 제약 조건2
* static 메소드는 this 사용불가
* static 메소드는 객체 없이도 사용 가능하므로, this 레퍼런스 사용할 수 없음

## 클래스와 메소드
* final 클래스 - 더 이상 클래스 상속 불가능
* final 메소드 - 더 이상 오버라이딩 불가능

## final 필드
* final 필드 : 상수를 선언할 때 사용
* 상수 필드는 선언 시에 초기 값을 지정하여야 한다.
* 상수 필드는 실행 중에 값을 변경할 수 없다.

***
# (9월4일 강의)
# Markdown 문법
HTML에서 <h1> ~ <h6>

# 글자 크기
## 글자 크기
### 글자 크기
#### 글자 크기
##### 글자 크기
###### 글자 크기

문자 강조

이텔릭체

*자바 코딩*<br><br>
**굵은 문자**

수평선
***

## 리스트
* 언오더드 리스트
    * 언오더드 리스트
        * 언오더드 리스트

1. 오더드 리스트
    1. 오더드 리스트
        1. 오더드 리스트

## 코드 블럭
```java
public class HelloWorldApp {
    public static void main(String[] args) {
        System.out.println("Hello World!!");
    }
}
```
## 인라인 코드

`물결표 쪽에 있는거`

# 링크
## 외부 링크

[구글](https://www.google.com/?hl=ko "구글 주소" )

## 내부 링크
[링크 라벨](#리스트 "리스트")

# 이미지 삽입
![로고](data:image/png;base64,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 "깃")

