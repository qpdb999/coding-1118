
/*
와일드카드(Wildcard)

    오늘 배운 내용

이번에는 자바 제네릭에서 사용하는 와일드카드(Wildcard)에 대해 배웠다.

와일드카드는 물음표(?)를 사용하여 정확한 자료형을 지정하지 않고
여러 종류의 자료형을 유연하게 처리할 수 있도록 도와주는 기능이다.

제네릭에서 자료형을 지정할 때 사용하며,
상황에 따라 상한 제한과 하한 제한을 설정할 수도 있다.

와일드카드는 주로 제네릭 메서드의 매개변수에서 사용한다.


    정의

와일드카드(Wildcard)란 제네릭에서 특정 자료형을 고정하지 않고
알 수 없는 자료형을 나타내기 위해 사용하는 기호이다.

와일드카드는 ? 기호로 표현하며 대표적으로 세 가지 형태가 있다.

1) <?>
자료형에 제한을 두지 않는 와일드카드이다.
어떤 자료형이든 전달받을 수 있다.

2) <? extends T>
T와 T의 자식 타입만 사용할 수 있도록 제한하는 상한 제한이다.

3) <? super T>
T와 T의 부모 타입만 사용할 수 있도록 제한하는 하한 제한이다.


    사용 방법

1. 기본 와일드카드 <?>

import java.util.ArrayList;

public class Main {

    public static void printList(ArrayList<?> list) {

        for (Object value : list) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("철수");
        names.add("영희");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);

        printList(names);
        printList(numbers);
    }
}

<?>를 사용하면 String이나 Integer처럼
서로 다른 자료형의 ArrayList를 같은 메서드로 처리할 수 있다.

다만 정확한 자료형을 알 수 없기 때문에
일반적으로 값을 가져올 때 Object 타입으로 사용한다.


2. 상한 제한 <? extends T>

import java.util.ArrayList;

class Animal {
    void sound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("멍멍!");
    }
}

public class Main {

    public static void printAnimals(ArrayList<? extends Animal> list) {

        for (Animal animal : list) {
            animal.sound();
        }
    }

    public static void main(String[] args) {

        ArrayList<Dog> dogs = new ArrayList<>();

        dogs.add(new Dog());
        dogs.add(new Dog());

        printAnimals(dogs);
    }
}

<? extends Animal>은 Animal과 Animal의 자식 타입을
자료형으로 사용할 수 있도록 제한한다.

따라서 Animal뿐만 아니라 Dog와 같은 자식 클래스의
ArrayList도 전달할 수 있다.

이러한 방식은 여러 자식 클래스의 데이터를
부모 클래스 기준으로 읽을 때 유용하다.


3. 하한 제한 <? super T>

import java.util.ArrayList;

class Animal {
}

class Dog extends Animal {
}

public class Main {

    public static void addDogs(ArrayList<? super Dog> list) {

        list.add(new Dog());
    }

    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        addDogs(animals);

        System.out.println(animals.size());
    }
}

<? super Dog>는 Dog와 Dog의 부모 타입을
자료형으로 사용할 수 있도록 제한한다.

따라서 ArrayList<Dog>뿐만 아니라
ArrayList<Animal>에도 Dog 객체를 추가할 수 있다.


    코드 분석

기본 와일드카드 <?>는 자료형에 제한을 두지 않기 때문에
다양한 제네릭 자료형을 하나의 메서드에서 처리할 수 있다.

<? extends T>는 T와 그 자식 타입을 허용하므로
데이터를 읽고 부모 타입으로 활용할 때 유용하다.

<? super T>는 T와 그 부모 타입을 허용하므로
특정 타입의 데이터를 컬렉션에 추가할 때 유용하다.

와일드카드는 제네릭의 활용 범위를 넓혀 주지만,
자료형을 제한하는 방식에 따라 사용할 수 있는 작업이 달라진다.


    알게 된 점

이번 학습을 통해 제네릭에서 사용하는 물음표(?)가
단순한 기호가 아니라 자료형을 유연하게 처리하기 위한
와일드카드라는 것을 알게 되었다.

특히 extends와 super를 이용하면 자료형의 범위를
부모 클래스와 자식 클래스 관계에 따라 제한할 수 있다는 점이 흥미로웠다.

처음에는 세 가지 방식의 차이가 헷갈렸지만,
extends는 상한 제한, super는 하한 제한이라는 점을 이해했다.


📌 AI 활용 복습 문제

1) 와일드카드는 어떤 기호를 사용하는가?

정답: 물음표(?)를 사용한다.

2) <?>의 의미는 무엇인가?

정답: 특정 자료형을 제한하지 않고 다양한 제네릭 자료형을
전달받을 수 있다는 의미이다.

3) <? extends Animal>은 어떤 자료형을 허용하는가?

정답: Animal과 Animal의 자식 타입을 허용한다.

4) <? super Dog>는 어떤 자료형을 허용하는가?

정답: Dog와 Dog의 부모 타입을 허용한다.

5) extends와 super의 차이점은 무엇인가?

정답:
extends는 지정한 타입과 자식 타입을 허용하는 상한 제한이고,
super는 지정한 타입과 부모 타입을 허용하는 하한 제한이다.
*/
